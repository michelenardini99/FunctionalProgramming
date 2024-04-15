package ex2

import org.junit.*
import org.junit.Assert.*

class ConferenceReviewingTest:

    val cr = ConferenceReviewing()
    // carico una revisione per l'articolo 1:
    // - 8 per relevance, significance e final
    // - 7 per confidence
    // si ricordi che l'ordine delle domande è: relevance, significance, confidence, final
    cr.loadReview(1, 8, 8, 6, 8); // 4.8 è il voto finale pesato (usato da averageWeightedFinalScoreMap)
    // e simile per gli altri
    cr.loadReview(1, 9, 9, 6, 9); // 5.4 
    cr.loadReview(2, 9, 9, 10, 9); // 9.0
    cr.loadReview(2, 4, 6, 10, 6); // 6.0
    cr.loadReview(3, 3, 3, 3, 3); // 0.9
    cr.loadReview(3, 4, 4, 4, 4); // 1.6
    cr.loadReview(4, 6, 6, 6, 6); // 3.6
    cr.loadReview(4, 7, 7, 8, 7); // 5.6
    val map: Map[Question, Int] = Map(
        (Question.Relevance, 8),
        (Question.Significance, 8),
        (Question.Confidence, 7),
        (Question.Final, 8)
    )
    cr.loadReview(4,map);
    cr.loadReview(5, 6, 6, 6, 10); // 6.0
    cr.loadReview(5, 7, 7, 7, 10); // 7.0

    @Test def testOrderedScores() = 
        // l'articolo 2 ha preso su RELEVANCE i due voti 4,9
        assertEquals(cr.orderedScores(2, Question.Relevance), List(4, 9))
        assertEquals(cr.orderedScores(4, Question.Confidence), List(6, 7, 8))
        assertEquals(cr.orderedScores(5, Question.Final), List(10, 10))

    @Test def testAverageFinalScore() =
        assertEquals(cr.averageFinalScore(1),8.5,0.01)
        assertEquals(cr.averageFinalScore(2),7.5,0.01)
        assertEquals(cr.averageFinalScore(3),3.5,0.01)
        assertEquals(cr.averageFinalScore(4),7.0,0.01)
        assertEquals(cr.averageFinalScore(5),10.0,0.01)

    @Test def testAcceptedArticles() =
		// solo gli articoli 1,2,4 vanno accettati, avendo media finale >=5 e almeno un voto su RELEVANCE >= 8
        assertEquals(cr.acceptedArticles(),Set(1,2,4))

    @Test def testSortedAcceptedArticles() =
        assertEquals(cr.sortedAcceptedArticles(),List((4, 7.0), (2, 7.5), (1, 8.5)))

    @Test def optionalTestAverageWeightedFinalScore() =
        assertEquals(cr.averageWeightedFinalScoreMap().get(1), (4.8 + 5.4) / 2)
        assertEquals(cr.averageWeightedFinalScoreMap().get(2), (9.0 + 6.0) / 2)
		// e simile per gli altri
        assertEquals(cr.averageWeightedFinalScoreMap().get(3),(0.9+1.6)/2)

		
		
	
	
	

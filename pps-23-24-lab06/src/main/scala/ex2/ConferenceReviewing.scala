package ex2

import ex1.List.*
import scala.compiletime.ops.boolean
import java.util.Collections
import java.util.stream.Collectors

enum Question:
    case Relevance
    case Significance
    case Confidence
    case Final

trait ConferenceReviewing:
    def loadReview(article: Int, scores: Map[Question, Int]): Unit
    def loadReview(article: Int, relevance: Int, significance: Int, confidence: Int, fin: Int): Unit
    def orderedScores(article: Int, question: Question): List[Int]
    def averageFinalScore(article: Int): Double
    def acceptedArticles(): Set[Int]
    def sortedAcceptedArticles(): List[(Int, Double)]
    def averageWeightedFinalScoreMap(): Map[Int, Double]

object ConferenceReviewing:
    def apply(): ConferenceReviewing = ConferenceReviewingImpl()
    
class ConferenceReviewingImpl extends ConferenceReviewing: 

    var _reviews: List[(Int, Map[Question, Int])] = List.empty

    def reviews(): List[(Int, Map[Question, Int])]  = _reviews

    override def sortedAcceptedArticles(): List[(Int, Double)] = 
        acceptedArticles().map(e => (e, averageFinalScore(e))).toList.sortWith((e1, e2) => e1._2 < e2._2)

    private def accepted(article: Int): Boolean = 
        averageFinalScore(article) > 5 &&
        _reviews.filter(_._1 == article)
                .flatMap(_._2.toSet)
                .exists({
                    case (key, value) => key == Question.Relevance && value >= 8
                })

    override def acceptedArticles(): Set[Int] = 
        _reviews.map(p => p._1)
                .distinct
                .filter(p => accepted(p))
                .toSet

    def averageWeightedFinalScore(article: Int): Double = 
        var finalScores = _reviews.filter(p => p._1 == article)
                .map(p => p._2.get(Question.Final).get * p._2.get(Question.Confidence).get / 10.0)
        if (!finalScores.isEmpty) then (finalScores.sum.toDouble / finalScores.size).toDouble
        else 0.0
        
                

    override def averageWeightedFinalScoreMap(): Map[Int, Double] = 
        _reviews.map(p => p._1)
                .distinct
                .map(p => (p, averageFinalScore(p)))
                .toMap


    override def loadReview(article: Int, relevance: Int, significance: Int, confidence: Int, fin: Int): Unit = 
        var map = Map(
            (Question.Relevance, relevance),
            (Question.Significance, significance),
            (Question.Confidence, confidence),
            (Question.Final, fin)
        )
        loadReview(article, map)

    override def loadReview(article: Int, scores: Map[Question, Int]): Unit = 
        if(scores.size < Question.values.length) then throw new IllegalArgumentException()
        else _reviews = _reviews.appended((article, scores))
    

    override def averageFinalScore(article: Int): Double = 
        val finalScores = _reviews.filter(x => x._1 == article)
                .map(p => p._2.get(Question.Final).get)
        if (!finalScores.isEmpty) then finalScores.sum.toDouble / finalScores.size
        else 0.0
                
                

    override def orderedScores(article: Int, question: Question): List[Int] = _reviews.collect({
        case x if x._1 == article => x._2.get(question).get
    }).sorted
    


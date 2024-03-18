package tasks

import org.junit.*
import org.junit.Assert.*
import u03.extensionmethods.Optionals.Optional.*
import u03.Optionals.Optional.orElse
import u03.Optionals.Optional

class Task1Test:

    import tasks.Tasks.* 
    import Sequence.*
    import Person.*
  

    val lst: Sequence[Int] = Cons(10, Cons(20, Cons(30, Nil())))

    @Test def testTake() = 
        assertEquals(Cons(10, Cons(20, Nil())), take(lst)(2))

    @Test def testTakeZeroElement() = 
        assertEquals(Nil(), take(lst)(0))

    @Test def testTakeMoreElementThanListContains() = 
        assertEquals(lst, take(lst)(5))

    @Test def testZipList() = 
        val lst1: Sequence[Int] = Cons(10, Cons(20, Cons(30, Nil())))
        val lst2: Sequence[String] = Cons("a", Cons("b", Cons("c", Nil())))
        assertEquals(Cons((10, "a"), Cons((20, "b"), Cons((30, "c"), Nil()))), zip(lst1, lst2))

    @Test def testConcatTwoList() = 
        val lst1 = Cons(10, Cons(20, Nil()))
        val lst2 = Cons(30, Cons(40, Nil()))
        assertEquals(Cons(10, Cons(20, Cons(30, Cons(40, Nil())))), concat(lst1, lst2))

    @Test def testFlatMap() = 
        assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))),
                     flatMap(lst)(v => Cons(v + 1, Cons(v + 2, Nil()))))

    @Test def testMapInTermsOfFlatMap() = 
        assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), map(lst)(v => v + 1))

    @Test def testMinValueInFunction() = 
        assertEquals(orElse(Optional.Just(10), 0), orElse(min(lst), 0))

    @Test def testGetSequenceOfCoursesFromPersonSequence() = 
        val persons: Sequence[Person] = Cons(Person.Teacher("Claudia", "Storia"),
                                        Cons(Person.Teacher("Luca", "Matematica"),
                                        Cons(Person.Student("Riccardo", 1999),
                                        Cons(Person.Teacher("Raffaelle", "Geografia"),
                                        Cons(Person.Student("Michele", 1998), Nil())))))
        val courses: Sequence[String] = Cons("Storia", Cons("Matematica", Cons("Geografia", Nil())))
        assertEquals(courses, getCoursesFromPersonSequence(persons))

    

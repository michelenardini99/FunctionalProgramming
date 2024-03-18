
import org.junit.*
import org.junit.Assert.*
import Task1.Sequence

class Task1Test:

    import Task1.Sequence.*

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


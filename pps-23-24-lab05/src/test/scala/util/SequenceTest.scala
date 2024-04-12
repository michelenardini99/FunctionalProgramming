package util

import org.junit.*
import org.junit.Assert.*
import util.Optionals.Optional.*
import util.Sequences.Sequence
class SequenceTest:
  @Test
  def testConcat(): Unit =
    val s1 = Sequence(1, 2, 3)
    val s2 = Sequence(4, 5, 6)
    assertEquals(s1.concat(s2), Sequence(1, 2, 3, 4, 5, 6))
    assertEquals(Sequence.Nil().concat(s1), s1)
    assertEquals(s1.concat(Sequence.Nil()), s1)
    assertEquals(Sequence.Nil().concat(Sequence.Nil()), Sequence.Nil())

  @Test
  def testFlatMap(): Unit =
    val s = Sequence(1, 2, 3)
    assertEquals(s.flatMap(x => Sequence(x, x + 1)), Sequence(1, 2, 2, 3, 3, 4))
    assertEquals(Sequence.Nil().flatMap(x => Sequence(x)), Sequence.Nil())

  @Test
  def testMap(): Unit =
    val s = Sequence(1, 2, 3)
    assertEquals(s.map(_ + 1), Sequence(2, 3, 4))
    assertEquals(Sequence.Nil().map(identity), Sequence.Nil())

  @Test
  def testFilter(): Unit =
    val s = Sequence(1, 2, 3, 4, 5)
    assertEquals(s.filter(_ % 2 == 0), Sequence(2, 4))
    assertEquals(Sequence.Nil().filter(_ => true), Sequence.Nil())

  @Test
  def testFind(): Unit =
    val s = Sequence(1, 2, 3, 4, 5)
    assertEquals(s.find(_ % 2 == 0), Just(2))
    assertEquals(s.find(_ % 2 == 1), Just(1))
    assertEquals(s.find(_ > 5), Empty())
    assertEquals(Sequence.Nil().find(_ => true), Empty())

  @Test
  def testContains(): Unit =
    val s = Sequence(1, 2)
    assertTrue(s.contains(1))
    assertTrue(s.contains(2))
    assertFalse(Sequence.Nil().contains(1))

package u02

import org.junit.*
import org.junit.Assert.*

class OptionTestImproved:

  // imports needed to work with Options
  import u03.Optionals.*
  import Optional.*

  // values under test
  val optVal = 5
  val optSome = Just(optVal)
  val optNone = Empty()

  @Test def testEmpty() =
    assertFalse(isEmpty(optSome))
    assertTrue(isEmpty(optNone))

  @Test def testOrElse() =
    val otherVal = 10
    assertEquals(optVal, orElse(optSome, otherVal))
    assertEquals(otherVal, orElse(optNone, otherVal))

  @Test def testMap() =
    assertEquals(Just(optVal + 1), map(optSome)(_ + 1))
    assertEquals(Just("val: " + optVal), map(optSome)(v => "val: " + v))
    assertEquals(Empty(), map(optNone)(v => "val: " + v))

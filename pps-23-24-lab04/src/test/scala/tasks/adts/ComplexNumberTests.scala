package tasks.adts

import org.junit.*
import org.junit.Assert.*
import u04lab.Ex1ComplexNumbers.*

/* Tests should be clear, but note they are expressed independently of the 
   specific implementation
*/

class ComplexTest:

  // Choice of implementation to test
  val complexADT: ComplexADT = BasicComplexADT
  import complexADT.*

  // From now, everything is independent of specific implementation of Complex

  @Test def testReal() =
    assertEquals(10, complex(10, 20).re())

  @Test def testImaginary() =
    assertEquals(20, complex(10, 20).im())

  @Test def testSum() =
    assertEquals(complex(11, 22), complex(10, 20) sum complex(1, 2))

  @Test def testSubtract() =
    assertEquals(complex(11, 22), complex(10, 20) subtract complex(1, 2))

  @Test def testAsString() =
    assertEquals("10.0 + 5.0i", complex(10.0, 5.0))

  @Test def optionalTestAdvancedAsString() =
    assertEquals("0.0", complex(0, 0))
    assertEquals("10.0", complex(10.0, 0))
    assertEquals("10.0 + 5.0i", complex(10.0, 5.0))
    assertEquals("10.0 - 5.0i", complex(10.0, -5.0))
    assertEquals("5.0i", complex(0, 5.0))
    assertEquals("-5.0i", complex(0, -5.0))
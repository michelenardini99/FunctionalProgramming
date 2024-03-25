file://<WORKSPACE>/src/test/scala/tasks/adts/ComplexNumberTests.scala
### dotty.tools.dotc.ast.Trees$UnAssignedTypeException: type of Apply(Select(New(Ident(Test)),<init>),List()) is not assigned

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/test-classes-Metals-b8FQ3BJfT6ezjwizY_fOBA== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-b8FQ3BJfT6ezjwizY_fOBA== [exists ], <WORKSPACE>/lib/junit-platform-console-standalone-1.10.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/github/sbt/junit-interface/0.13.2/junit-interface-0.13.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 419
uri: file://<WORKSPACE>/src/test/scala/tasks/adts/ComplexNumberTests.scala
text:
```scala
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

  @T@@est def testReal() =
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
```



#### Error stacktrace:

```
dotty.tools.dotc.ast.Trees$Tree.tpe(Trees.scala:72)
	scala.meta.internal.mtags.MtagsEnrichments$.tryTail$1(MtagsEnrichments.scala:329)
	scala.meta.internal.mtags.MtagsEnrichments$.expandRangeToEnclosingApply(MtagsEnrichments.scala:346)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:352)
```
#### Short summary: 

dotty.tools.dotc.ast.Trees$UnAssignedTypeException: type of Apply(Select(New(Ident(Test)),<init>),List()) is not assigned
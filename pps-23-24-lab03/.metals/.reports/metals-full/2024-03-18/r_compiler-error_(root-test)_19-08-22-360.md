file://<WORKSPACE>/src/test/scala/tasks/Task1Test.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/test-classes-Metals-FdHLvYveR3CDCg1hWO7PWA== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-FdHLvYveR3CDCg1hWO7PWA== [exists ], <WORKSPACE>/lib/junit-platform-console-standalone-1.10.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/github/sbt/junit-interface/0.13.2/junit-interface-0.13.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 2384
uri: file://<WORKSPACE>/src/test/scala/tasks/Task1Test.scala
text:
```scala
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

    @Test def testFoldLeft() = 
        val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
        assertEquals(-16, foldLeft(lst)(0)(_ - _))

    @Test def testTakeAWhile() = 
        val s = s.iterate(0)(@@)

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:398)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0
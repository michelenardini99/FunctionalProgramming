file://<WORKSPACE>/src/main/scala/tasks/monads/Ex6TryModel.scala
### java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      =  extends Monad[Try] {
  override def unit[A](value: A): Try[A] = TryImpl.Success(value)
  extension [A](m: Try[A])
    override def flatMap[B](f: (A) => Try[B]): Try[B] = m mCURSOR null
} # -1,
parent span = <1134..1314>,
child       = extension [A](m: Try[A])
  override def flatMap[B](f: (A) => Try[B]): Try[B] = m mCURSOR null # -1,
child span  = [1222..1322]

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-46yjQi_CTZSoONZ7qqLxHg== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <WORKSPACE>/lib/junit-platform-console-standalone-1.10.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 1308
uri: file://<WORKSPACE>/src/main/scala/tasks/monads/Ex6TryModel.scala
text:
```scala
package tasks.monads

import u04.monads.Monads.Monad
import u04.monads.Monads.Monad

/**
  * Exercise 6: 
    This module contains the implementation of a Try monad, which is a monad that 
    represents a computation that may fail. 
    Try to follow these steps:
    - Look at the implementation of Try, that is similar to the one of Optional
    - Try go define the Monad instance for Try
      - flatMap should consider only the Success case
      - in case of Failure, it should return the exception (fail fast)
    - Verify that the main works as expected
  */
object Ex6TryModel:
  private enum TryImpl[A]:
    case Success(value: A)
    case Failure(exception: Throwable)

  opaque type Try[A] = TryImpl[A]

  def success[A](value: A): Try[A] = TryImpl.Success(value)
  def failure[A](exception: Throwable): Try[A] = TryImpl.Failure(exception)
  def exec[A](expression: => A): Try[A] = 
    try success(expression)
    catch case e: Throwable => failure(e)

  extension [A](m: Try[A]) 
    def getOrElse[B >: A](other: B): B = m match
      case TryImpl.Success(value) => value
      case TryImpl.Failure(_) => other

  given Monad[Try] with
    override def unit[A](value: A): Try[A] = TryImpl.Success(value)
    extension [A](m: Try[A]) 

      override def flatMap[B](f: A => Try[B]): Try[B] = m m@@
      
@main def main: Unit = 
  import Ex6TryModel.*

  val result = for 
    a <- success(10)
    b <- success(30)
  yield a + b

  assert(result.getOrElse(-1) == 40)

  val result2 = for 
    a <- success(10)
    b <- failure(new RuntimeException("error"))
    c <- success(30)
  yield a + c

  assert(success(20).map(_ + 10).getOrElse(-1) == 30)
  assert(result2.getOrElse(-1) == -1)

  val result3 = for
    a <- exec(10)
    b <- exec(new RuntimeException("error"))
    c <- exec(30)
  yield a + c
```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:175)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:205)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:205)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:205)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:205)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:205)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:205)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:38)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$adapted$1(ParserPhase.scala:39)
	scala.Function0.apply$mcV$sp(Function0.scala:42)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:440)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:39)
	dotty.tools.dotc.parsing.Parser.runOn$$anonfun$1(ParserPhase.scala:48)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:48)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:246)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1321)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:262)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:270)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:279)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:67)
	dotty.tools.dotc.Run.compileUnits(Run.scala:279)
	dotty.tools.dotc.Run.compileSources(Run.scala:194)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:165)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:46)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      =  extends Monad[Try] {
  override def unit[A](value: A): Try[A] = TryImpl.Success(value)
  extension [A](m: Try[A])
    override def flatMap[B](f: (A) => Try[B]): Try[B] = m mCURSOR null
} # -1,
parent span = <1134..1314>,
child       = extension [A](m: Try[A])
  override def flatMap[B](f: (A) => Try[B]): Try[B] = m mCURSOR null # -1,
child span  = [1222..1322]
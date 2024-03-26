file://<WORKSPACE>/src/main/scala/tasks/typeclasses/Ex5Traversable.scala
### dotty.tools.dotc.core.TypeError$$anon$1: bad parameter reference T at typer
the parameter is type T in trait Traversable but the prefix <noprefix>
does not define any corresponding arguments.
idx = 0, args = ,
constraint =  uninstantiated variables:
 constrained types:
 bounds:
 ordering:
 co-deps:
 contra-deps:


occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<WORKSPACE>/.bloop/root/bloop-bsp-clients-classes/classes-Metals-46yjQi_CTZSoONZ7qqLxHg== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <WORKSPACE>/lib/junit-platform-console-standalone-1.10.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 1081
uri: file://<WORKSPACE>/src/main/scala/tasks/typeclasses/Ex5Traversable.scala
text:
```scala
package u04lab
import u03.Sequences.* 
import Sequence.*
import u03.Optionals.Optional.*
import u03.Optionals.*

/*  Exercise 5: 
 *  - Generalise by ad-hoc polymorphism logAll, such that:
 *  -- it can be called on Sequences but also on Optional, or others... 
 *  -- it does not necessarily call log, but any function with analogous type
 *  - Hint: introduce a type class Traversable[T[_]]], capturing the ability of calling a
 *    "consumer function" on all elements (with type A) of a datastructure T[A] 
 *    Note Traversable is a 2-kinded trait (similar to Filterable, or Monad)
 *  - Write givens for Traversable[Optional] and Traversable[Sequence]
 *  - Show you can use the generalisation of logAll to:
 *  -- log all elements of an Optional, or of a Traversable
 *  -- println(_) all elements of an Optional, or of a Traversable
 */

object Ex5Traversable:

  def log[A](a: A): Unit = println("The next element is: "+a)

  def logAll[A](seq: Sequence[A]): Unit = seq match
    case Cons(h, t) => log(h); logAll(t)
    case _ => ()

  trait Traversable[T[_]]:
    def l@@ogAll[A](container: T[A])(consumer: A => Unit): Unit
  
  object TraversableOptional extends Traversable[Optional]:
    def traverse[A](container: Optional[A])(consumer: A => Unit): Unit = container match
      case Just(v) => consumer(v)
      case _ => ()

  object TraversableSequence extends Traversable[Sequence]:
    def logAll[A](container: Sequence[A])(consumer: A => Unit): Unit = container match
      case Cons(h, t) => consumer(h); logAll(t)(consumer)
      case Nil() => ()

  @main def tryTraversable =
    val si = Cons(10, Cons(20, Cons(30, Nil())))
    TraversableSequence.logAll(si)(log)

    val opt = Just(10)
    TraversableOptional.logAll(opt)(log)






```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: bad parameter reference T at typer
the parameter is type T in trait Traversable but the prefix <noprefix>
does not define any corresponding arguments.
idx = 0, args = ,
constraint =  uninstantiated variables:
 constrained types:
 bounds:
 ordering:
 co-deps:
 contra-deps:

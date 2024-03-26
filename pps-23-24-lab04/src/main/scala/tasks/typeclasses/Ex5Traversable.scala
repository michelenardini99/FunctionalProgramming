package u04lab
import u03.Sequences.* 
import u03.Sequences.Sequence.*
import u03.Optionals.Optional.*
import u03.Optionals.*
import u03.Sequences

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

  def logAll[T[_], A](container: T[A])(consumer: A => Unit)(using traversable: Traversable[T]): Unit = 
    traversable.traverse(container)(consumer)

  trait Traversable[T[_]]:
    def traverse[A](container: T[A])(consumer: A => Unit): Unit
  
  given Traversable[Optional] with
    def traverse[A](container: Optional[A])(consumer: A => Unit): Unit = container match
      case Just(v) => consumer(v)
      case _ => ()

  given Traversable[Sequence] with
    def traverse[A](container: Sequence[A])(consumer: A => Unit): Unit = container match
      case Cons(h, t) => consumer(h); traverse(t)(consumer)
      case Nil() => ()

  @main def tryTraversable =
    val sequence = Cons(10, Cons(20, Cons(30, Nil())))
    logAll(sequence)(log)

    val optional: Optional[String] = Optional.Just("Hello, world!")
    logAll(optional)(log)





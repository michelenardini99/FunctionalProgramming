package u03.extensionmethods

object Optionals:

  enum Optional[A]:
    case Just(a: A)
    case None() // here parens are needed because of genericity

  object Optional:

    extension [A](opt: Optional[A])
      def isEmpty(): Boolean = opt match
        case None() => true
        case _       => false

      def orElse[B >: A](orElse: B): B = opt match
        case Just(a) => a
        case _       => orElse

      def map[B](f: A => B): Optional[B] = opt match
        case Just(a) => Just(f(a))
        case _       => None()

@main def tryOptionals =
  import Optionals.* // importing to work with Optionals
  import Optional.* // importing to directly access algorithms

  val s1: Optional[Int] = Just(1)
  val s2: Optional[Int] = None()

  println(s1) // Some(1)
  // println(isEmpty(s1)) // false
  println(s1.orElse(0)) // 1
  println(s2.orElse(0)) // 0
  println(s1.map(i => "val: " + 1)) // Some("val: 1")
  println(s2.map(i => "val: " + 1)) // None

import u03.Optionals.Optional


object Task1:

  enum Sequence[E]:
      case Cons(head: E, tail: Sequence[E])
      case Nil()

  object Sequence:

    def sum(l: Sequence[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _          => 0

    def map[A, B](l: Sequence[A])(mapper: A => B): Sequence[B] = l match
      case Cons(h, t) => Cons(mapper(h), map(t)(mapper))
      case Nil()      => Nil()

    def filter[A](l1: Sequence[A])(pred: A => Boolean): Sequence[A] = l1 match
      case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
      case Cons(_, t)            => filter(t)(pred)
      case Nil()                 => Nil()

    // Lab 03
    def zip[A, B](first: Sequence[A], second: Sequence[B]): Sequence[(A, B)] = ???

    def take[A](l: Sequence[A])(n: Int): Sequence[A] = l match
      case Cons(h, t) if (n != 0) => Cons(h, take(t)(n-1))
      case _                 => Nil()
    
    
    def concat[A](l1: Sequence[A], l2: Sequence[A]): Sequence[A] = ???
    def flatMap[A, B](l: Sequence[A])(mapper: A => Sequence[B]): Sequence[B] = ???

    def min(l: Sequence[Int]): Optional[Int] = ???
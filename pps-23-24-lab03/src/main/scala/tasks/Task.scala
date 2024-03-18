package tasks

import u03.Optionals.Optional.*
import u03.Optionals.Optional
import tasks.Tasks.Sequence.flatMap
import tasks.Tasks.Sequence.filter
import tasks.Tasks.Person.isStudent
import tasks.Tasks.Person.course



object Tasks:

  //Task 1

  enum Sequence[E]:
      case Cons(head: E, tail: Sequence[E])
      case Nil()

  object Sequence:

    def sum(l: Sequence[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _          => 0

    def map[A, B](l: Sequence[A])(mapper: A => B): Sequence[B] = l match
      case Cons(h, t) => flatMap(l)(v => Cons(mapper(v), Nil()))
      case _          => Nil()

    def filter[A](l1: Sequence[A])(pred: A => Boolean): Sequence[A] = l1 match
      case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
      case Cons(_, t)            => filter(t)(pred)
      case _                     => Nil()

    def zip[A, B](first: Sequence[A], second: Sequence[B]): Sequence[(A, B)] = (first, second) match
      case (Cons(h1, t1), Cons(h2, t2)) => Cons((h1, h2), zip(t1, t2))
      case (Nil(), Nil())               => Nil()
      case (_, _ )                      => throw new Exception("Sequence with different length")
    

    def take[A](l: Sequence[A])(n: Int): Sequence[A] = l match
      case Cons(h, t) if (n != 0) => Cons(h, take(t)(n-1))
      case _                      => Nil()
    
    
    def concat[A](l1: Sequence[A], l2: Sequence[A]): Sequence[A] = (l1, l2) match
      case (Cons(h1, t1), l2)     => Cons(h1, concat(t1, l2))
      case (Nil(), Cons(h2, t2))  => Cons(h2, t2)
      case (_, _)                 => Nil()
    
    def flatMap[A, B](l: Sequence[A])(mapper: A => Sequence[B]): Sequence[B] = l match
      case Cons(h, t) => concat(mapper(h), flatMap(t)(mapper))
      case _          => Nil()
      
    
    def min(l: Sequence[Int]): Optional[Int] = l match
      case Cons(h, t) if filter(t)(v => v < h) == Nil() => Just(h)
      case Cons(h, t)                                   => min(filter(t)(v => v < h))
      case _                                            => Just(0)

    //task 2
    def getCoursesFromPersonSequence(p: Sequence[Person]): Sequence[String] = p match
      case Cons(h, t) => map(filter(p)(p => !isStudent(p)))(p => course(p))
      case _          => Nil()

    def foldLeft(l: Sequence[Int])(value: Int)(mapper: (Int, Int) => Int): Int = l match
      case Cons(h, t) => foldLeft(t)(mapper(value, h))(mapper) 
      case _          => value


  enum Person:
    case Student(name: String, year: Int)
    case Teacher(name: String, course: String)

  object Person:

    import Sequence.*

    def name(p: Person): String = p match
      case Student(n, _)  => n
      case Teacher(n, _)  => n

    def course(p: Person): String = p match
      case Teacher(_, c)  => c
      case _              => "none"


    def isStudent(p: Person): Boolean = p match
      case Student(_, _)  => true
      case _  => false

  enum Stream[A]:
    private case Empty()
    private case Cons(head: () => A, tail: () => Stream[A])

  object Stream:

    def empty[A](): Stream[A] = Empty()

    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] =
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)

    def toList[A](stream: Stream[A]): Sequence[A] = stream match
      case Cons(h, t) => Sequence.Cons(h(), toList(t()))
      case _ => Sequence.Nil()

    def map[A, B](stream: Stream[A])(f: A => B): Stream[B] = stream match
      case Cons(head, tail) => cons(f(head()), map(tail())(f))
      case _ => Empty()

    def filter[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match
      case Cons(head, tail) if (pred(head())) => cons(head(), filter(tail())(pred))
      case Cons(head, tail) => filter(tail())(pred)
      case _ => Empty()

    def take[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match
      case (Cons(head, tail), n) if n > 0 => cons(head(), take(tail())(n - 1))
      case _ => Empty()

    def iterate[A](init: => A)(next: A => A): Stream[A] =
      cons(init, iterate(next(init))(next))

    // Task 3

    def takeWhile[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match
      case Cons(head, tail) if pred(head()) => cons(head(), takeWhile(tail())(pred))
      case _                                => Empty()
  
    def fill[A](n: Int)(v: A): Stream[A] = n match
      case n if n > 0 => cons(v, fill(n - 1)(v))
      case _          => Empty()
    
    

    
error id: file://<WORKSPACE>/src/main/scala/tasks/Task.scala:[2200..2200) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/tasks/Task.scala", "package tasks

import u03.Optionals.Optional.*
import u03.Optionals.Optional



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
      case Nil()      => Nil()

    def filter[A](l1: Sequence[A])(pred: A => Boolean): Sequence[A] = l1 match
      case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
      case Cons(_, t)            => filter(t)(pred)
      case Nil()                 => Nil()

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
      case Nil()      => Nil()
      case Cons(h, t) => concat(mapper(h), flatMap(t)(mapper))
    

    //task2
    def min(l: Sequence[Int]): Optional[Int] = l match
      case Cons(h, t) if filter(t)(v => v < h) == Nil() => Just(h)
      case Cons(h, t)                                   => min(filter(t)(v => v < h))
      case Nil()                                        => Just(0)
      
  //Task 3

  enum Person:
    case Student(name: String, year: Int)
    case Teacher(name: String, course: String)

  object Person:
    def name(p: Person): String = p match
      case Student(n, _)  => n
      case Teacher(n, _)  => n

    def 
      
")
file://<WORKSPACE>/src/main/scala/tasks/Task.scala
file://<WORKSPACE>/src/main/scala/tasks/Task.scala:71: error: expected identifier; obtained eof

^
#### Short summary: 

expected identifier; obtained eof
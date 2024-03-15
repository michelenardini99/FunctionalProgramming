package tasks

import u02.AnonymousFunctions.g

object Tasks extends App:

    //task 1

    val positive: Int => String = (x: Int) => x match
        case x if x>= 0 => "positive"
        case _ => "negative"

    def positive(x: Int): String = x match
        case x if x>= 0 => "positive"
        case _ => "negative"

    val empty: String => Boolean = _ == ""

    def neg[X](predicate: X => Boolean): X => Boolean = 
        (x: X) => !predicate(x)

    val notEmpty = neg(empty)
    println(notEmpty("foo"))
    println(notEmpty(""))

    //task 2

    val p1: Int => Int => Int => Boolean = x => y => z => x < y && y == z
    val p2: (Int, Int, Int) => Boolean = 
        (x, y, z) => x < y && y == z
    def p3(x: Int)(y: Int)(z: Int): Boolean = x < y && y == z
    def p4(x: Int, y: Int, z: Int): Boolean = x < y && y == z

    def compose(f: Int => Int, g: Int => Int): Int => Int =
        (x:Int) => f(g(x))

    def composeGenerics[X](f: X => X, g: X => X): X => X =
        (x:X) => f(g(x))

    //task 3

    def gcd(a: Int, b: Int): Int = a match
        case a if a == 0 => b
        case _ => gcd(b%a, a)

    def gcd2(a: Int, b: Int): Int =
        def _gcd(a: Int, b: Int): Int = a match
            case a if a == 0 => b
            case _ => _gcd(b%a, a)
        _gcd(a, b)

    //task 4

    enum Shape:
        case Rectangle(l1: Int, l2: Int)
        case Circle(r: Int)
        case Square(l: Int)

    object Shape:
        def perimeter(shape: Shape): Double = shape match
            case Rectangle(l1, l2) => (2*l1)+(2*l2)
            case Circle(r) => 2*math.Pi*r
            case Square(l) => 4*l

        def scale(shape: Shape, alpha: Double): Double =
            perimeter(shape)*alpha

    //task 5

    enum Optional[+A]:
        case Maybe(value: A)
        case Empty()

    object Optional:

        def isEmpty[A](optional: Optional[A]): Boolean = optional match
        case Empty() => true
        case _ => false
        
        def orElse[A, B >: A](optional: Optional[A], default: B): B = optional match
        case Maybe(value) => value
        case Empty() => default

        def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
        case Maybe(value) => Maybe(f(value))
        case _ => Empty()
        

        def filter[A](optional: Optional[A], f: A => Boolean): Optional[A] = optional match
        case Maybe(value) if f(value) => Maybe(value)
        case _ => Empty()
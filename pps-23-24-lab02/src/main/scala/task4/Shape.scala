package task4

object Shape extends App:

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
        
    import Shape.* 

    println(perimeter(Circle(4)))
    println(perimeter(Rectangle(5,4)))

    println(scale(Square(4), 2))
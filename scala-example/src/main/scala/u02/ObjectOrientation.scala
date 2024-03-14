package u02

object ObjectOrientation extends App{

    class Animal{
        //define fields
        val age: Int = 0
        //define methods
        def eat() = println("I'm eating")
    }

    val anAnimal = new Animal

    //inheritance
    class Dog(name: String) extends Animal//constructor definition
    val aDog = new Dog("Lassie")

    //constructors arguments are NOT fields
    aDog.name

    //subtype polymorphism
    val aDeclaredAnimal: Animal = new Dog("Hachi")
    aDeclaredAnimal.eat() //the most derived method will be called at runtime

    //abstract class
    abstract class WalkingAnimal{
        val hasLegs = true //by default public
        def walk(): Unit
    }

    //"interface" = ultimate abstract type
    trait Carnivore{
        def eat(animal: Animal): Unit
    }

    trait Philosopher{
        def ?!(thought: String): Unit //valid method name
    }

    //single-class inheritance, multi-trait "mixing"
    class Crocodile extends Animal with Carnivore with Philosopher{
        override def eat(animal: Animal): Unit = println("I am eating you, animal!")
    
        override def ?!(thought: String): Unit = println("I was thinking: $thought")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for method with ONE argument
    aCroc ?! "What if i could fly" 

    //operators in Scala are actually methods
    val basicMath = 1 + 2
    val anotherBasicMath = 1.+(2)//equivalent

    //anonymous classes
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println("I am a dinosaur so i can eat pretty much anything")
    }

    //singleton object
    object MySingleton{ //the only instance of MySingleton type
        val mySpecialValue = 53278
        def mySpecialMethod(): Int = 5327
        def apply(x: Int): Int = x + 1
    }

    MySingleton.mySpecialMethod()
    MySingleton.apply(65)
    MySingleton(65)

    object Animal{ //companions - companion object
        //companions can access each other's private fields/methods
        //singleton Animal and instances of Animal are different things
        val canLiveIndefinitely = false
    }

    val animalCanLiveForever = Animal.canLiveIndefinitely //"static" fields/methods

    //exception
    try{
        val x: String = null
        x.length
    }catch{
        case e: Exception => "some faulty error message"
    }finally{
        //execute some code
    }

    //generics
    abstract class MyList[T]{
        def head: T
        def Tail: MyList[T]
    }

    //using a generic with a concrete type
    val aList: List[Int] = List(1,2,3)
    val first = aList.head
    val rest = aList.tail
    val aStringList = List("Hello", "Scala")
    val firstString = aStringList.head

}
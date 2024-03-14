package u02

object Basic extends App{

    val meaningOfLife: Int = 42

    //Int, Boolean, Char, Double, Float, String
    val aBoolean = false  //type are optional

    //strings and string operations
    val aString = "I love Scala"
    val aComposedString = "I" + " " + "love" + " " + "Scala"
    val anInterpolatedString = s"The meaning of life is $meaningOfLife"

    //expression = structures that can be reduced to a value
    val anExpression = 2 + 3

    //if-expression
    val ifExpression = if(meaningOfLife > 43) 56 else 999
    val chainedIfExpression = 
        if(meaningOfLife > 43) 56
        else if(meaningOfLife < 0) -2
        else if(meaningOfLife > 999) 78
        else 0

    //code blocks
    val aCodeBlock = {
        //definitions
        val aLocalValue = 67

        //value of block is the value of the last expression
        aLocalValue + 3
    } 

    //define a function
    def myFunction(x: Int, y: String): String = {
        y + " " + x
    }

    //recursive function
    def factorial(n: Int): Int = 
        if(n <= 1) 1
        else n * factorial(n - 1)

    println("I love Scala")

    //Unit === void
    def MyUnitReturningFunction(): Unit = {
        println("I don't love returning Unit")
    }

    val theUnit = ()
}
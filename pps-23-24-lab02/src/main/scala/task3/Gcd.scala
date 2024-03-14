package task3

import u02.DefinedFunctions.abs

object Gcd extends App:

    def gcd(a: Int, b: Int): Int = 
        if(a==0) b else gcd(b%a, a)

    println(gcd(12, 8))
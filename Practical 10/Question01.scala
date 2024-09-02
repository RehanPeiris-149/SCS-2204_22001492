class Rational(n: Int, d: Int) {
        require(d != 0, "Denominator must be non-zero") //The require function is used o  put a constraint on the input parameters. If not met, illegal argument exception is thrown

        private val gcdVal = gcd(n.abs, d.abs)  //The private keyword is used to make the result of the gcd function inaccessible to external classes
                                                //The abs function is used to get the positive value of the numerator and denominator(if either are negative)
        
        val numer: Int = n / gcdVal 
        val denom: Int = d / gcdVal
        //Converts the rational number to its simplest form

        def this(n: Int) = this(n, 1)   //Auxiliary constructor if only one input is given, defaults the denominator to 1

        private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b) //The gcd function is used to find the greatest common divisor of two numbers   

        def neg: Rational = new Rational(-numer, denom) //The neg function is used to negate the rational number

        override def toString: String = s"$numer/$denom"    //Allows the ptrinting of the rational number in the form of a string
}

object Main extends App {

    val x = new Rational(5, 10)
    val negX = x.neg
    println(negX) 

}
object Question02 {
    def convertCelsiusToFarenheit(temp:Double) : Double = {
        temp * 1.8000 + 32.00;
    }

    def main(args :Array[String]) : Unit = {
        println(s"35 degrees Celsius = ${convertCelsiusToFarenheit(35.00)}");
    }
}
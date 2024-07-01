object Question03 {
    def main(args:Array[String]) : Unit = {
        val num1 = 24;
        val num2 = 42;
        val mean = arithmeticMean(num1, num2);
        printf("The mean of %d and %d is %.2f", num1, num2, mean);
    }

    def arithmeticMean(num1:Int, num2:Int) : Double = {
        val mean = (num1.toDouble + num2.toDouble) / 2.0;
        mean;
    }
}
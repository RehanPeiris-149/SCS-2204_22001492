object question01 {
    def areaOfCircle(r:Double):Double = {
        math.Pi * r * r;
    }
    def main(args: Array[String]) : Unit = {
        println(s"Area of circle with radius 5 = ${areaOfCircle(5.00)}");
    }
}
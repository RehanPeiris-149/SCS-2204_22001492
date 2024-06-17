object Question03 {
    def volumeOfSphere(r:Double):Double = {
        4 * math.Pi * r * r * r / 3;
    }
    def main(args: Array[String]) : Unit = {
        println(s"Volume of sphere with radius 5 = ${volumeOfSphere(5.00)}");
    }
}
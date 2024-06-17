object Question05 {
    def totalTime() : Double = {
        easyPace(2.00) + tempoPace(3.00) + easyPace(2.00);
    }
    def easyPace(distance: Double) : Double = {
        8 * distance;
    }
    def tempoPace(distance: Double) : Double = {
        7 * distance;
    }
    def main(args: Array[String]) : Unit = {
        println(s"Total time taken = ${totalTime()}");
    }
}
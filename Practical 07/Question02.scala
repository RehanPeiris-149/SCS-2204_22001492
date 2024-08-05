object Question02{
    def main(args:Array[String]) : Unit = {
        val input : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        val calculateSquare = (x:List[Int]) => x.map( (y:Int) => y*y);
        println("input = " + input);
        println("output = " + calculateSquare(input));
    }


}
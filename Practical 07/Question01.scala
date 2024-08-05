object Question01{
    def main(args:Array[String]) : Unit = {
        val input : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        val  filterEvenNumbers = (x:List[Int]) => x.filter(_%2==0);
        println("input = " + input);
        println("output = " +  filterEvenNumbers(input));
    }


}
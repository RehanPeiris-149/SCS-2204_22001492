object Question04 {
    def main(args:Array[String]) : Unit = {
        val input : List[Int] = List(12, 34, 55, 67, 34, 1, 0);
        val sum = sumOfEven(input);
        print("Sum of even numbers of list { ");
        input.foreach(element => print(s"${element} "));
        print(s"} is ${sum}");

    }

    def filterEven(input:List[Int]) : List[Int] = input match{
        case Nil => List[Int]();
        case x :: tail =>
            if (x % 2 == 0) {
                x :: filterEven(tail);
            } 
            else {
                filterEven(tail);
            } 
    }

    def sumOfList(input:List[Int]) : Int = input match{
        case Nil => 0;
        case x => x.head + sumOfList(x.tail);
    }

    def sumOfEven(input:List[Int]) : Int = {
        val filteredList : List[Int] = filterEven(input);
        val sum = sumOfList(filteredList);
        sum;

    }
}
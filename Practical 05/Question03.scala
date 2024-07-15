import scala.io.StdIn._

object Question03 {
    def main(args:Array[String]) : Unit = {
        val n = getInput();
        println(f"Fibonacci Sequence upto $n");
        for(i <- 0 until n) {
            print(fibonacci(i) + " ");
        }
    }

    def fibonacci(n:Int) : Int = n match {
        case 0 => 0;
        case 1 => 1;
        case _ => fibonacci(n-2) + fibonacci(n-1);
    }

    def getInput() : Int = {
        print(f"Please enter a number: ");
        readInt();
    }
}
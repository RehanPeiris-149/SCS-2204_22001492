import scala.io.StdIn._

object Question02 {
    def main(args:Array[String]) : Unit = {
        print("Please enter an integer: ");
        val input = readInt();
        numberMatching(input);

    }
    def numberMatching(input:Int) : Unit = input match {
        case x if (x<=0) => println("Negative/Zero");
        case x if (x%2==0) => println("Even Number");
        case _ => println("Odd Number");
    }

    
}
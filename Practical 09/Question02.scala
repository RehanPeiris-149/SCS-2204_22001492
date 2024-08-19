import scala.io.StdIn._

object Main extends App {
    def input() : Int = {                   //Input function
        print("Please enter integer: ");
        readInt();
    }

    val result : () => String = () => {     //Function that retruns analysis of input
        val y = input();
        y match {
            case x if (x < 0) => "Negative"
            case x if (x == 0) => "Zero"
            case x if (x%2 == 0) => "Even"
            case x => "Odd"
        }
        
    } 

    println(f"${result()}");
}
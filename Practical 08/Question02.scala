import scala.io.StdIn.readInt

object main extends App {
    
    val input = () => {
        print("Enter the Integer: ");
        readInt();
    }
    val isMultipleOfThree : Int => Boolean = (input:Int) => input%3==0;
    val isMultipleOfFive : Int => Boolean = (input:Int) => input%5==0;

    val result = (input:Int) => (isMultipleOfFive(input), isMultipleOfThree(input)) match {
        case (true, true) => "Multiple of Both Three and Five";
        case (false, true) => "Multiple of Three";
        case (true, false) => "Multiple of Five";
        case _ => "Not a Multiple of Three or Five";
    }

    println(result(input()));
}
import scala.io.StdIn._

object Question03 {
    def main(args:Array[String]) : Unit = {
        print("Please enter a string: ");
        val input = readLine();
        val upper = formatNames(input, toUpper);
        val lower = formatNames(input, toLower);
        val last = formatNames(input, capitalizeLast);
        val second = formatNames(input, capitalizeSecond);
        println(f"${input}   ${upper}   ${lower}    ${last}     ${second}");

    }
    def toUpper(input:String) : String = {
        input.toUpperCase();
    }

    def toLower(input:String) : String = {
        input.toLowerCase();
    }
    
    def formatNames(name: String, formatFunction: String => String): String = name match{
        case "" => "";
        case _ => formatFunction(name)
    }
    
    def capitalizeLast(input:String) : String = {
        input.init + input.last.toUpper;
    }
    //init, last are similar to head, tail
    //init -> all elements of array except last
    //last -> last element

    def capitalizeSecond(input:String) : String = {
        input.head.toString + input(1).toUpper.toString + input.substring(2);
    }
    //.substring -> returns substring starting from given index
    //.toString converts char to string
}
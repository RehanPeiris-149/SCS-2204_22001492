import scala.io.StdIn._

object StudentRecord {

    //Main Function
    def main(args:Array[String]) : Unit = {
        getStudentInfo();
    } 
    //End of Main Function

    //Function to obtain student info, calculate percentage and grade and print results
    def getStudentInfo() : Unit = {
        val input = getStudentInfoWithRetry();
        val calculation = calculatePercentageAndGrade(input._2, input._3);
        printStudentRecord(input._1, input._2, input._3, calculation._1, calculation._2);
    }

    //Function to print student record
    def printStudentRecord(record: (String, Int, Int, Double, Char)) : Unit = {
        println(f"Name          :${record._1}");
        println(f"Marks         :${record._2}");
        println(f"Total Marks   :${record._3}");
        println(f"Percentage    :${record._4}%.2f");
        println(f"Grade         :${record._5}");
    }

    //Function to calculate percentage and grade 
    def calculatePercentageAndGrade(marks:Int, totMarks:Int) : (Double, Char) = {
        val percentage = ((marks.toDouble/totMarks.toDouble) * 100.00);
        percentage match {
            case x if(x>=90) => (percentage, 'A');
            case x if(x>=75) => (percentage, 'B');
            case x if(x>=50) => (percentage, 'C');
            case _ => (percentage, 'D');
        }
    }

    //Function to validate input
    def validateInput(input:(String, Int, Int)) : (Boolean, Option[String]) = {
        if(input._1.isEmpty) {
            (false, Some("Name must not be empty"));
        }
        else if(input._2 < 0) {
            (false, Some("Marks must be greater than 0"));
        }
        else if(input._2 > input._3) {
            (false, Some("Marks must not exceed total marks"));
        }
        else {
            (true, None);
        }
    }

    //Function to obtain user input until valid input is obtained
    def getStudentInfoWithRetry() : (String, Int, Int) = {
        var flag = true;
        var input = ("0", 0, 0);
        while(flag) {
            input = obtainUserInput();
            validateInput(input) match {
                case (true, None) => flag = !flag;
                case (false, Some(error)) => println(""); println(f"Error: ${error}"); println("");
                case (true, Some(error)) => flag;
                case (false, None) => flag= flag;
            }
        }
        input;
    }

    //Function to obtain user input
    def obtainUserInput() : (String, Int, Int) = {

        val name : String = readLine("Enter Student Name: ");

        print("Enter Student Marks: ");
        val marks : Int = readInt();

        print("Enter total possible Marks: ")
        val totMarks : Int = readInt();

        (name, marks, totMarks);
    }
}
object Question01 {
    def main(args:Array[String]) : Unit = {
        val inputString  = "rehan";
        val reversedString = reverse(inputString);
        println(s"""Reverse of "${inputString}" is "${reversedString}" """);
    }

    def reverse(input: String): String = {
        if(input.isEmpty) {
            "";                                 //Base case
        }
        else {
            reverse(input.tail) + input.head;   //Concatenates head of current iteration to result of applying reverse function on remaining portion
        }
    }
    
}
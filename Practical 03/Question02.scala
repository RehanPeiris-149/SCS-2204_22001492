object Question02 {
    def main(args:Array[String]) : Unit = {
        val originalList : List[String]  = List("Dog", "Giraffe", "Elephant", "Cat");
        val updatedList : List[String] = filterList(originalList);

        println("Original List");
        originalList.foreach(println);
        println("");
        
        println("Updated List");
        updatedList.foreach(println);
    }

    def filterList(input: List[String]): List[String] = {
        if(input.isEmpty) {
            List[String]();                             //Base case
        }
        else {
            if((input.head).length > 5) {
                input.head :: filterList(input.tail);   //length of first list element is greater than 5
            }
            else {
                filterList(input.tail);                 //length of first list element is not greater than 5
            }
        }
    }
    
}
 object Main extends App{

    val upper : (input:String) => String = input => input.toUpperCase();

    val lower : (input:String) => String = input => input.toLowerCase();
    
    val last : (input:String) => String = input => input.init + input.last.toUpper;
    
    //init, last are similar to head, tail
    //init -> all elements of array except last
    //last -> last element

    val second : (input:String) => String = input => input.head.toString + input(1).toUpper.toString + input.substring(2);
    
    //.substring -> returns substring starting from given index
    //.toString converts char to string

    val formatNames : (name:String, formatFunction: String => String) => String = (name, formatFunction) => name match {
        case "" => "";
        case _ => formatFunction(name);
    }

    val name = List("Benny", "Niroshan", "Saman", "Kumara");

    println(f"${name(0)} to uppercase ${formatNames(name(0), upper)}");
    println(f"${name(1)} capitalize second letter ${formatNames(name(1), second)}");
    println(f"${name(2)} to lowercase ${formatNames(name(2), lower)}");
    println(f"${name(3)} capitalize last letter ${formatNames(name(3), last)}");
 } 
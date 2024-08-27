import scala.io.StdIn._

object main extends App {
    def encryption(str: String, shift: Int): String = {
        str.map {char =>
            if (char.isLetter) {
                //if the current letter is uppercase, it sets a base value to value of A, otherwise its set to value of a, to be added as required
                val base = if (char.isUpper) 'A' else 'a'                       
                
                //it then finds the corresponding letter by the subtraction of base, adds the shift to find the new letter, does a modulus division for letters that go beyond the alphabet, and then adds the base value to get the new letter, which is converted to char
                ((char.toInt - base.toInt + shift) % 26 + base.toInt).toChar      
            }
            else {
                //for non letter characters, it just retrurns the same character
                char
            }

            }.mkString
            //it finally makes a string from the returned characters
    }
    def decryption(str: String, shift: Int): String = {
        str.map {char =>
            if (char.isLetter) {
                //if the current letter is uppercase, it sets a base value to value of A, otherwise its set to value of a, to be added as required
                val base = if (char.isUpper) 'A' else 'a'                       
                
                //it then finds the corresponding letter by the subtraction, subtracts the shift to find the original letter, does a modulus division for letters that go beyond the alphabet, and then adds the base value to get the new letter, which is converted to char
                if((char.toInt - base.toInt - shift) < 0) {
                    ((char.toInt - base.toInt - shift) % 26 + base.toInt + 26).toChar //For negative values, it adds 26 to get the correct value
                }
                else {
                    ((char.toInt - base.toInt -shift) % 26 + base.toInt).toChar
                }
                   
            }
            else {
                //for non letter characters, it just retrurns the same character
                char
            }

            }.mkString
            //it finally makes a string from the returned characters
    }
    val invalid = (str: String, shift: Int) => "Invalid mode entered";
    
    def cipher(func : (String, Int) => String, str: String, shift: Int) : String = {
        func(str, shift);
    }

    def obtainUserInput() : (String, String, Int) = {
        val str = readLine("Enter the string to be encrypted/decrypted: ");
        val mode =readLine("Please enter mode(E for encryption or D for decryption): ");
        print("Enter the shift value: ");
        val shift = readInt();
        shift match {
            case x if(x < 0) => (mode, str, 0)
            case _ => (mode, str, shift)
        }
    }

    val run = (data: (String, String, Int)) => data._1.charAt(0) match {
        case 'E' => cipher(encryption, data._2, data._3);
        case 'D' => cipher(decryption, data._2, data._3);
        case _ => invalid(data._2, data._3);
    }
    println(run(obtainUserInput()));
}
import scala.collection.mutable.ListBuffer
//Contains List Buffer
import scala.collection.immutable._
//Lists are available in this
//This is a default import(I added it here for my knowledge)
import scala.io.StdIn._

object Question01 {
    def main(args:Array[String]) : Unit = {
        var temporary = ListBuffer[String]();
        val productList : List[String] = getProductList(temporary);
        printProductList(productList);


    }

    def getProductList(productList:ListBuffer[String]) : List[String] = {
        print("Please enter product name(enter \"done\" if you are done) : ");
        val input = readLine();
        input match {
            case "done" => productList.toList;
            case "" => println(f"\nPlease enter a product!!\n"); getProductList(productList); 
            case _ => productList.append(input); println(f"\nProduct successfully added\n"); getProductList(productList); 
        }
    }

    def printProductList(productList:List[String]) : Unit = {
        val count = getTotalProducts(productList);
        var i = 1;
        println(f"Product List\n");
        for(i<-1 to count) {
            println(f"${i}. ${productList(i-1)}");
        }
        println("");
    }

    def getTotalProducts(productList:List[String]) : Int = {
        productList.size;
    }
}


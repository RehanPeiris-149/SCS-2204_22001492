object Question01 { 
    def main(args:Array[String]) : Unit = {
        var itemNames : Array[String] = Array("Bread", "Chocolate", "Milk", "Cheese", "Toffee");
        var itemQuantity : Array[Int] = Array(10, 5, 15, 2, 30);
        displayInventory(itemNames, itemQuantity);

        //Test Case 1 - restock existing item
        restockItem("Bread", 5, itemNames, itemQuantity);
        displayInventory(itemNames, itemQuantity);

        //Test Case 2 - restock item that doesn't exist
        restockItem("Cake", 5, itemNames, itemQuantity);
        displayInventory(itemNames, itemQuantity);

        //Test Case 3 - sell item that exists
        sellItem("Bread", 5, itemNames, itemQuantity);
        displayInventory(itemNames, itemQuantity);

        //Test Case 4 - sell item that exists, but more than available quantity
        sellItem("Bread", 100, itemNames, itemQuantity);
        displayInventory(itemNames, itemQuantity);

        //Test Case 5 - sell item that doesn't exist
        sellItem("Cake", 5, itemNames, itemQuantity);
        displayInventory(itemNames, itemQuantity);
    }
    
    def displayInventory(name:Array[String], quantity:Array[Int]) : Unit = {
        println(f"Current Inventory");
        println(f"${"Item Name"}%-15s  ${"Item Quantity"}%-15s");
        for(i <- 0 until name.length) {
            println(f"${name(i)}%-15s  ${quantity(i)}%-15d");
        }
        println("");
    }
    //${"Item Name"}%-15s -> formatting that requires f interpolation
    //sets column width of 15 characters

    //until -> excludes final value
    //to -> includes final value

    def restockItem(name:String, quantity:Int, nameList:Array[String], quantityList:Array[Int]) : Unit = {
        val index = nameList.indexOf(name);
        if(index >= 0) {
            quantityList(index) = quantityList(index) + quantity;
        }
        else {
            println(f"Item ${name} not found");
            println("");
        }
    }
    //indexOf -> finds the index of array item provided

    def sellItem(name:String, quantity:Int, nameList:Array[String], quantityList:Array[Int]) : Unit = {
        val index = nameList.indexOf(name);
        if(index >= 0) {
            if(quantityList(index)-quantity >=0) {
                quantityList(index) = quantityList(index) - quantity;
            }
            else {
                println(f"Item ${name} insufficient quantity to sell");
                println("");
            }
            
        }
        else {
            println(f"Item ${name} not found");
            println("");
        }
    }
}
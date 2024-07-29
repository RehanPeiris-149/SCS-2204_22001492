 object Warehouse {

   //Definition of item class
   class Item(val name: String, val quantity: Int, val price: Float) {
      def displayDetails() : Unit = {
         println(f"Item Name     : ${name}");
         println(f"Item Quantity : ${quantity}");
         println(f"Item Price    : ${price}%.2f");
         println("");
      }
   }

   //main function
   def main(args:Array[String]) : Unit = {
      val inventory1 = Map(
         "001" -> new Item("Fork", 10, 10.00),
         "002" -> new Item("Spoon", 10, 15.00),
         "003" -> new Item("Knife", 10, 20.00),
         "004" -> new Item("Plate", 10, 50.00)
      );

      val inventory2 = Map(
         "001" -> new Item("Fork", 20, 10.00),
         "002" -> new Item("Spoon", 10, 35.00),
         "005" -> new Item("Bowl", 10, 10.00),
         "006" -> new Item("Jug", 10, 10.00)
         
      );

      val inventoryEmpty = Map.empty[String, Item];

      val inventoryEmpty2 = Map(
         "010" -> new Item("Teapot", 0, 100.00),
         "011" -> new Item("Teacup", 0, 50.00),
         "012" -> new Item("Saucer", 0, 50.00),
         "013" -> new Item("Kettle", 0, 500.00)
      )

      //Question 01
      retrieveNames(inventory1);
      println("");

      //Question02
      totalValue(inventory1);
      println("");

      //Question 03
      inventoryCheck(inventory1);
      inventoryCheck(inventoryEmpty);
      inventoryCheck(inventoryEmpty2);
      println("");

      //Question 04
      val inventory3 = mergeInventory(inventory1, inventory2);
      printDetails(inventory3);
      println("");

      //Question 05
      printIfExists(inventory1, "001");
      printIfExists(inventory1, "015");
      println("");
      
   }
   //End of main function

   //Function to print key values and names of all items in inventory
   def retrieveNames(inv: Map[String, Item]) : Unit = {
      inv.foreach {
         case (key, item) => println(s"${key} -> ${item.name}");
      }
   }

   //Function to print all details of all items in inventory
   def printDetails(inv:Map[String, Item]) : Unit = {
      inv.foreach {
         case (key, item) => println(f"${key} -> ${item.name}%10s    ${item.quantity}%3d     ${item.price}%5.2f");
      }
   }

   //Function to obtain total value of all items in inventory
   def totalValue(inv: Map[String, Item]) : Unit = {
      var total = 0.00;
      inv.foreach {
         case (_, item) => 
            total += item.quantity * item.price;
      }
      println(f"Total value = Rs.${total}%.2f");
   }

   //Function to print if a given inventory is empty or not
   def inventoryCheck(inv:Map[String, Item]) : Unit = inventoryEmpty(inv) match {
      case true => println("Empty");
      case false => println("Not Empty");
   }

   //Function to check if a given inventory is empty or not
   def inventoryEmpty(inv: Map[String, Item]) : Boolean = {
      inv.isEmpty || inv.forall { case (_ , item) => item.quantity <= 0};
   }

   //Function to begin merging of two inventories and return merged inventory
   def mergeInventory(inv1: Map[String, Item], inv2: Map[String, Item]) : Map[String, Item] = {
      var newInv = inv1;
      inv2.foreach {
         case(key, item) => 
            val item2 = item;
            val key2 = key;
            newInv = addItemToInventory(newInv, item2, key2);
      }
      newInv;
   }

   //Function to add an item to inventory
   def addItemToInventory(inv:Map[String, Item], item:Item, key:String) : Map[String, Item] = {
      searchInventoryForItem(inv, key) match {
         case true => updateItemInInventory(inv, item, key);
         case false => inv + (key -> item);
      }
   }

   //Function to search if a key value is in inventory
   def searchInventoryForItem(inv:Map[String, Item], keyV:String) : Boolean = {
      inv.exists { case (key , _) => keyV == key};
   }

   //Function to update an item that already is in inventory
   def updateItemInInventory(inv:Map[String, Item], item:Item,key:String) : Map[String, Item] = {
      val item2 = inv(key);
      var newInv = inv - key;
      val mergedItem = mergeItems(item, item2);
      newInv + (key -> mergedItem);
   }

   //Function to merge two items 
   def mergeItems(item1:Item, item2:Item) : Item = {
      var newItem = new Item(
         item1.name,
         item1.quantity + item2.quantity,
         if(item1.price > item2.price) item1.price else item2.price
         );
      newItem;
   }

   //Funtion to print if an item exists in inventory by key value
   def printIfExists(inv:Map[String, Item], key:String) : Unit = {
      searchInventoryForItem(inv, key) match {
         case true => val item = inv(key); item.displayDetails();
         case false => println(s"Item with ID ${key} does not exist");
      }
   }
}
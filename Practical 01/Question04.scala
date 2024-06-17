object Question04 {
    def totalprice(number:Int) : Double = {
        finalPriceOfBooks(number) + shippingCost(number);
    }
    def priceOfBooks(number:Int) : Double = {
        24.95 * number;
    }
    def finalPriceOfBooks(number:Int) : Double = {
        priceOfBooks(number) * (1 - 0.4);
    }
    def shippingCost(number:Int) : Double = {
        if(number<=50) {
            number * 3;
        }
        else {
            50 * 3 + (number-50) * 0.75;
        }
    }
    def main(args: Array[String]) : Unit = {
        println(s"Total cost for 60 books = ${totalprice(60)}");
    }
}
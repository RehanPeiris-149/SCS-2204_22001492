object Question04{
    def main(args:Array[String]) : Unit = {
        var profits = new Array[Double](10);
        profitsArray(profits);
        var maxIndex = maxArray(profits);
        println(s"The best price for a ticket is Rs.${(maxIndex+1)*5} and the profit earned is Rs.${profits(maxIndex)}");
    }

    def maxArray(profits:Array[Double]) : Int = {    //Returns index of element with hghest value in array
        var maxIndex = 0;
        var i=0;
        for(i <- 1 to (profits.length-1)) {
            if(profits(i) > profits(maxIndex)) {
                maxIndex = i;
            }
        }
        maxIndex;
    }

    def profitsArray(profits:Array[Double]) : Array[Double] = {   //Checks for ticket prices from Rs.5 to Rs.55 and stores in array 
        var i=1;
        for(i <- 1 to profits.length) {
            profits(i-1) = profit(i*5);
        }
        profits;
    }

    def profit(price:Double) : Double = {
        val count = customerCount(price);
        income(count, price) - expense(count);
    }

    def customerCount(price: Double) : Double = {
        if(price<=0) {
            0;
        }
        else {
            120+20*(15-price)/5;    //When ticket is Rs.15 customer count is 120, for every increase of Rs.5, customer
                                    //count decreases by 20, and vice cersa 
        }
    }

    def income(count:Double, price:Double) : Double = {
        count * price;
    }

    def expense(count:Double) : Double = {
        500 + count * 3;    //Base cost is 500, every customer icreases cost by Rs.3
    }

}
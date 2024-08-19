object Main extends App {
    val interest = (amount:Int) => amount match {
        case x if (x<0) => 0                //No interest for negative
        case x if (x<20000) => x*0.02       //2% interest for amounts less than Rs.20000
        case x if(x<200000) => x*0.04       //4% interest for amounts less than Rs.200000
        case x if (x<2000000) => x*0.035    //3.5% interest for amounts less than Rs.200000
        case x => x*0.065                   //6.5% interest for amounts more than Rs.2000000
    }

    val money = List(-10000, 10000, 20000, 200000, 2000000);    //Test amounts

    money.foreach {amount =>
        println(f"Interest for Rs.$amount is Rs.${interest(amount)}%.2f");
    }
}
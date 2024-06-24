object Question03{
    def main(args:Array[String]) : Unit = {
        println(s"Total pay with tax =Rs.${totalPay(40, 30)}");
    }
    def totalPay(norm:Int, OT:Int) : Double = {
        val income = normalIncome(norm) + overtimeIncome(OT);
        income - tax(income);
    }
    def normalIncome(norm:Int) : Double = {
        norm*250; //Rate of pay per normal working hour = Rs.250
    }
    def overtimeIncome(OT:Int) : Double = {
        OT*85; //Rate of pay per overtime working hour = Rs.85
    }
    def tax(income:Double) : Double = {
        income*12/100;  //Tax Rate is 12%
    }
}
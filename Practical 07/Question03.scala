object Question03{
    def main(args:Array[String]) : Unit = {
        val input : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        val  filterPrime = (x:List[Int]) => x.filter( (y:Int) => (isPrime(y)) );
        println("input = " + input);
        println("output = " +  filterPrime(input));
    }
    
    def gcd(a:Int, b:Int) : Int = b match {
        case 0 => a;
        case x if(x>a) => gcd(x, a);
        case _ => gcd(b, a%b);
    }

    def isPrime(p:Int, n:Int = 2) : Boolean = n match {
        case x if(x==p) => true;
        case x if(gcd(p,x) > 1) => false;
        case x if(p==1 || p==0) => false;
        case x =>isPrime(p, x+1);
    }

}
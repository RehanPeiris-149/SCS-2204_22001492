class BankAccount(private var balance: Double) {
    def deposit(amount: Double): Unit = {
        balance += amount
    }

    def withdraw(amount: Double): Unit = {
        if (amount <= balance) {
            balance -= amount
        } else {
            println("Insufficient balance")
        }
    }

    def transfer(amount: Double, targetAccount: BankAccount): Unit = {
        if (amount <= balance) {
            withdraw(amount)
            targetAccount.deposit(amount)
        } else {
            println("Insufficient balance")
        }
    }

    def getBalance: Double = balance
}

object Main extends App {
    val account1 = new BankAccount(100)
    val account2 = new BankAccount(50)

    account1.transfer(50, account2)

    println(account1.getBalance)
    println(account2.getBalance)
}
class BankAccount(val accountNumber: String, var balance: Double) {
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

class Bank(var accounts: List[BankAccount]) {
    def negativeBalances(accounts: List[BankAccount]): List[BankAccount] = {
        accounts.filter(_.balance < 0)
    }

    def sumOfBalances(accounts: List[BankAccount]): Double = {
        accounts.map(_.balance).sum
    }

    def applyInterest(accounts: List[BankAccount]): List[BankAccount] = {
        accounts.map(account => {
            val interestRate = if (account.balance >= 0) 0.05 else 0.1
            val interest = account.balance * interestRate
            new BankAccount(account.accountNumber, account.balance + interest)
        })
    }

    def printAccountNumbers(accounts: List[BankAccount]): Unit = {
        accounts.foreach(account => println(account.accountNumber + " " + account.balance))
        println("")
    }
}

object Main extends App {
    val account1 = new BankAccount("001", 100)
    val account2 = new BankAccount("002", -50)
    val account3 = new BankAccount("003", 0)
    val account4 = new BankAccount("004", 200)
    val account5 = new BankAccount("005", -100)

    val bank = new Bank(List(account1, account2, account3, account4, account5))

    println("Negative balances:")
    bank.printAccountNumbers(bank.negativeBalances(bank.accounts))
    print("Sum of balances: ")
    println(bank.sumOfBalances(bank.accounts))
    println("")
    println("Applying interest:")
    bank.printAccountNumbers(bank.applyInterest(bank.accounts))
}
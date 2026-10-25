class Book(
    val title: String,
    val author: String,
    val pages: Int
) {
    fun describe() {
        println("«$title», $author, $pages стр.")
    }
}

class BankAccount(
    val owner: String,
    var balance: Int = 0
) {
    fun deposit(amount: Int) {
        balance += amount
    }

    fun withdraw(amount: Int) {
        if (amount > balance) {
            println("Недостаточно средств")
        } else {
            balance -= amount
        }
    }

    fun printBalance() {
        println("Баланс $owner: $balance руб.")
    }
}

data class User(val id: Int, val name: String, val email: String)

data class Product(val name: String, val price: Int, val quantity: Int)

fun task1() {
    val book1 = Book("Мастер и Маргарита", "Михаил Булгаков", 480)
    val book2 = Book("Преступление и наказание", "Фёдор Достоевский", 671)
    val book3 = Book("Война и мир", "Лев Толстой", 1274)

    book1.describe()
    book2.describe()
    book3.describe()
}

fun task2() {
    val account = BankAccount("Анны")

    account.deposit(2000)
    account.printBalance()

    account.withdraw(500)
    account.printBalance()

    account.withdraw(3000)
    account.printBalance()
}

fun task3() {
    val user1 = User(1, "Анна", "anna@mail.ru")
    val user2 = User(1, "Анна", "anna@mail.ru")

    println(user1 == user2)
    println(user1 === user2)

    println(user1)

    val user3 = user1.copy(email = "anna.new@mail.ru")
    println(user1)
    println(user3)

    val (id, name, email) = user1
    println("id=$id, name=$name, email=$email")
}

fun task4() {
    val products = listOf(
        Product("Хлеб", 50, 2),
        Product("Молоко", 80, 3),
        Product("Сыр", 300, 1)
    )

    val total = products.sumOf { it.price * it.quantity }
    println("Итоговая сумма: $total руб.")

    val mostExpensive = products.maxByOrNull { it.price }!!
    val updated = mostExpensive.copy(quantity = mostExpensive.quantity + 1)

    val updatedList = products.map { if (it == mostExpensive) updated else it }
    println(updatedList)
}

fun main() {
    println("--- Задание 1 ---")
    task1()
    println("\n--- Задание 2 ---")
    task2()
    println("\n--- Задание 3 ---")
    task3()
    println("\n--- Задание 4 ---")
    task4()
}
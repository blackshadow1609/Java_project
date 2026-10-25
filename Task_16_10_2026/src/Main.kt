fun task1() {
    val names = mutableListOf<String>()

    repeat(3) {
        val input = readln().trim()
        if (input.isNotEmpty()) {
            names.add(input)
        }
    }

    val searchName = readln().trim()
    if (searchName in names) {
        println("FOUND")
    } else {
        println("NOT FOUND")
    }
}

fun task2() {
    print("Введите количество запросов: ")
    val guestRequests = readln().toInt()

    val guests = mutableSetOf<String>()

    repeat(guestRequests) {
        val name = readln().trim()
        if (guests.add(name)) {
            println("REGISTERED")
        } else {
            println("DUPLICATE")
        }
    }

    println("TOTAL: ${guests.size}")
}

fun task3() {
    val prices = mapOf(
        "apple" to 70,
        "banana" to 55,
        "orange" to 80
    )

    print("Введите первый фрукт: ")
    val firstItemName = readln().trim()

    print("Введите второй фрукт: ")
    val secondItemName = readln().trim()

    val firstPrice = prices[firstItemName] ?: 0
    val secondPrice = prices[secondItemName] ?: 0

    println("Сумма: ${firstPrice + secondPrice} руб.")
}

fun main() {
    println("--- Задание 1: Кастинг ---")
    task1()

    println("\n--- Задание 2: Вход на мероприятие ---")
    task2()

    println("\n--- Задание 3: Заказ фруктов ---")
    task3()
}
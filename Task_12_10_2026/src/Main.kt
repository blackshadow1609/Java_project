fun task1() {
    print("Введите количество товаров: ")
    val n = readln().toInt()

    val prices = IntArray(n)

    for (i in 0 until n) {
        print("Введите цену товара ${i + 1}: ")
        prices[i] = readln().toInt()
    }

    println("\nЧек:")
    for (i in prices.indices) {
        println("${i + 1}. ${prices[i]} ₽")
    }

    var total = 0
    var maxPrice = prices[0]
    var maxIndex = 0

    for (i in prices.indices) {
        total += prices[i]
        if (prices[i] > maxPrice) {
            maxPrice = prices[i]
            maxIndex = i
        }
    }

    println("\nИтого: $total ₽")
    println("Самая дорогая позиция: ${maxIndex + 1}. $maxPrice ₽")
}

fun task2() {
    val seats = BooleanArray(10)

    fun printHall() {
        for (i in seats.indices) {
            print(if (seats[i]) "[X]" else "[ ]")
        }
        println()
        for (i in seats.indices) {
            print(" ${i + 1} ")
        }
        println()
    }

    while (true) {
        printHall()
        print("\nВведите номер места (1-10) или 0 для выхода: ")
        val input = readln().toInt()

        if (input == 0) break

        if (input !in 1..10) {
            println("Неверный номер места. Введите число от 1 до 10.")
            continue
        }

        val index = input - 1
        if (seats[index]) {
            println("Место $input уже занято.")
        } else {
            seats[index] = true
            println("Место $input успешно забронировано.")
        }
        println()
    }

    var occupied = 0
    for (seat in seats) {
        if (seat) occupied++
    }

    println("\nЗанято мест: $occupied из ${seats.size}")

    val freeOdd = mutableListOf<Int>()
    val freeEven = mutableListOf<Int>()

    for (i in seats.indices) {
        if (!seats[i]) {
            val seatNumber = i + 1
            if (seatNumber % 2 != 0) freeOdd.add(seatNumber)
            else freeEven.add(seatNumber)
        }
    }

    println("Свободные нечётные места: ${freeOdd.joinToString(", ")}")
    println("Свободные чётные места: ${freeEven.joinToString(", ")}")
}

fun task3() {
    print("Введите числа через пробел: ")
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    print("Введите k: ")
    val k = readln().toInt()

    if (k < 1 || k > numbers.size) {
        println("Ошибка: k должно быть от 1 до ${numbers.size}")
        return
    }

    var currentSum = 0
    for (i in 0 until k) {
        currentSum += numbers[i]
    }

    var maxSum = currentSum
    var startIndex = 0

    for (i in 1..numbers.size - k) {
        currentSum = currentSum - numbers[i - 1] + numbers[i + k - 1]
        if (currentSum > maxSum) {
            maxSum = currentSum
            startIndex = i
        }
    }

    println("Максимальная сумма подмассива из $k элементов: $maxSum")
    println("Стартовый индекс: $startIndex")

    for (i in 0 until numbers.size / 2) {
        val temp = numbers[i]
        numbers[i] = numbers[numbers.size - 1 - i]
        numbers[numbers.size - 1 - i] = temp
    }

    println("Развёрнутый массив: ${numbers.joinToString(" ")}")
}

fun main() {
    println("--- Задание 1: Касса ---")
    task1()
    println("\n--- Задание 2: Зал ---")
    task2()
    println("\n--- Задание 3: Подмассив и разворот ---")
    task3()
}
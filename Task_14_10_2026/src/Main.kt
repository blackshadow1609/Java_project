fun parseCountOrNull(text: String): Int? {
    val trimmed = text.trim()
    if (trimmed.isEmpty()) return null
    return trimmed.toIntOrNull()
}

fun task1() {
    print("Введите количество коробок: ")
    val input = readln()
    val result = parseCountOrNull(input)
    println("Результат: $result")
}

fun task2() {
    print("Введите возраст посетителя: ")
    val input = readln()
    val age = input.trim().toIntOrNull()

    if (age == null) {
        println("Ошибка: возраст не распознан")
        return
    }

    if (age < 0) {
        println("Ошибка: возраст не может быть отрицательным")
    } else if (age < 7) {
        println("Билет бесплатный")
    } else if (age < 18) {
        println("Детский билет: 150 руб.")
    } else if (age < 65) {
        println("Взрослый билет: 300 руб.")
    } else {
        println("Пенсионный билет: 100 руб.")
    }
}

fun formatText(
    text: String,
    trimSpaces: Boolean = true,
    uppercase: Boolean = false,
    repeatCount: Int = 1,
    separator: Char = ' '
): String {
    var result = if (trimSpaces) text.trim() else text
    if (uppercase) result = result.uppercase()
    return List(repeatCount) { result }.joinToString(separator.toString())
}

fun task3() {
    val phrase = "  привет мир  "

    println(formatText(phrase))

    println(formatText(phrase, separator = '-'))

    println(formatText(phrase, repeatCount = 3))

    println(formatText(phrase, uppercase = true, separator = '_'))
}

fun main() {
    println("--- Задание 1: Склад ---")
    task1()

    println("\n--- Задание 2: Музей ---")
    task2()

    println("\n--- Задание 3: Генератор текста ---")
    task3()
}
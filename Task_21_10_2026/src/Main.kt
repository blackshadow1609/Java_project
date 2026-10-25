class DisplayName(name: String) {
    var name: String = name
        set(value) {
            val trimmed = value.trim()
            field = if (trimmed.isEmpty()) "Unknown" else trimmed
        }
}

class Greeter {
    lateinit var userName: String

    fun init(name: String) {
        require(name.trim().isNotEmpty()) { "Имя не может быть пустым" }
        userName = name.trim()
    }

    fun greet(): String {
        return "Hello, $userName!"
    }
}

fun task1() {
    val displayName = DisplayName("")
    displayName.name = " Alice "
    println(displayName.name)
    displayName.name = " "
    println(displayName.name)
}

fun task2() {
    print("Введите имя: ")
    val input = readln().trim()

    val greeter = Greeter()
    greeter.init(input)
    println(greeter.greet())
}

fun main() {
    println("--- Задание 1: DisplayName ---")
    task1()

    println("\n--- Задание 2: Greeter ---")
    task2()
}
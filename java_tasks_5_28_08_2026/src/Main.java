import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку со скобками: ");
        String input = scanner.nextLine();

        char[] stack = new char[input.length()];
        int top = -1;

        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                top++;
                stack[top] = currentChar;
            }
            else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (top == -1) {
                    isValid = false;
                    break;
                }

                char lastOpen = stack[top];
                top--;

                if (currentChar == ')' && lastOpen != '(') {
                    isValid = false;
                    break;
                } else if (currentChar == ']' && lastOpen != '[') {
                    isValid = false;
                    break;
                } else if (currentChar == '}' && lastOpen != '{') {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid && top != -1) {
            isValid = false;
        }

        // Вывод результата
        System.out.println("-----------------------------------");
        if (isValid) {
            System.out.println("Последовательность правильная!");
        } else {
            System.out.println("Последовательность неправильная!");
        }

        scanner.close();
    }
}
void main() {
    System.out.println(countVowels("Hellooo World"));
    System.out.println(countVowels("Java"));
    System.out.println(countVowels("Кооооофе"));
}

int countVowels(String text) {
    int count = 0;
    String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouAEIOU";

    for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        if (vowels.indexOf(ch) != -1) {
            count++;
        }
    }
    return count;
}
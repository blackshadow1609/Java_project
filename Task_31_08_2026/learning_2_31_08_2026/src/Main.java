void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите M: ");
    int M = scanner.nextInt();
    System.out.print("Введите N: ");
    int N = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < M; i++) {
        System.out.println("Введите строку " + (i + 1) + ":");
        String line = scanner.nextLine();

        int letters = 0, digits = 0, others = 0;
        for (int j = 0; j < line.length() && j < N; j++) {
            char ch = line.charAt(j);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                letters++;
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else {
                others++;
            }
        }
        System.out.println("Букв: " + letters + ", Цифр: " + digits + ", Других: " + others);
    }
}
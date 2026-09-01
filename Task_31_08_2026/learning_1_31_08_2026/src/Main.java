void main() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Введите N: ");
    int N = sc.nextInt();
    double[] a = new double[N];
    double sum = 0;

    for (int i = 0; i < N; i++) {
        a[i] = sc.nextDouble();
        sum += a[i];
    }

    double avg = sum / N;
    int count = 0;
    for (double x : a) if (x > avg) count++;

    System.out.println("Сумма=" + sum + " Среднее=" + avg + " Количество=" + count);
}
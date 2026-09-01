void main() {
    Scanner sc = new Scanner(System.in);

    System.out.print("N = ");
    int N = sc.nextInt();
    int[][] a = new int[N][N];

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            a[i][j] = sc.nextInt();
        }
    }

    for (int i = 0; i < N; i++) {
        int max = a[i][0];
        int idx = 0;
        for (int j = 1; j < N; j++) {
            if (a[i][j] > max) {
                max = a[i][j];
                idx = j;
            }
        }
        System.out.println("Строка " + (i+1) + ": " + max + " [" + idx + "]");
    }

    boolean sym = true;
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            if (a[i][j] != a[j][i]) {
                sym = false;
            }
        }
    }

    System.out.println(sym ? "Симметрична" : "Не симметрична");
}
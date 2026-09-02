void main() {
    System.out.println(isPrime(7));
    System.out.println(isPrime(2));
    System.out.println(isPrime(-5));
}

boolean isPrime(int num) {
    if (num <= 1) {
        return false;
    }

    for (int i = 2; i < num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}
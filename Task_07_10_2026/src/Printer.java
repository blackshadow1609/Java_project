public class Printer {

    private final boolean synchronizedMode;

    public Printer(boolean synchronizedMode) {
        this.synchronizedMode = synchronizedMode;
    }

    public void printDocument(String owner) {
        if (synchronizedMode) {
            printSynchronized(owner);
        } else {
            printUnsynchronized(owner);
        }
    }

    private void printUnsynchronized(String owner) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(owner + ": строка " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private synchronized void printSynchronized(String owner) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(owner + ": строка " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
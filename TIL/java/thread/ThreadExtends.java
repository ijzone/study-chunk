package thread;

public class ThreadExtends extends Thread {
    int seq;

    public ThreadExtends(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.printf("EXTENDS::Thread Name: %s(%s) / BEFORE: %s \n", Thread.currentThread().getName(), seq, Main.gs);
        Main.gs = "c" + seq;
        System.out.printf("EXTENDS::Thread Name: %s(%s) / AFTER: %s \n", Thread.currentThread().getName(), seq, Main.gs);
    }
}

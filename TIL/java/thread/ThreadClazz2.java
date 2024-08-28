package thread;

public class ThreadClazz2 extends Thread {
    int seq;

    public ThreadClazz2(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.printf("Thread (%s) running\n", seq);
    }
}

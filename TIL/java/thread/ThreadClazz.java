package thread;

public class ThreadClazz implements Runnable {
    int seq;

    public ThreadClazz(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.printf("Thread (%s) running\n", seq);
    }
}

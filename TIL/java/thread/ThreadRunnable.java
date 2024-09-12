package thread;

public class ThreadRunnable implements Runnable {
    int seq;

    public ThreadRunnable(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
//        System.out.printf("Thread (%s) running\n", seq);
        System.out.printf("RUNNABLE::Thread Name: %s(%s) / BEFORE: %s \n", Thread.currentThread().getName(), seq, Main.gs);
        Main.gs = "b" + seq;
        System.out.printf("RUNNABLE::Thread Name: %s(%s) / AFTER: %s \n", Thread.currentThread().getName(), seq, Main.gs);
    }
}


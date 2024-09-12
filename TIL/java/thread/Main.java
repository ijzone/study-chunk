package thread;

public class Main {

    public static String gs = "a";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " START");

        // 👇 Runnable 구현 방식
        for (int idx = 1; idx < 11; idx++) {
            ThreadRunnable threadRunnable = new ThreadRunnable(idx); // 쓰레드 인터페이스를 구현한 객체 생성
            Thread thread = new Thread(threadRunnable); // 쓰레드 객체 생성
            thread.start();
//            thread.join(); // 쓰레드 실행이 완료 될 때까지 대기
        }

        // 👇 Thread 상속 방식
        for (int idx = 1; idx < 11; idx++) {
            ThreadExtends threadExtends = new ThreadExtends(idx); // 쓰레드 클래스를 상속한 객체 생성
            threadExtends.start();
//            threadExtends.join(); // 쓰레드 실행이 완료 될 때까지 대기
        }

        System.out.println(Thread.currentThread().getName() + " END");
    }
}

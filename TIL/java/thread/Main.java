package thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " START");

        for (int idx = 1; idx < 11; idx++) {
            ThreadClazz threadClazz = new ThreadClazz(idx); // 쓰레드 인터페이스를 상속한 객체 생성
            Thread thread = new Thread(threadClazz); // 쓰레드 객체 생성
            thread.start();
            thread.join(); // 쓰레드 실행이 완료 될 때까지 대기
        }

        System.out.println(Thread.currentThread().getName() + " END");
    }
}

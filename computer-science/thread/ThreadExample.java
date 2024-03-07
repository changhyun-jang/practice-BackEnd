package thread;

/*
기본적인 쓰레드 사용
 */
public class ThreadExample extends Thread{
    private String message;

    public ThreadExample(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(message);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample("Thread 1");
        ThreadExample t2 = new ThreadExample("Thread 2");
        t1.start();
        t2.start();
        //스레드는 동시에 실행되므로 번갈아 가며 메시지를 출력한다.
    }
}

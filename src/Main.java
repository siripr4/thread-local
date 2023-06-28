public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.printf("Thread1 %d: %d\n", Thread.currentThread().threadId(), ThreadId.get());
        }, "Thread1");
        Thread t2 = new Thread(() -> {
            System.out.printf("Thread2 %d: %d\n", Thread.currentThread().threadId(), ThreadId.get());
        }, "Thread2");
        t.start();
        t2.start();
        try {
            System.out.printf("Threadm0 %d: %d\n", Thread.currentThread().threadId(), ThreadId.get());
            t.join();
            t2.join();
            System.out.printf("Threadm %d: %d\n", Thread.currentThread().threadId(), ThreadId.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

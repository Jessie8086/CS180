public class RaceCondition implements Runnable {
    private static int counter;

    public static void main(String[] args) {
        counter = 0;
        Thread t1 = new Thread(new RaceCondition());
        Thread t2 = new Thread(new RaceCondition());
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("counter = %d\n", counter);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "      " + i);
        }
    }
}



class SecretThread extends Thread {
    public static int counter = 0;
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
}

public class MyThreadDebug {
    public static void main(String[] args) {
        SecretThread[] threadArray = new SecretThread[10];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new SecretThread();
            threadArray[i].start();
        }

        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        System.out.println(SecretThread.counter);
    }
}
package educative.multithreading;

import java.util.concurrent.Semaphore;

class Demonstration {

    public static void main(String args[]) throws InterruptedException {
        CorrectSemaphoreExample.example();
    }
}

class CorrectSemaphoreExample {

    public static void example() throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(new Runnable() {

            public void run() {

                int count = 0;

                while (count++<10) {

                    try {
                        semaphore.acquire();
                        try {
//                            throw new RuntimeException("");
                            System.out.println("Bad Thread");
                        } catch (Exception e) {
                            // handle any program logic exception and exit the function
                            e.printStackTrace();
                            return;
                        } finally {
                            System.out.println("Bad thread releasing semahore.");
                            semaphore.release();
                        }

                    } catch (InterruptedException ie) {
                        // handle thread interruption
                    }
                }
            }
        });

        badThread.start();

        // Wait for the bad thread to go belly-up
        Thread.sleep(1000);

        final Thread goodThread = new Thread(new Runnable() {

            public void run() {
                System.out.println("Good thread patiently waiting to be signalled.");
                try {
                    semaphore.acquire();
                    System.out.println("Good Thread");
                } catch (InterruptedException ie) {
                    // handle thread interruption
                }
            }
        });

        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Program");
    }
}


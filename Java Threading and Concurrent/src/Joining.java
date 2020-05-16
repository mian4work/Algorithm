import java.util.concurrent.ThreadLocalRandom;

/*
    When we invoke the join() method on a thread, the calling thread goes into a waiting state.
    It remains in a waiting state until the referenced thread terminates.

    The following program: without t.join() the out put is without order:

            Current Thread: main
            Current Thread: main
            Current Thread: main
            Current Thread: Thread-0
            0
            Current Thread: Thread-2
            0
            Current Thread: Thread-1
            0
            Current Thread: Thread-2
            1
            Current Thread: Thread-0
            1
            Current Thread: Thread-1
            1

    with t.join(), we can see that the second main thread starts after the joined t1 is dead:

            Current Thread: main  ---> first main thread and wait until Thread-0 is done.
            Current Thread: Thread-0
            0
            Current Thread: Thread-0
            1
            Current Thread: main  ---> second main thread and wait until Thread-1 is done.
            Current Thread: Thread-1
            0
            Current Thread: Thread-1
            1
            Current Thread: main
            Current Thread: Thread-2
            0
            Current Thread: Thread-2
            1
 */
public class Joining {

    public void play() {
        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        try {
            t1.start();
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName()); //the current thread is main
            t1.join();

            t2.start();
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName()); //the current thread is main
            t2.join();

            t3.start();
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName()); //the current thread is main
            t3.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("I am the last to be print");
    }
}

/**
 * define a thread which just printing 0 and 1
 */
class ThreadJoining extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 2; i++) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

public class Threading {

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
            }
            System.out.println(Thread.currentThread().getName() + "running");
        }
    };


    public void startThread() {
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        System.out.println("t1: " + t1.getState().toString());
        System.out.println("t2: " + t2.getState().toString());
        t1.start();
        t2.start();
        System.out.println("t1: " + t1.getState().toString());
        System.out.println("t2: " + t2.getState().toString());
    }
}

/*
    refer: https://www.baeldung.com/java-wait-notify
 */

import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * To design this system, we need to have a Data class which has a shared data and has send & receive object
 */
public class SenderReceiverSolution {

    public void play() {
        Data data = new Data();

        Sender s1 = new Sender(data);
        Sender s2 = new Sender(data);

        Receiver r1 = new Receiver(data);
        Receiver r2 = new Receiver(data);

        new Thread(s1, "Sender 1").start();
//        new Thread(s2, "Sender 2").start();
        new Thread(r1, "Receiver 1").start();
//        new Thread(r2, "Receiver 2").start();
    }
}

/**
 * A packet object is used for sender and receiver.
 * A transfer object is to decide if transfer needs to happen:
 *      true: sender can send
 *      false: waiter has to wait
 */
class Data {
    private String packet;
    boolean transfer = true;

    /**
     * We have to use the synchronized method because we have two variables packet and transfer which need to be synced.
     *
     * The synchronized method lock the OBJECT!!!
     * @param packet
     */
    public synchronized void send(String packet) {
        while (!transfer) { //A while loop keeps waiting for transfer signal.
            try {
                wait(); //Object's method to pause the current thread until being notified.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        }

        //Once being woke up. Start sending and set transfer to false.
        transfer = false;
        this.packet = packet;

        //Once sending is done. (just set the packet value), notify other receivers.
//        notifyAll();
        notify();
    }

    public synchronized String receive() {
        while (transfer) { //Wait for signal to receive the packet
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        }

        //Once being woke up, set transfer to true for sender to send next packet
        transfer = true;
//        notifyAll(); //Wake up sender to send
        notify();
        return packet;
    }
}

/**
 * The sender is a runnable, which will send some packets
 */
class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        //define some data to send. End is the signal to the end
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        //Send each packet. Remember, each send will not happen until transfer is true.
        for(String packet : packets) {
            System.out.println(Thread.currentThread().getName() + " is sending " + packet);
            data.send(packet);

            //This sleep is just mimic the time to retrieve the packet. Not for logic
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        }
    }
}

class Receiver implements Runnable {
    private Data data;

    public Receiver (Data data) {
        this.data = data;
    }

    @Override
    public void run() {

        for(String packet = data.receive(); !"End".equals(packet); packet = data.receive()) {
            System.out.println(Thread.currentThread().getName() + " is receiving " + packet);

            //This sleep is just mimic the time to retrieve the packet. Not for logic
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        }
    }
}


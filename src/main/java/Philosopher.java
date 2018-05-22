
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by DmNikiforov on 20.05.2018.
 */
public class Philosopher implements Runnable {
    private int id;
    private Fork leftFork, rightFork;

    Philosopher(Fork left, Fork right, int number) {
        leftFork = left;
        rightFork = right;
        id = number;
    }

    private void dropAll() {
        if (rightFork.getOccupiedBy() == id)
            rightFork.drop();
        if (leftFork.getOccupiedBy() == id)
            leftFork.drop();
    }

    public void run() {
        do {
            leftFork.take(id);
            rightFork.take(id);

            if ((leftFork.getOccupiedBy() == id) && (rightFork.getOccupiedBy() == id)) {
                System.out.println("Philosopher have eatten with " + id);
                try {
                    Thread.sleep(1); //We need some time to eat
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dropAll();
            } else {
//                System.out.println(id + " Failed to eat");
                dropAll();
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1, 50) * 10); //Now sleep for some time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}

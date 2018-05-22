/**
 * Created by DmNikiforov on 20.05.2018.
 */
public class Fork {
    private int occupiedBy = -1;
    final int forkNumber;

    Fork (int i) {
        forkNumber = i;
    }

    public synchronized boolean  take(int id) {
        if (occupiedBy == -1) {
            setOccupiedBy(id);
//            System.out.println("Fork number " + forkNumber + " occupied by " + id);
            return true;
        }
//        System.out.println(id + " failed to occupy fork number " + forkNumber);
        return false;
    }
    public synchronized  void drop() {
//        System.out.println(occupiedBy + " dropped fork number " + forkNumber);
        setOccupiedBy(-1);
    }

    public synchronized int getOccupiedBy() {
        return occupiedBy;
    }

    public synchronized void setOccupiedBy(int occupiedBy) {
        this.occupiedBy = occupiedBy;
    }
}

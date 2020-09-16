package cn.xpbootcamp.lockerRobot;

public class Locker {
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Receipt saveBag(Bag bag) {
        if(capacity != 0) {
            capacity--;
            return new Receipt();
        }
        throw new LockerIsFullException();
    }
}

package cn.xpbootcamp.lockerRobot;

public class Bag {
    private BagSize size;

    public Bag(BagSize size) {
        this.size = size;
    }

    public BagSize getBagSize() {
        return size;
    }
}

enum BagSize {
    S,
    M,
    L
}

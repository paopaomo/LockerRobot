package cn.xpbootcamp.lockerRobot;

public class Bag {
    private bagSize size;

    public Bag(bagSize size) {
        this.size = size;
    }

    public bagSize getBagSize() {
        return size;
    }
}

enum bagSize {
    S,
    M,
    L
}

package cn.xpbootcamp.lockerRobot;

public class Receipt {
    private BagSize bagSize;

    public Receipt(BagSize bagSize) {
        this.bagSize = bagSize;
    }

    public BagSize getBagSize() {
        return bagSize;
    }
}

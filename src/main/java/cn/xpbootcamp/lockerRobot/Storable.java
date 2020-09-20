package cn.xpbootcamp.lockerRobot;

public interface Storable {
    Receipt saveBag(Bag bag);

    Bag takeBag(Receipt receipt);
}

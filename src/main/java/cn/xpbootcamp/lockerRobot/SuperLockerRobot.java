package cn.xpbootcamp.lockerRobot;

import java.util.List;

public class SuperLockerRobot {
    private List<Locker> lockers;

    public SuperLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Receipt saveBag(Bag bag) {
        return lockers.get(0).saveBag(bag);
    }
}

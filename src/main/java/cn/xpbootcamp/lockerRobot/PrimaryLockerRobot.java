package cn.xpbootcamp.lockerRobot;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Receipt saveBag(Bag bag) {
        for (Locker locker : lockers) {
            if(locker.hasAvailableCapacity()) {
                return locker.saveBag(bag);
            }
        }
        throw new LockerIsFullException();
    }

    public Bag takeBag(Receipt receipt) {
        for (Locker locker : lockers) {
            if(locker.containsReceipt(receipt)) {
                return locker.takeBag(receipt);
            }
        }
        return null;
    }
}

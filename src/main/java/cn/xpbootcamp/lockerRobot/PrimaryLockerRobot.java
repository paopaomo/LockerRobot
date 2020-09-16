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
}

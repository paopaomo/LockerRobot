package cn.xpbootcamp.lockerRobot;

import java.util.List;

public class LockerRobotManager {
    private List<Storable> lockers;
    private List<Storable> primaryLockerRobots;
    private List<Storable> superLockerRobots;

    public LockerRobotManager(List<Storable> lockers,
                              List<Storable> primaryLockerRobots,
                              List<Storable> superLockerRobots) {
        this.lockers = lockers;
        this.primaryLockerRobots = primaryLockerRobots;
        this.superLockerRobots = superLockerRobots;
    }

    public Receipt saveBag(Bag bag) {
        switch (bag.getBagSize()) {
            case S:
                return saveBagByLocker(bag);
            default:
                return null;
        }
    }

    private Receipt saveBagByLocker(Bag bag) {
        for (Storable locker : lockers) {
            if(locker.hasAvailableCapacity()) {
                return locker.saveBag(bag);
            }
        }
        throw new LockerIsFullException();
    }
}

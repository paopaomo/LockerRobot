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
                return saveBagByStorable(bag, lockers);
            case M:
                return saveBagByStorable(bag, primaryLockerRobots);
            default:
                return null;
        }
    }

    private Receipt saveBagByStorable(Bag bag, List<Storable> storables) {
        for (Storable storable : storables) {
            if(storable.hasAvailableCapacity()) {
                return storable.saveBag(bag);
            }
        }
        throw new LockerIsFullException();
    }
}

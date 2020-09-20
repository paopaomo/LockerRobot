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
            case L:
                return saveBagByStorable(bag, superLockerRobots);
            default:
                return null;
        }
    }

    public Bag takeBag(Receipt receipt) {
        if(receipt == null) {
            throw new ReceiptIsInvalidException();
        }
        switch (receipt.getBagSize()) {
            case S:
                return takeBagByStorage(receipt, lockers);
            case M:
                return takeBagByStorage(receipt, primaryLockerRobots);
            case L:
                return takeBagByStorage(receipt, superLockerRobots);
            default:
                throw new ReceiptIsInvalidException();
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

    private Bag takeBagByStorage(Receipt receipt, List<Storable> storables) {
        for (Storable storable : storables) {
            if(storable.containsReceipt(receipt)) {
                return storable.takeBag(receipt);
            }
        }
        throw new ReceiptIsInvalidException();
    }
}

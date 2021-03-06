package cn.xpbootcamp.lockerRobot;

import java.util.List;

public abstract class Robot implements Storable {
    protected final List<Locker> lockers;

    public Robot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    @Override
    public abstract Receipt saveBag(Bag bag);

    @Override
    public Bag takeBag(Receipt receipt) {
        for (Locker locker : lockers) {
            if(locker.containsReceipt(receipt)) {
                return locker.takeBag(receipt);
            }
        }
        throw new ReceiptIsInvalidException();
    }

    @Override
    public boolean hasAvailableCapacity() {
        for (Locker locker : lockers) {
            if(locker.hasAvailableCapacity()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsReceipt(Receipt receipt) {
        for (Locker locker : lockers) {
            if(locker.containsReceipt(receipt)) {
                return true;
            }
        }
        return false;
    }
}

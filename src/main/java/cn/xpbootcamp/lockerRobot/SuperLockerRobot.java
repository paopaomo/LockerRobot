package cn.xpbootcamp.lockerRobot;

import java.util.List;

public class SuperLockerRobot {
    private List<Locker> lockers;

    public SuperLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Receipt saveBag(Bag bag) {
        Locker maxLocker = getLockerWithMaximumCapacity();
        return maxLocker.saveBag(bag);
    }

    private Locker getLockerWithMaximumCapacity() {
        Locker maxLocker = lockers.get(0);
        for (int i = 1; i < lockers.size(); i++) {
            if(maxLocker.getAvailableCapacity() < lockers.get(i).getAvailableCapacity()) {
                maxLocker = lockers.get(i);
            }
        }
        return maxLocker;
    }
}

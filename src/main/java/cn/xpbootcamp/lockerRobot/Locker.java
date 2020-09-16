package cn.xpbootcamp.lockerRobot;

import java.util.HashMap;

public class Locker {
    private int capacity;
    private HashMap<Receipt, Bag> bags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Receipt saveBag(Bag bag) {
        if(hasAvailableCapacity()) {
            Receipt receipt = new Receipt();
            bags.put(receipt, bag);
            return receipt;
        }
        throw new LockerIsFullException();
    }

    public Bag takeBag(Receipt receipt) {
        if(bags.containsKey(receipt)) {
            return bags.remove(receipt);
        }
        throw new ReceiptIsInvalidException();
    }

    private boolean hasAvailableCapacity() {
        return bags.size() < capacity;
    }
}

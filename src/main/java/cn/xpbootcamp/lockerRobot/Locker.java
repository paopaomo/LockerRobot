package cn.xpbootcamp.lockerRobot;

import java.util.HashMap;

public class Locker implements Storable {
    private int capacity;
    private HashMap<Receipt, Bag> bags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Receipt saveBag(Bag bag) {
        if(hasAvailableCapacity()) {
            Receipt receipt = new Receipt();
            bags.put(receipt, bag);
            return receipt;
        }
        throw new LockerIsFullException();
    }

    @Override
    public Bag takeBag(Receipt receipt) {
        if(bags.containsKey(receipt)) {
            return bags.remove(receipt);
        }
        throw new ReceiptIsInvalidException();
    }

    public boolean hasAvailableCapacity() {
        return bags.size() < capacity;
    }

    public boolean containsReceipt(Receipt receipt) {
        return bags.containsKey(receipt);
    }

    public int getAvailableCapacity() {
        return capacity - bags.size();
    }
}

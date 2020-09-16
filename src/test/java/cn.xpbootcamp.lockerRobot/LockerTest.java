package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {
    @Test
    public void should_return_a_receipt_when_save_bag_given_a_locker_has_available_capacity() {
        Locker locker = new Locker(10);

        Receipt receipt = locker.saveBag(new Bag());

        Assert.assertNotNull(receipt);
    }
}

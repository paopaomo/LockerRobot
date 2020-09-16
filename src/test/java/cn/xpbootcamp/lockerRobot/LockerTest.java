package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    public void should_return_a_receipt_when_save_bag_given_a_locker_has_available_capacity() {
        Locker locker = new Locker(10);

        Receipt receipt = locker.saveBag(new Bag());

        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_a_locker_has_no_available_capacity() {
        Locker locker = new Locker(1);
        locker.saveBag(new Bag());

        assertThrows(LockerIsFullException.class, () -> {
            locker.saveBag(new Bag());
        });
    }
}

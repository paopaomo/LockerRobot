package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PrimaryLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_both_has_available_capacity() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = primaryLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_locker1_is_full_locker2_has_available_capacity() {
        Locker locker1 = new Locker(1);
        locker1.saveBag(new Bag());
        Locker locker2 = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = primaryLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }
}

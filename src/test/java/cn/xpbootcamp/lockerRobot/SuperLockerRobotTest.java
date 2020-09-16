package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SuperLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_locker1_has_5_and_locker2_has_3_available_capacity() {
        Locker locker1 = new Locker(5);
        Locker locker2 = new Locker(3);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = superLockerRobot.saveBag(bag);

        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_locker1_has_3_and_locker2_has_5_available_capacity() {
        Locker locker1 = new Locker(3);
        Locker locker2 = new Locker(5);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = superLockerRobot.saveBag(bag);

        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }
}

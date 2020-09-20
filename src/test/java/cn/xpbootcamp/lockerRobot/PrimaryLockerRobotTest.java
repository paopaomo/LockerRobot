package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimaryLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_both_has_available_capacity() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag(bagSize.M);
        Receipt receipt = primaryLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_locker1_is_full_locker2_has_available_capacity() {
        Locker locker1 = new Locker(1);
        locker1.saveBag(new Bag(bagSize.M));
        Locker locker2 = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag(bagSize.M);
        Receipt receipt = primaryLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_robot_has_2_lockers_both_are_full() {
        Locker locker1 = new Locker(1);
        locker1.saveBag(new Bag(bagSize.M));
        Locker locker2 = new Locker(1);
        locker2.saveBag(new Bag(bagSize.M));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(locker1, locker2));

        assertThrows(LockerIsFullException.class, () -> {
            primaryLockerRobot.saveBag(new Bag(bagSize.M));
        });
    }

    @Test
    public void should_return_the_right_bag_when_take_bag_given_a_valid_receipt() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(new Locker(10)));
        Bag bag = new Bag(bagSize.M);
        Receipt receipt = primaryLockerRobot.saveBag(bag);

        Bag retrieveBag = primaryLockerRobot.takeBag(receipt);

        Assert.assertEquals(bag, retrieveBag);
    }

    @Test
    public void should_throw_ReceiptIsInvalidException_when_take_bag_given_an_invalid_receipt() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(List.of(new Locker(10)));

        assertThrows(ReceiptIsInvalidException.class, () -> {
            primaryLockerRobot.takeBag(null);
        });
    }
}

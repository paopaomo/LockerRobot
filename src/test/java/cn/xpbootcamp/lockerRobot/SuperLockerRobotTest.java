package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_locker1_has_5_and_locker2_has_3_available_capacity() {
        Locker locker1 = new Locker(5);
        Locker locker2 = new Locker(3);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag(bagSize.L);
        Receipt receipt = superLockerRobot.saveBag(bag);

        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_locker1_has_3_and_locker2_has_5_available_capacity() {
        Locker locker1 = new Locker(3);
        Locker locker2 = new Locker(5);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag(bagSize.L);
        Receipt receipt = superLockerRobot.saveBag(bag);

        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_robot_has_2_lockers_are_both_full() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        locker1.saveBag(new Bag(bagSize.L));
        locker2.saveBag(new Bag(bagSize.L));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(locker1, locker2));

        assertThrows(LockerIsFullException.class, () -> {
            superLockerRobot.saveBag(new Bag(bagSize.L));
        });
    }

    @Test
    public void should_save_to_locker1_and_return_a_receipt_when_save_bag_given_robot_has_2_lockers_has_the_same_available_capacity() {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(2);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag(bagSize.L);
        Receipt receipt = superLockerRobot.saveBag(bag);

        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_return_the_right_bag_when_take_bag_given_a_valid_receipt() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(new Locker(10)));
        Bag bag = new Bag(bagSize.L);
        Receipt receipt = superLockerRobot.saveBag(bag);

        Bag retrieveBag = superLockerRobot.takeBag(receipt);

        Assert.assertEquals(bag, retrieveBag);
    }

    @Test
    public void should_throw_ReceiptIsInvalidException_when_take_bag_given_an_invalid_receipt() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(List.of(new Locker(10)));

        assertThrows(ReceiptIsInvalidException.class, () -> {
            superLockerRobot.takeBag(null);
        });
    }
}

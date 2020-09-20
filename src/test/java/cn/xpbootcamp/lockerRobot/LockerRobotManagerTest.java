package cn.xpbootcamp.lockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerRobotManagerTest {
    @Test
    public void should_save_to_locker_and_return_a_receipt_when_save_s_size_bag_given_manage_1_locker_1_primaryLockerRobot_1_superLockerRobot_all_have_available_capacity() {
        Locker locker = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot =
                new PrimaryLockerRobot(List.of(new Locker(10)));
        SuperLockerRobot superLockerRobot =
                new SuperLockerRobot(List.of(new Locker(10)));
        LockerRobotManager lockerRobotManager =
                new LockerRobotManager(List.of(locker), List.of(primaryLockerRobot), List.of(superLockerRobot));

        Bag bag = new Bag(BagSize.S);
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_s_size_bag_given_manage_1_locker_1_primaryLockerRobot_1_superLockerRobot_and_locker_is_full() {
        Locker locker = new Locker(1);
        locker.saveBag(new Bag(BagSize.S));
        PrimaryLockerRobot primaryLockerRobot =
                new PrimaryLockerRobot(List.of(new Locker(10)));
        SuperLockerRobot superLockerRobot =
                new SuperLockerRobot(List.of(new Locker(10)));
        LockerRobotManager lockerRobotManager =
                new LockerRobotManager(List.of(locker),
                        List.of(primaryLockerRobot), List.of(superLockerRobot));

        assertThrows(LockerIsFullException.class, () -> {
            lockerRobotManager.saveBag(new Bag(BagSize.S));
        });
    }

    @Test
    public void should_save_to_primaryLockerRobot_and_return_a_receipt_when_save_m_size_bag_given_manage_1_locker_1_primaryLockerRobot_1_superLockerRobot_all_have_available_capacity() {
        Locker locker = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot =
                new PrimaryLockerRobot(List.of(new Locker(10)));
        SuperLockerRobot superLockerRobot =
                new SuperLockerRobot(List.of(new Locker(10)));
        LockerRobotManager lockerRobotManager =
                new LockerRobotManager(List.of(locker), List.of(primaryLockerRobot), List.of(superLockerRobot));

        Bag bag = new Bag(BagSize.M);
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, primaryLockerRobot.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_m_size_bag_given_manage_1_locker_1_primaryLockerRobot_1_superLockerRobot_and_primaryLockerRobot_is_full() {
        Locker locker = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot =
                new PrimaryLockerRobot(List.of(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag(BagSize.M));
        SuperLockerRobot superLockerRobot =
                new SuperLockerRobot(List.of(new Locker(10)));
        LockerRobotManager lockerRobotManager =
                new LockerRobotManager(List.of(locker),
                        List.of(primaryLockerRobot), List.of(superLockerRobot));

        assertThrows(LockerIsFullException.class, () -> {
            lockerRobotManager.saveBag(new Bag(BagSize.M));
        });
    }

    @Test
    public void should_save_to_superLockerRobot_and_return_a_receipt_when_save_l_size_bag_given_manage_1_locker_1_primaryLockerRobot_1_superLockerRobot_all_have_available_capacity() {
        Locker locker = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot =
                new PrimaryLockerRobot(List.of(new Locker(10)));
        SuperLockerRobot superLockerRobot =
                new SuperLockerRobot(List.of(new Locker(10)));
        LockerRobotManager lockerRobotManager =
                new LockerRobotManager(List.of(locker), List.of(primaryLockerRobot), List.of(superLockerRobot));

        Bag bag = new Bag(BagSize.L);
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, superLockerRobot.takeBag(receipt));
    }
}

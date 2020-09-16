### PrimaryLockerRobot

#### 存包

1.Given PrimaryLockerRobot管理两个locker,均有可用容量

When PrimaryLockerRobot 存包

Then 存入locker1中,返回小票,存包成功

2.Given PrimaryLockerRobot管理两个locker,locker1已满,locker2有可用容量

When PrimaryLockerRobot 存包

Then 存入locker2中,返回小票,存包成功

3.Given PrimaryLockerRobot管理两个locker,均无可用容量

When PrimaryLockerRobot 存包

Then 提示locker已满,存包失败

#### 取包

1.Given 正确小票

When PrimaryLockerRobot 取包

Then 取出正确的包裹,取包成功

2.Given 非法小票

When PrimaryLockerRobot 取包

Then 提示小票不正确,取包失败


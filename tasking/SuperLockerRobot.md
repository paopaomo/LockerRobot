### SuperLockerRobot

#### 存包

1.Given SuperLockerRobot管理两个locker,locker1可用容量为5,locker2可用容量为2

When SuperLockerRobot 存包

Then 存入locker1中,返回小票,存包成功

2.Given SuperLockerRobot管理两个locker,locker1可用容量为2,locker2可用容量为5

When SuperLockerRobot 存包

Then 存入locker2中,返回小票,存包成功

3.Given SuperLockerRobot管理两个locker,均无可用容量

When SuperLockerRobot 存包

Then 提示locker已满,存包失败

#### 取包

1.Given 正确小票

When SuperLockerRobot 取包

Then 取出正确的包裹,取包成功

2.Given 非法小票

When SuperLockerRobot 取包

Then 提示小票不正确,取包失败


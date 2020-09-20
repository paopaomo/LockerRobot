### SuperMarketManager

#### 存包

1.Given SuperMarketManager 管理一个Locker, 一个PrimaryLockerRobot
, 一个SuperLockerRobot, 且均有可用容量

When SuperMarketManager存S号包裹

Then 存入Locker中, 返回小票, 存包成功

2.Given SuperMarketManager 管理一个Locker, 一个PrimaryLockerRobot
, 一个SuperLockerRobot, 其中, Locker已满

When SuperMarketManager存S号包裹

Then 提示locker已满, 存包失败

3.Given SuperMarketManager 管理一个Locker, 一个PrimaryLockerRobot
, 一个SuperLockerRobot, 且均有可用容量

When SuperMarketManager存M号包裹

Then 包由PrimaryLockerRobot存入, 返回小票, 存包成功

4.Given SuperMarketManager 管理一个Locker, 一个PrimaryLockerRobot
, 一个SuperLockerRobot, 其中, PrimaryLockerRobot 管理的locker已满

When SuperMarketManager存M号包裹

Then 提示locker已满, 存包失败

5.Given SuperMarketManager 管理一个Locker, 一个PrimaryLockerRobot
, 一个SuperLockerRobot, 且均有可用容量

When SuperMarketManager存L号包裹

Then 包由SuperLockerRobot存入, 返回小票, 存包成功

6.Given SuperMarketManager 管理一个Locker, 一个PrimaryLockerRobot
, 一个SuperLockerRobot, 其中, SuperLockerRobot 管理的locker已满

When SuperMarketManager存L号包裹

Then 提示locker已满, 存包失败

#### 取包

1.Given 正确的S号小票

When SuperMarketManager取包

Then 取出正确的包裹, 取包成功

2.Given 正确的M号小票

When SuperMarketManager取包

Then 取出正确的包裹, 取包成功

3.Given 正确的L号小票

When SuperMarketManager取包

Then 取出正确的包裹, 取包成功

4.Given 非法小票

When SuperMarketManager取包

Then 提示小票不正确, 取包失败

5.Given S号小票

When SuperMarketManager取M号包

Then 提示小票不正确, 取包失败

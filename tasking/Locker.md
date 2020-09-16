### Locker

#### 存包

1.Given Locker,有可用容量

When 存包

Then 返回小票,存包成功

2.Given Locker,无可用容量

When 存包

Then 提示locker已满,存包失败

#### 取包

1.Given 正确小票

When 取包

Then 取出正确的包裹,取包成功

2.Given 重复小票

When 取包

Then 提示小票不正确,取包失败

3.Given 非法小票

When 取包

Then 提示小票不正确,取包失败

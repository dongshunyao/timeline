# 时间线应用 原型实现

原型采用前后端分离的形式进行实现

前端使用 Vue.js

后端使用 springboot

说明

1. 数据库初始化脚本见 `code/server/timeline/timeline.sql` 请新建库timeline并执行

2. 数据库请新建用户 `timeline:123` 权限为 timeline 库全部权限

```sql
create user 'timeline'@'localhost' identified by '123';
grant all privileges on `timeline`.* to 'timeline'@'localhost';
```
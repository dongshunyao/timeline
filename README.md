Info：

1.数据库初始化脚本见code/server/timeline/timeline.sql 请新建库timeline并执行
2.数据库请新建用户 timeline:123 权限为 timeline 库全部权限

```
create user 'timeline'@'localhost' identified by '123';
grant all privileges on `timeline`.* to 'timeline'@'localhost';
```

# 软件系统构思综合训练 时间线应用

代码请见 `code`

文档请见 `doc`


API 0.1
快速迭代中，随时可能在不通知全员的情况下改动（但如果是因为跟你交涉而改动话肯定会通知你），请实时关注

---
## 1.1 /user/login|登录

    用户登录，三平台登录，获取uid和token，用于后续身份验证

request:
键值|名称|描述
-|-|-
type|类型|登录的类型，可选"phone","qq","wechat"
urn|用户名|手机登录则为手机号，否则为对应标识账号
pw|密码|密码哈希或对应平台token

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
uid [number]|用户id|系统内唯一标志符，用于后续操作
token|验证串|和uid一起做身份验证

注：1.哈希就不哈希了。2.qq和wechat验证部分留空就好

---
## 1.2 /user/logout|登出

    用户登出

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 1.3 /user/reg|注册

    手机号注册

request:
键值|名称|描述
-|-|-
nickname|昵称|2-18半角长度
phone|手机号|.
code|短信验证码|.
password|密码哈希|.

注：哈希就不哈希了。

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
uid [number]|用户id|系统内唯一标志符，用于后续操作
token|验证串|和uid一起做身份验证

注：注册时请调用验证码获取接口，向用户手机发送验证码（你可以当发出去的是六个0）

---
## 1.4 /user/phone|发送验证码

    向用户手机发送验证码

request:
键值|名称|描述
-|-|-
phone|手机号|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

注：后台实现优先级较低，可以先放个壳子

---
## 1.5 /user/info|用户信息

    查询本人基本信息

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
nickname|昵称|可修改
isVIP|是否会员|.
regtime|注册时间|unix时间戳

////你们想想这还能加啥？

---
## 1.6 /user/infoupd|修改用户信息

    修改个人信息

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
nickname|昵称|可选项

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

注：所有可修改项都是[可选项]，放到request里

---
---
---

## 2.1 /task/list|任务列表

    取任务列表

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
list [array]|列表体|.

其中list元素描述如下
键值|名称|描述
-|-|-
tid|任务id|.
title|标题|任务标题
begin|起始时间|unix时间戳
end|终止时间|unix时间戳
detail|描述|任务描述
type|重复|事件重复形式[daily,weekly,monthly]

---
## 2.2 /task/view|查看单个任务

    查单个任务信息

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
tid|任务id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
tid|任务id|.
title|标题|任务标题
begin|起始时间|unix时间戳
end|终止时间|unix时间戳
detail|描述|任务描述
type|重复|事件重复形式[daily,weekly,monthly]
group [number]|是否组织任务|0否1是

---
## 2.3 /task/upd|修改任务
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
tid|任务id|.
detail|任务描述|
...

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

注:可修改的项目为可选项，置入request中

---
## 2.4/task/add|添加任务

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
title|标题|任务标题
begin|起始时间|unix时间戳
end|终止时间|unix时间戳
detail|描述|任务描述
type|重复|事件重复形式[daily,weekly,monthly]
groupid|组id|指定一个组，为其添加任务（-1不属于组）

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 2.5/task/del|删除任务

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
tid|任务id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
---
---

---
## 3.1 /rcd/list|记录列表

    取记录列表

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
list [array]|列表体|.

其中list元素描述如下
键值|名称|描述
-|-|-
rid|记录id|.
title|标题|任务标题
time|时间|unix时间戳
detail|描述|任务描述

---
## 3.2 /red/view|查看单个记录

    查单个记录信息

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
rid|记录id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
rid|记录id|.
title|标题|记录标题
time|时间|unix时间戳
detail|描述|记录描述
picture [array]  |图片列表

---
## 3.3 /rcd/upd|修改记录
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
rid|记录id|.
...

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

注:可修改的项目为可选项，置入request中

---
## 3.4/rcd/add|添加记录

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
title|标题|记录标题
time|时间|unix时间戳
detail|描述|记录描述
picture [array]  |图片列表

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 3.5/task/del|删除记录

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
rid|记录id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 3.6 /rcd/picupload|上传图片 
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
pic [bin]|图片

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
picname|图片名|上传后产生的文件名，附加在记录提交部分即可

---
## 4./search|联合搜索

    搜索

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
type|搜索分类|0全部，1任务，2记录
word|关键字|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
listtask [array]|任务结果|.
listrcd [array]|记录结果|.

---
---
---
## 5.1 /group/list|组列表

request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
listmanage [array]|管理组列表|.
listin [array]|加入组列表|.

其中组的描述方式为
键值|名称|描述
-|-|-
id|组id|.
name|组名|.

---
## 5.2 /group/make|创建组
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
name|组名|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 5.3 /group/del|删除组
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
id|组id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 5.4 /group/join|申请加入组
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
id|组id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 5.5 /group/manage|加人/T人
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
id|组id|.
op|操作|add/del
opuid|目标uid|所操作的用户

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

---
## 5.6 /group/info|组信息
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
id|组id|.

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败
name|组名|.
member [array:string]|成员列表|[{id,name},{},{}...]
task [array]|事件列表|同tasklist
wantjoin [array]|申请者列表|[{id,name},{},{}...]

## 5.7 /group/upd|修改组信息
request:
键值|名称|描述
-|-|-
uid [number]|用户id|系统内唯一标志符
token|验证串|和uid一起做身份验证
id|组id|.
...|...|...

response:
键值|名称|描述
-|-|-
state [number]|返回码|0为正常，-1为失败

注：可选项

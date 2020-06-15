<template>
    <div>
        <my-title/>
        <div style="margin: 20px auto; width: 50%;">
            <el-card>
                <div style="text-align: center; margin: 10px;">
                    <span style="font-size: 2rem;">
                        个人设置
                    </span>
                </div>
                <el-form label-width="100px" label-position="left">
                    <el-form-item label="昵称">
                        <el-input v-model="userName" clearable></el-input>
                    </el-form-item>
                    <el-form-item label="是否为会员">
                        <el-input v-model="isVIP" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="注册时间">
                        <el-input v-model="registerTime" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="密码修改">
                        <el-input v-model="password" type="password" disabled clearable></el-input>
                    </el-form-item>
                </el-form>
                <div style="text-align: center;">
                    <el-button @click="updateUserInfo" type="primary" size="medium">确认更新</el-button>
                    <el-button @click="resetUserInfo" size="medium">重置</el-button>
                </div>
            </el-card>
        </div>
        <my-footer/>
    </div>
</template>

<script>
    import API from "../api";
    import Cookies from 'js-cookie'
    import qs from 'qs'
    import MyTitle from "../components/myTitle";
    import MyFooter from "../components/myFooter";

    export default {
        name: "setting",
        components: {MyFooter, MyTitle},
        data() {
            return {
                userName: "test",
                registerTime: this.formatTimeAsYYMMDD(Cookies.get('regtime')),
                password: '******',
                isVIP: ''
            }
        },
        created: function () {
            this.resetUserInfo();
        },
        methods: {
            updateUserInfo: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    nickname: this.userName
                }
                API.updateUserInfo(data)
                    .then(res => {
                        if (res.state === 0) alert('修改成功')
                    })
                    .catch(res => {

                    })
            },
            resetUserInfo: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token")
                }
                data = qs.stringify(data);
                API.userInfo(data)
                    .then(res => {
                        if (res.state === 0){
                            this.userName = res.nickname;
                            this.registerTime = this.formatTimeAsYYMMDD(res.regtime * 1000)
                            this.isVIP = (res.isVIP ? "是" : "否");
                        }
                    })
                    .catch(res => {

                    })

            },
            formatTimeAsYYMMDD: function (time) {
                if (time === null) return null

                let date = new Date(time);

                let year = date.getFullYear(),
                    month = date.getMonth() + 1,//月份是从0开始的
                    day = date.getDate();
                return year + '-' +
                    month + '-' +
                    day + ' ';
            }
        }
    }
</script>

<style scoped>

</style>
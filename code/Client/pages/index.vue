<template>
    <div>
        <div style="position: fixed;width: 100%; height: 100%;left:0;top:0; z-index: -1; overflow: hidden">
            <img style="height: 100%;width: 100%;" src="../assets/piqsels.com-id-zbeou.jpg" alt="背景图片">
        </div>
        <el-tabs class="card" type="border-card">
            <el-tab-pane label="用户登录">
                <p class="title">
                    TimeLine 应用
                </p>
                <el-form :model="login_module" :rules="loginRule" label-width="80px" label-position="left">
                    <el-form-item label="用户名" prop="user_name">
                        <el-input v-model="login_module.user_name" style="width: 200px"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="user_pwd">
                        <el-input v-model="login_module.user_pwd" style="width: 200px"></el-input>
                    </el-form-item>
                </el-form>
                <div style="text-align: center">
                    <el-button type="primary">登录</el-button>
                </div>
            </el-tab-pane>
            <el-tab-pane label="用户注册">
                <el-form>
                    <el-form-item label="用户名">
                        <el-input v-model="register_module.user_name"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱">
                        <el-input v-model="register_module.user_email"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号">
                        <el-input v-model="register_module.user_phone"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="register_module.user_pwd"></el-input>
                    </el-form-item>
                    <el-form-item label="二次确认密码">
                        <el-input v-model="register_module.user_confirm_pwd"></el-input>
                    </el-form-item>
                </el-form>
                <div style="text-align: center">
                    <el-button type="primary">登录</el-button>
                </div>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {

        data() {
            return {
                login_module: {
                    user_name: '',
                    user_pwd: '',
                },
                register_module: {
                    user_name: '',
                    user_email: '',
                    user_phone: '',
                    user_pwd: '',
                    user_confirm_pwd: ''
                },
                loginRule: {
                    user_name: [
                        {required: true, message: '请输入用户名', trigger: 'blur'}
                    ],
                    user_pwd: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ]
                },
            }
        },

        mounted() {

        },

        methods: {
            userLogin() {
                let data = {
                    type: '',
                    urn: this.login_module.user_name,
                    pw: this.login_module.user_pwd
                }
                this.$axios.$post('localhost:8080', data)
                    .then(res => {
                        let data = res.data
                        if (data.state === 0) {
                            this.$router.push({path: '/home'})
                            localStorage.setItem("uid", data.uid)
                            localStorage.setItem("token", data.token)
                        } else {
                            this.$alert('密码或用户名错误', '登录失败', {
                                confirmButtonText: '确认',
                            })
                        }
                    })
                    .catch(res => {

                    })
            }
        },

    }
</script>

<style scoped>
    .title {
        font-size: 1.8rem;
        text-align: center;
    }

    .card {
        width: 20rem;
        min-height: 15rem;
        margin: 10% auto;
        border-radius: 10px;
    }

</style>


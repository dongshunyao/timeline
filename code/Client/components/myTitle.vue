<template>
    <div class="backgroud">
        <div style="width: 82%;">
            <img src="../static/weblogo.png" style="width: 60px;float: left;margin-left: 30px">
            <h2 style="margin-left: 20px;float: left;margin-top: 15px">TimeLine时间线应用</h2>
        </div>
        <el-menu :default-active="activeIndex"
                 class="el-menu-demo"
                 mode="horizontal"
                 style="float: right">
            <el-menu-item index="1" @click="toHomePage">首页</el-menu-item>
            <el-menu-item index="2" @click="toMyOrg">我的组织</el-menu-item>
            <el-submenu index="3">
                <template slot="title">{{this.name}}</template>
                <el-menu-item index="3-1" disabled>数据统计</el-menu-item>
                <el-menu-item index="3-2" @click="toSetting">个人设置</el-menu-item>
                <el-menu-item index="3-3" @click="Exit">退出登录</el-menu-item>
            </el-submenu>
        </el-menu>

        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="30%">
            <span>该功能暂未开启,请充值会员</span>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="Back">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<script>
    import API from "../api";
    import Pro from '../api/API_PRO';
    import Cookies from 'js-cookie';

    export default {
        name: "myTitle",
        props: {
            activeIndex: {
                type: String
            }
        },
        data() {
            return {
                name: Cookies.get('name'),
                token: Cookies.get('token'),
                dialogVisible:false,
            }
        },

        methods: {
            toHomePage() {
                this.$router.push({path: `/home`});
            },
            toMyOrg() {
                this.$router.push({path: `/group`});
            },

            Back(){
                this.dialogVisible=false;
                this.activeIndex='1';
                //this.$router.push({path: `/home`});
            },

            toSetting() {
                this.$router.push({path: '/setting'})
            },
            Exit() {
                this.$router.push({path: '/'})
            },
        }
    }
</script>

<style scoped>
    .backgroud {
        width: 100%;
        min-width: 1000px;
        height: 80px;
        display: flex;
        align-items: center;
        background-color: #e6f4ff;
    }

    >>> .el-menu {
        background-color: transparent;
    }

    >>> .el-menu--horizontal > .el-menu-item:not(.is-disabled):hover, .el-menu--horizontal > .el-menu-item:not(.is-disabled):focus {
        background-color: transparent;
    }

</style>
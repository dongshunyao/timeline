<template>
    <div class="backgroud">
        <div style="width: 82%">
            <h2 style="margin-left: 50px">TimeLine时间线应用</h2>
        </div>
        <el-menu :default-active="activeIndex"
                 class="el-menu-demo"
                 mode="horizontal"
                 @select="handleSelect"
                 style="float: right">
            <el-menu-item index="1">首页</el-menu-item>
            <el-menu-item index="2">我的组织</el-menu-item>
            <el-submenu index="3">
                <template slot="title">{{this.name}}</template>
                <el-menu-item index="3-1">数据统计</el-menu-item>
                <el-menu-item index="3-2">个人设置</el-menu-item>
                <el-menu-item index="3-3">退出登录</el-menu-item>
            </el-submenu>
        </el-menu>
    </div>
</template>

<script>
    import API from "../api";
    import Pro from '../api/API_PRO';
    import Cookies from 'js-cookie';
    export default {
        name: "myTitle",
        props:{
            activeIndex: {
                type: String
            }
        },
        data(){
            return{
                name:Cookies.get('name'),
                token:Cookies.get('token'),
            }
        },

        methods:{
            toMyOrg(){
                this.$router.push({path: `/homePage`});
            }


        }
    }
</script>

<style scoped>
    .backgroud{
        width: 100%;
        min-width: 1000px;
        height:80px;
        display: flex;
        align-items: center;
        background-color: #e6f4ff;
    }

    >>>.el-menu{
        background-color: transparent;
    }

    >>>.el-menu--horizontal > .el-menu-item:not(.is-disabled):hover, .el-menu--horizontal > .el-menu-item:not(.is-disabled):focus {
        background-color: transparent;
    }

</style>
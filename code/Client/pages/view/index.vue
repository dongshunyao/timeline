<template>
    <div class="bodyDiv">
        <my-title :active-index="activeIndex"></my-title>
        <div style="width: 80%;margin-left: 10%">
            <el-tabs v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="时间线视图" name="first">
                    <list style="width: 50%"></list>
                </el-tab-pane>
                <el-tab-pane label="周视图" name="second">

                </el-tab-pane>
                <el-tab-pane label="月视图" name="third">
                    <calendar-month></calendar-month>
                </el-tab-pane>
            </el-tabs>
        </div>
        <my-footer style="margin-top: 20px;bottom: 0"></my-footer>
    </div>
</template>

<script>
    import TimeLine from "../../components/TimeLine";
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";
    import CalendarMonth from "../../components/CalendarMonth";
    import List from "../home/list";
    export default {
        name: "index",
        components: {List, CalendarMonth, MyFooter, MyTitle, TimeLine},
        data(){
            return{
                activeIndex:'1',
                activeName: 'first',

            }
        }
    }
</script>

<style scoped>
    .bodyDiv{
        display: inline-block;
        background-color: #efefef;
        min-height: 630px;
        min-width: 100%;
    }
</style>
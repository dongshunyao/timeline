<template>
    <div class="bodyDiv">
        <my-title :active-index="activeIndex"></my-title>
        <div style="width: 80%;margin-left: 10%">
            <el-tabs v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="时间线视图" name="first">
                    <list :ismain="false" style="width: 49%;float: left;min-height: 550px" @finalTid="receiveTid"></list>
                    <detail-card v-if="isTask" :task="taskDetail" style="width: 49%;margin-left: 2%;float: left;min-height: 520px"></detail-card>
                    <record-card v-if="!isTask" :record="recordDetail" style="width: 49%;margin-left: 2%;float: left;min-height: 520px"></record-card>
                </el-tab-pane>
                <el-tab-pane label="周视图" name="second">
                    <calendar-week :base-list="allList" ref="weekSight"></calendar-week>
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
    import List from "../../components/list";
    import CalendarWeek from "../../components/CalendarWeek";
    import DetailCard from "../../components/detailCard";
    import API from "../../api";
    import Cookies from 'js-cookie';
    import qs from "qs";
    import RecordCard from "../../components/recordCard";
    export default {
        name: "index",
        components: {RecordCard, DetailCard, CalendarWeek, List, CalendarMonth, MyFooter, MyTitle, TimeLine},
        data(){
            return{
                activeIndex:'1',
                activeName: 'first',
                clickedTid:'',
                taskDetail:{},
                recordDetail:{},
                allList:[],
                isTask:true,
            }
        },

        mounted(){
            this.getAllList();
        },

        methods:{
            receiveTid(data){
                if(data.isTask===true){
                    this.clickedTid=data.tid;
                    this.isTask=true;
                    let data1={
                        uid:Cookies.get('uid'),
                        token:Cookies.get('token'),
                        tid:data.tid,
                    };
                    data1 = qs.stringify(data1);
                    API.taskDetail(data1).then(res=>{
                        if(res.code){
                            alert(res.message)
                        }
                        this.taskDetail=res;
                        this.taskDetail.begin=new Date(this.taskDetail.begin*1000).toLocaleString();
                        this.taskDetail.end=new Date(this.taskDetail.end*1000).toLocaleString();
                    }).catch(msg=>{
                        alert(msg);
                    });
                }else{
                    this.clickedRid=data.rid;
                    this.isTask=false;
                    let data1={
                        uid:Cookies.get('uid'),
                        token:Cookies.get('token'),
                        rid:data.rid,
                    };
                    data1 = qs.stringify(data1);
                    API.recordDetail(data1).then(res=>{
                        if(res.code){
                            alert(res.message)
                        }
                        this.recordDetail=res;
                        this.recordDetail.time=new Date(this.recordDetail.time*1000).toLocaleString();
                    }).catch(msg=>{
                        alert(msg);
                    });
                }

            },

            getAllList(){
                let data={
                    uid:Cookies.get('uid'),
                    token:Cookies.get('token'),
                };
                data = qs.stringify(data);
                API.allTask(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    this.clickedTid=res.list[0].tid;
                    let temp={
                        tid:res.list[0].tid,
                        isTask:true,
                    };
                    this.receiveTid(temp);
                    res.list.forEach(item=>{
                        item.time=item.begin;
                        this.allList.push(item);
                    });
                }).catch(msg=>{
                    alert(msg);
                });
                API.allRecord(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    res.list.forEach(item=>{
                        this.allList.push(item);
                    });
                }).catch(msg=>{
                    alert(msg);
                });
            },

            handleClick(tab, event){
                if(this.activeName==="second"){
                    this.$refs.weekSight.setList();
                }
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
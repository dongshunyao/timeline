<template>
    <div>
        <el-card>
            <el-button type="text" style="float: right;margin-right: 5px;margin-top: -10px" @click="toViewPage">更多>></el-button>
            <br/>
            <el-tabs v-model="activeName" style="margin-top: -10px">
                <el-tab-pane label="任务列表" name="first">
                    <time-line :all-list="taskList"></time-line>
                </el-tab-pane>
                <el-tab-pane label="记录列表" name="second">
                    <time-line :all-list="recordList"></time-line>
                </el-tab-pane>
            </el-tabs>
        </el-card>
    </div>
</template>

<script>
    import API from "../api";
    import Pro from '../api/API_PRO';
    import Cookies from 'js-cookie';
    import TimeLine from "./TimeLine";
    export default {
        name: "list",
        components: {TimeLine},
        data(){
            return{
                //token:Cookies.get("token"),
                token:'0427e0c0a83ecfdb8b8a32bb46d970b0',
                uid:9,
                activeName:'first',
                taskList:[{
                    begin:"2018/4/12",
                    title:"任务1",
                    detail:"This is task 1",
                },{
                    begin:"2018/4/16",
                    title:"任务2",
                    detail:"This is task 2",
                },{
                    begin:"2018/6/12",
                    title:"任务3",
                    detail:"This is task 3",
                },{
                    begin:"2018/8/10",
                    title:"任务4",
                    detail:"This is task 4",
                }],

                recordList:[{
                    time:"2020/11/10",
                    title:"记录1",
                    content:"This is task 1",
                },{
                    time:"2020/1/20",
                    title:"记录2",
                    content:"This is task 2",
                },{
                    time:"2019/11/18",
                    title:"记录3",
                    content:"This is task 3",
                },{
                    time:"2018/11/18",
                    title:"记录4",
                    content:"This is task 4",
                }]
            }
        },

        mounted(){
            this.getList();
        },

        methods:{
            getList(){
                let data={
                    token: this.token,
                    uid:this.uid
                };

                API.allTask(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    this.taskList=res.list;
                }).catch(msg=>{
                    alert(msg);
                });

                /*API.allRecord(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    this.recordList=res.list;
                }).catch(msg=>{
                    alert(msg);
                });*/
            },

            toViewPage(){
                this.$router.push({path: `/view`});
            }
        }
    }
</script>

<style scoped>

</style>
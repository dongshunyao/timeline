<template>
    <div>
        <el-card>

            <el-tabs v-model="activeName">
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
                token:Cookies.get("token"),
                uid:1,
                activeName:'first',
                taskList:[{
                    time:"2018/4/12",
                    title:"任务1",
                    content:"This is task 1",
                },{
                    time:"2018/4/16",
                    title:"任务2",
                    content:"This is task 2",
                },{
                    time:"2018/6/12",
                    title:"任务3",
                    content:"This is task 3",
                },{
                    time:"2018/8/10",
                    title:"任务4",
                    content:"This is task 4",
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
                    //this.taskList=res.list;
                }).catch(msg=>{
                    alert(msg);
                });

                API.allRecord(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    //this.recordList=res.list;
                }).catch(msg=>{
                    alert(msg);
                });


            }
        }
    }
</script>

<style scoped>

</style>
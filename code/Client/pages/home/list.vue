<template>
    <div>
        <div class="block">
            <el-timeline>
                <el-timeline-item v-for="item in totalList" :key="item.time" :timestamp="item.time" placement="top">
                    <el-card>
                        <h4>{{item.title}}</h4>
                        <p>{{item.content}}</p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </div>
    </div>
</template>

<script>
    import API from "../../api";
    import Pro from '../../api/API_PRO';
    import Cookies from 'js-cookie';
    export default {
        name: "list",
        data(){
            return{
                token:Cookies.get("token"),
                uid:1,
                totalList:[{
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
                    //this.totalList=res.list;
                }).catch(msg=>{
                    alert(msg);
                })
            }
        }
    }
</script>

<style scoped>

</style>
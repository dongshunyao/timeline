<template>
    <el-calendar>
        <template
                slot="dateCell"
                slot-scope="{date, data}">
            <p :class="data.isSelected ? 'is-selected' : ''">
                {{ data.day.split('-').slice(1).join('-') }}
            </p>
            <p style="white-space: pre-wrap;font-size: 12px">{{setTitle(date)}}</p>

        </template>
    </el-calendar>
</template>

<script>
    import API from "../api";
    import Cookies from 'js-cookie';
    import qs from "qs";
    export default {
        name: "CalendarMonth",
        props:{
            baseList:Array,
        },

        data() {
            return {
                temp:"",
                dailyTask:"",
                weeklyTask:["","","","","","",""],
                recordList: [],
                finalList:[],
            }
        },

        mounted(){
            //this.recordList=this.baseList;
            this.getAllList();
        },

        methods:{
            setTitle(date){
                let ans="";
                let data=date.toDateString();
                let day=date.getDay();

                for(let i=0;i<this.recordList.length;i++){
                    this.recordList[i].temptime=new Date(this.recordList[i].time*1000).toDateString();
                    if(this.recordList[i].type===1){
                        this.dailyTask+=this.recordList[i].title;
                        this.dailyTask+="\n";
                        this.recordList.splice(i,1);
                        i--;
                    }else if(this.recordList[i].type===2){
                        this.weeklyTask[new Date(this.recordList[i].time*1000).getDay()]+=
                            this.recordList[i].title;
                        this.weeklyTask[new Date(this.recordList[i].time*1000).getDay()]+="\n";
                        this.recordList.splice(i,1);
                        i--;
                    }
                    if(data === this.recordList[i].temptime){
                        ans+=this.recordList[i].title;
                        ans+="\n";
                    }
                }
                ans+=this.dailyTask;
                ans+=this.weeklyTask[day];

                return ans;
            },

            getAllList(){
                this.recordList=[];
                this.dailyTask="";
                this.weeklyTask=["","","","","","",""];
                let data={
                    uid:Cookies.get('uid'),
                    token:Cookies.get('token'),
                };
                data = qs.stringify(data);
                API.allTask(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    res.list.forEach(item=>{
                        item.time=item.begin;
                        this.recordList.push(item);
                    });
                }).catch(msg=>{
                    alert(msg);
                });
                API.allRecord(data).then(res=>{
                    if(res.code){
                        alert(res.message)
                    }
                    res.list.forEach(item=>{
                        this.recordList.push(item);
                    });
                }).catch(msg=>{
                    alert(msg);
                });
            },

        }
    }
</script>

<style scoped>

</style>
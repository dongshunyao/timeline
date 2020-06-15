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
                weeklyTask:"",
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

                for(let i=0;i<this.recordList.length;i++){
                    this.recordList[i].temptime=new Date(this.recordList[i].time*1000).toDateString();
                    if(this.recordList[i].type===1){
                        this.dailyTask+=this.recordList[i].title;
                        this.dailyTask+="\n";
                        this.recordList.splice(i,1);
                        i--;
                    }
                    if(data === this.recordList[i].temptime){
                        ans+=this.recordList[i].title;
                        ans+="\n";
                    }
                }
                ans+=this.dailyTask;
                
                return ans;
            },

            getAllList(){
                this.recordList=[];
                this.dailyTask="";
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
                        if(item.type===2){
                            for(let i=-4;i<4;i++){
                                if(i===0){continue;}
                                let temp1={
                                    title:item.title,
                                    type:0,
                                };
                                temp1.time = item.begin + 604800*i;
                                temp1.type=0;
                                this.recordList.push(temp1);
                            }
                        }
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
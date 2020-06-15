<template>
    <el-card>
        <div style="display: inline-block;width: 100%">
            <p style="font-size: 18px;float: left">任务列表</p>
            <el-button type="text" style="float: right;margin-right: 5px;margin-top: -10px"
                       @click="toEventPage">更多>>
            </el-button>
        </div>
        <div v-for="item in eventList" :key="item.tid">
            <div style="margin: 10px;" class="eventItem">
                            <span>
                                {{item.title}}
                            </span>
                <div style="font-size: 0.8rem; color: #a6a9ad">
                    <span>{{item.begin}}</span>
                    -
                    <span>{{item.end}}</span>
                </div>
                <el-divider/>
            </div>
        </div>
    </el-card>
</template>

<script>
    import API from "../api";
    import qs from 'qs'
    import Cookies from 'js-cookie'
    export default {
        name: "EventList",

        data(){
            return{
                eventList:[],
            }
        },

        mounted(){
            this.getUserEvent();
        },

        methods:{
            getUserEvent: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token")
                };
                data = qs.stringify(data);
                API.allTask(data).then(res => {
                    if (res.state === 0) {
                        this.eventList = res.list;
                        this.eventList.forEach(item=>{
                            item.begin = new Date(item.begin * 1000).toLocaleString();
                            item.end = new Date(item.end * 1000).toLocaleString();
                        });
                        this.eventList=this.eventList.slice(0,3);
                    } else {
                        alert('错误代码' + res.state)
                    }
                }).catch(res => {
                    alert(res)
                })
            },

            toEventPage(){
                this.$router.push({path: '/home/event'})
            }
        }
    }
</script>

<style scoped>

</style>
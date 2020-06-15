<template>
    <el-card style="height: 240px">
        <div style="display: inline-block;width: 100%">
            <p style="font-size: 18px;float: left">记录列表</p>
            <el-button type="text" style="float: right;margin-right: 5px;margin-top: -10px"
                       @click="toEventPage">更多>>
            </el-button>
        </div>
        <div v-for="item in recordList" :key="item.rid">
            <div style="margin: 10px;" class="eventItem">
                            <span>
                                {{item.title}}
                            </span>
                <div style="font-size: 0.8rem; color: #a6a9ad">
                    <span>{{item.time}}</span>
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
        name: "recordList",
        data(){
            return{
                recordList:[],
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
                API.allRecord(data).then(res => {
                    if (res.state === 0) {
                        this.recordList = res.list;
                        this.recordList.forEach(item=>{
                            item.time = new Date(item.time * 1000).toLocaleString();
                        });
                        this.recordList=this.recordList.slice(0,2);
                    } else {
                        alert('错误代码' + res.state)
                    }
                }).catch(res => {
                    alert(res)
                })
            },

            toEventPage(){
                this.$router.push({path: '/home/record'})
            }
        }
    }
</script>

<style scoped>

</style>
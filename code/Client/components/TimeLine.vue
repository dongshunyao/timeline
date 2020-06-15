<template>
    <div class="timeLine">
        <div class="block">
            <el-timeline>
                <el-timeline-item v-for="item in AllList" :color="'#abcdef'" :key="item.tid" :timestamp="item.time" placement="top">
                    <el-card style="width: 500px">
                        <h4>{{item.title}}</h4>
                        <el-button v-if="!ismain" type="text" style="float: right;margin-right: 10px" @click="putTid(item)">查看详情</el-button>
                        <p>{{item.detail}}</p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </div>
    </div>
</template>

<script>
    import Cookies from 'js-cookie';
    export default {
        name: "TimeLine",
        props:{
            AllList: {
                type: Array,
            },
            ismain: {
                type: Boolean,
            }

        },
        data() {
            return {
                token:Cookies.get("token"),
                uid:Cookies.get("uid"),
                clickedId:'1',
            }
        },
        mounted() {

        },
        methods: {
            putTid(item){
                if(item.tid!==undefined){
                    this.clickedId=item.tid;
                }else{
                    this.clickedId=item.rid;
                }
                console.log(this.clickedId);
                this.$emit('getTid',this.clickedId);
            },
        }
    }
</script>

<style scoped>
    .timeLine {
        width: 800px;
        margin: 20px auto;
        overflow: auto;
        height: 450px;
    }
</style>
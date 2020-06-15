<template>
    <div>
        <el-card>
            <el-button v-if="this.ismain" type="text" style="float: right;margin-right: 5px;margin-top: -10px"
                       @click="toViewPage">更多>>
            </el-button>
            <br/>
            <el-tabs v-model="activeName" style="margin-top: -10px">
                <el-tab-pane label="任务列表" name="first">
                    <time-line :ismain="ismain" :all-list="taskList" @getTid="sendTid"></time-line>
                </el-tab-pane>
                <el-tab-pane label="记录列表" name="second">
                    <time-line :ismain="ismain" :all-list="recordList"></time-line>
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
    import qs from "qs";

    export default {
        name: "list",
        components: {TimeLine},
        props: {
            ismain: {
                type: Boolean,
            }
        },
        data() {
            return {
                token: Cookies.get("token"),
                uid: Cookies.get("uid"),
                activeName: 'first',
                taskList: [{
                    begin: "2018/4/12",
                    title: "任务1",
                    detail: "This is task 1",
                }, {
                    begin: "2018/4/16",
                    title: "任务2",
                    detail: "This is task 2",
                }, {
                    begin: "2018/6/12",
                    title: "任务3",
                    detail: "This is task 3",
                }, {
                    begin: "2018/8/10",
                    title: "任务4",
                    detail: "This is task 4",
                }],

                recordList: [{
                    tid: '1',
                    time: "2020/11/10",
                    title: "记录1",
                    detail: "This is task 1",
                }, {
                    tid: '2',
                    time: "2020/1/20",
                    title: "记录2",
                    detail: "This is task 2",
                }, {
                    tid: '3',
                    time: "2019/11/18",
                    title: "记录3",
                    detail: "This is task 3",
                }, {
                    tid: '4',
                    time: "2018/11/18",
                    title: "记录4",
                    detail: "This is task 4",
                }]
            }
        },

        mounted() {
            this.getList();
        },

        methods: {
            getList() {
                let data = {
                    token: this.token,
                    uid: this.uid
                };
                data = qs.stringify(data);
                API.allTask(data).then(res => {
                    if (res.code) {
                        alert(res.message)
                    }
                    this.taskList = res.list;
                    this.taskList.forEach(item => {
                        item.time = new Date(item.begin * 1000).toLocaleString();
                    })
                }).catch(msg => {
                    alert(msg);
                });

                API.allRecord(data).then(res => {
                    if (res.code) {
                        alert(res.message)
                    }
                    this.recordList = res.list;
                    this.recordList.forEach(item => {
                        item.time = new Date(item.time * 1000).toLocaleString();
                    })
                }).catch(msg => {
                    alert(msg);
                });
            },

            toViewPage() {
                this.$router.push({path: `/view`});
            },

            sendTid(data) {
                this.$emit('finalTid', data);
            }
        }
    }
</script>

<style scoped>

</style>
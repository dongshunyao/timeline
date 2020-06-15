<template>
    <div>
        <el-card>
            <el-button v-if="this.ismain" type="text" style="float: right;margin-right: 5px;margin-top: -10px"
                       @click="toViewPage">更多>>
            </el-button>
            <br/>
            <el-tabs v-model="activeName" style="margin-top: -10px">
                <el-tab-pane label="任务列表" name="first">
                    <el-button @click="showAddEvent" v-if="!this.ismain" type="primary" size="small">
                        添加任务
                    </el-button>
                    <time-line :ismain="ismain" :all-list="taskList" @getTid="sendTid"></time-line>
                    <el-dialog
                            title="添加任务"
                            center
                            :visible.sync="isAddEvent"
                            :before-close="handleClose"
                    >
                        <div style="text-align: center">
                            <el-form label-width="100px">
                                <el-form-item label="标题">
                                    <el-input v-model="newTaskItem.title"/>
                                </el-form-item>

                                <el-form-item label="时间选择">
                                    <el-time-picker is-range range-separator="至" start-placeholder="开始时间"
                                                    end-placeholder="结束时间" placeholder="选择时间范围"
                                                    v-model="timeRange"/>
                                </el-form-item>

                                <el-form-item label="描述">
                                    <el-input v-model="newTaskItem.detail" type="textarea"
                                              :autosize="{ minRows: 5}"/>
                                </el-form-item>

                                <el-form-item label="重复">
                                    <el-radio v-model="newTaskItem.type" label="0">不重复</el-radio>
                                    <el-radio v-model="newTaskItem.type" label="1">每天</el-radio>
                                    <el-radio v-model="newTaskItem.type" label="2">每周</el-radio>
                                    <el-radio v-model="newTaskItem.type" label="3">每月</el-radio>
                                </el-form-item>
                            </el-form>
                        </div>
                        <div slot="footer">
                            <el-button @click="addEvent" type="primary" size="medium">确认添加</el-button>
                            <el-button @click="closeAddEvent" size="medium">取消</el-button>
                        </div>
                    </el-dialog>
                </el-tab-pane>
                <el-tab-pane label="记录列表" name="second">
                    <el-button @click="showAddRecord" v-if="!this.ismain" type="primary" size="small">
                        添加记录
                    </el-button>
                    <time-line :ismain="ismain" :all-list="recordList"></time-line>

                    <el-dialog
                            title="添加记录"
                            center
                            :visible.sync="isAddRecord"
                            :before-close="handleClose"
                    >
                        <div style="text-align: center">
                            <el-form label-width="100px">
                                <el-form-item label="标题">
                                    <el-input v-model="newRecordItem.title"/>
                                </el-form-item>

                                <el-form-item label="时间选择">
                                    <el-time-picker placeholder="选择时间"
                                                    v-model="newRecordItem.time"/>
                                </el-form-item>

                                <el-form-item label="描述">
                                    <el-input v-model="newRecordItem.detail" type="textarea"
                                              :autosize="{ minRows: 5}"/>
                                </el-form-item>
                            </el-form>
                        </div>
                        <div slot="footer">
                            <el-button @click="addRecord" type="primary" size="medium">确认添加</el-button>
                            <el-button @click="closeAddRecord" size="medium">取消</el-button>
                        </div>
                    </el-dialog>
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
                }],
                newTaskItem: {tid: 0, type: 0, group: 0, state: 0, begin: 0, end: 0, title: '', detail: ''},
                isAddEvent: false,
                timeRange: '',
                isAddRecord: false,
                newRecordItem: {rid: 1, title: '', time: '', detail: '', picture: []},
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
            },
            addEvent: function () {
                let data = {
                    uid: Cookies.get('uid'),
                    token: Cookies.get('token'),
                    begin: new Date(this.timeRange[0]).valueOf(),
                    end: new Date(this.timeRange[1]).valueOf(),
                    title: this.newTaskItem.title,
                    detail: this.newTaskItem.detail,
                    type: this.newTaskItem.type,
                    groupid: this.newTaskItem.group
                }
                data = qs.stringify(data)
                API.addTask(data)
                    .then(res => {
                        if (res.state === 0) alert('更新成功')
                        else alert('更新失败')

                        this.getList()
                    })
                    .catch(res => {
                        alert(res.state)
                    })

                this.isAddEvent = !this.isAddEvent
            },
            closeAddEvent: function () {
                this.isAddEvent = false
            },
            handleClose(done) {
                this.$confirm('确认取消？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            },
            showAddEvent: function () {
                this.isAddEvent = !this.isAddEvent
            },
            showAddRecord: function () {
                this.isAddRecord = !this.isAddRecord
            },
            addRecord: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    title: this.newRecordItem.title,
                    time: new Date(this.newRecordItem.time).valueOf(),
                    detail: this.newRecordItem.detail,
                    picture: this.newRecordItem.picture
                }
                data = qs.stringify(data)
                API.addRecord(data)
                    .then(res => {
                        if (res.state === 0) alert('添加成功')
                        else alert('添加失败')

                        this.getUserRecord()
                    })
                    .catch(res => {
                        alert(res)
                    })
                this.isAddRecord = !this.isAddRecord
            },
            closeAddRecord: function () {
                this.isAddRecord = false
            },
        }
    }
</script>

<style scoped>

</style>
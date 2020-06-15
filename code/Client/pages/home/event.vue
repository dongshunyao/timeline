<template>
    <div>
        <my-title :active-index="activeIndex" style="width: 100%;"/>
        <div class="bodyDiv">
            <div style="width: 40%;float: left;margin: 10px 5%;">
                <el-card>
                    <div>
                        <span style="margin-right: 10px;">任务</span>
                        <el-button @click="showAddEvent" size="small" type="primary">添加任务</el-button>
                        <el-input size="small" placeholder="搜索" style="width: 40%;float: right"/>
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
                    </div>
                    <div v-for="item in eventList" :key="item.tid">
                        <div style="margin: 10px;" @click="updateEventContent(item.tid)" class="eventItem">
                            <span>
                                {{item.title}}
                            </span>
                            <div style="font-size: 0.8rem; color: #a6a9ad">
                                <span>{{formatTime(new Date(item.begin*1000))}}</span>
                                -
                                <span>{{formatTime(new Date(item.end*1000))}}</span>
                            </div>
                            <el-button type="danger" size="mini" @click="deleteTask(item.tid)"
                                       style="float: right; height: 20px; padding: 3px; z-index: 10">
                                删除任务
                            </el-button>
                            <el-divider/>
                        </div>
                    </div>
                </el-card>
            </div>
            <div style="width: 40%;float: left;margin: 10px 5%;">
                <el-card>
                    <div>
                        <span>任务</span>
                        <i @click="editContent" class="el-icon-edit" style="float: right;"></i>
                    </div>
                    <div style="margin: 5%;">
                        <div>
                            <p style="font-size: 1.2rem">
                                {{taskItem.title}}
                            </p>
                            <div style="font-size: 0.8rem; color: #a6a9ad">
                                <span>{{formatTime(new Date(taskItem.begin*1000))}}</span>
                                -
                                <span>{{formatTime(new Date(taskItem.end*1000))}}</span>
                            </div>
                            <el-divider/>
                        </div>
                        <div>
                            {{taskItem.detail}}
                        </div>
                    </div>
                    <el-dialog
                            title="内容编辑"
                            center
                            :visible.sync="isEditContent"
                            :before-close="handleClose">
                        <div>
                            <el-input type="textarea" v-model="taskItem.detail" :autosize="{ minRows: 5}"/>
                        </div>
                        <div slot="footer">
                            <el-button @click="updateContent(taskItem.tid)" type="primary" size="medium">确认保存
                            </el-button>
                            <el-button @click="closeEditContent" size="medium">取消</el-button>
                        </div>
                    </el-dialog>
                </el-card>
            </div>
        </div>
        <my-footer/>
    </div>
</template>

<script>
    import API from "../../api";
    import qs from 'qs'
    import Cookies from 'js-cookie'
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";

    export default {
        name: "event",
        components: {MyFooter, MyTitle},
        data() {
            return {
                eventList: [
                    {tid: 1, type: 0, begin: 123, end: 123, title: 'title1', detail: 'detail1'},
                    {tid: 2, type: 0, begin: 123, end: 123, title: 'title2', detail: 'detail2'},
                    {tid: 3, type: 0, begin: 123, end: 123, title: 'title3', detail: 'detail3'},
                    {tid: 4, type: 0, begin: 123, end: 123, title: 'title4', detail: 'detail4'},
                ],
                isAddEvent: false,
                timeRange: '',
                repeat: '0',
                activeIndex: '1',
                // 右侧对象内容
                taskItem: {tid: 0, type: 0, group: 0, state: 0, begin: 0, end: 0, title: '', detail: ''},
                newTaskItem: {tid: 0, type: 0, group: 0, state: 0, begin: 0, end: 0, title: '', detail: ''},
                editEventContent: '',
                isEditContent: false
            }
        },
        mounted() {
            this.getUserEvent()
        },
        methods: {
            getUserEvent: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token")
                };
                data = qs.stringify(data);
                API.allTask(data)
                    .then(res => {
                        if (res.state === 0) {
                            this.eventList = res.list;
                            if (this.eventList.length > 0) {
                                this.taskItem.tid = this.eventList[0].tid;
                                this.taskItem.type = this.eventList[0].type;
                                this.taskItem.group = this.eventList[0].group;
                                this.taskItem.state = this.eventList[0].state;
                                this.taskItem.begin = this.eventList[0].begin;
                                this.taskItem.end = this.eventList[0].end;
                                this.taskItem.title = this.eventList[0].title;
                                this.taskItem.detail = this.eventList[0].detail;
                            } else {
                                this.taskItem.begin = null
                                this.taskItem.end = null
                            }
                        } else {
                            alert('错误代码' + res.state)
                        }
                    })
                    .catch(res => {
                        alert(res)
                    })
            },
            showAddEvent: function () {
                this.isAddEvent = !this.isAddEvent
            },
            addEvent: function () {
                let data = {
                    uid: Cookies.get('uid'),
                    token: Cookies.get('token'),
                    begin: new Date(this.timeRange[0]).valueOf() / 1000,
                    end: new Date(this.timeRange[1]).valueOf() / 1000,
                    title: this.newTaskItem.title,
                    detail: this.newTaskItem.detail,
                    type: this.newTaskItem.type,
                    groupid: this.newTaskItem.group
                };

                data = qs.stringify(data)
                API.addTask(data)
                    .then(res => {
                        if (res.state === 0) alert('更新成功')
                        else alert('更新失败')

                        this.getUserEvent()
                    })
                    .catch(res => {
                        alert(res.state)
                    })

                this.isAddEvent = !this.isAddEvent
            },
            updateEventContent: function (taskID) {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    tid: taskID
                }
                data = qs.stringify(data)
                API.taskDetail(data)
                    .then(res => {
                        if (res.state === 0) {
                            this.taskItem.tid = res.tid
                            this.taskItem.type = res.type
                            this.taskItem.group = res.group
                            this.taskItem.state = res.state
                            this.taskItem.begin = res.begin
                            this.taskItem.end = res.end
                            this.taskItem.title = res.title
                            this.taskItem.detail = res.detail
                        } else {
                            alert('错误代码' + res.state)
                        }
                    })
                    .catch(res => {
                        alert(res)
                    })
            },
            editContent: function () {
                this.isEditContent = !this.isEditContent
            },
            updateContent: function (taskID) {
                let data = {
                    uid: Cookies.get('uid'),
                    token: Cookies.get('token'),
                    tid: taskID,
                    detail: this.taskItem.detail
                }
                data = qs.stringify(data)
                API.updateTask(data)
                    .then(res => {
                        if (res.state === 0) alert('成功')
                        else alert('失败')

                        this.getUserEvent()
                    })
                    .catch(res => {
                        alert(res)
                    })

                this.isEditContent = false
            },
            closeEditContent: function () {
                this.isEditContent = false
            },
            closeAddEvent: function () {
                this.isAddEvent = false
            },
            deleteTask: function (taskID) {
                let data = {
                    uid: Cookies.get('uid'),
                    token: Cookies.get('token'),
                    tid: taskID
                }
                data = qs.stringify(data)
                API.deleteTask(data)
                    .then(res => {
                        if (res.state === 0) alert('成功')
                        else alert('失败')

                        this.getUserEvent()
                    })
                    .catch(res => {
                        alert(res)
                    })
            },
            handleClose(done) {
                this.$confirm('确认取消？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            },
            formatTime: function (time) {
                if (time === null) return null

                let date = new Date(time);

                let year = date.getFullYear(),
                    month = date.getMonth() + 1,//月份是从0开始的
                    day = date.getDate(),
                    hour = date.getHours(),
                    min = date.getMinutes(),
                    sec = date.getSeconds();
                return year + '-' +
                    month + '-' +
                    day + ' ' +
                    hour + ':' +
                    min + ':' +
                    sec;
            }
        }
    }
</script>

<style scoped>
    .bodyDiv {
        display: inline-block;
        background-color: #efefef;
        width: 100%;
    }

    .eventItem {
        text-align: center;
    }

    .eventItem:hover {
        background-color: #efefef;
        transition: ease-in-out;
        transition-duration: 0.4s;
    }
</style>
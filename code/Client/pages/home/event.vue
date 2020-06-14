<template>
    <div>
        <my-title style="width: 100%;"/>
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
                                        <el-input/>
                                    </el-form-item>

                                    <el-form-item label="时间选择">
                                        <el-time-picker is-range range-separator="至" start-placeholder="开始时间"
                                                        end-placeholder="结束时间" placeholder="选择时间范围"
                                                        v-model="timeRange"/>
                                    </el-form-item>

                                    <el-form-item label="描述">
                                        <el-input type="textarea" :autosize="{ minRows: 5}"/>
                                    </el-form-item>

                                    <el-form-item label="重复">
                                        <el-radio v-model="repeat" label="no">不重复</el-radio>
                                        <el-radio v-model="repeat" label="daily">每天</el-radio>
                                        <el-radio v-model="repeat" label="weekly">每周</el-radio>
                                        <el-radio v-model="repeat" label="monthly">每月</el-radio>
                                    </el-form-item>
                                </el-form>
                            </div>
                            <div slot="footer">
                                <el-button @click="addEvent" type="primary" size="medium">确认添加</el-button>
                                <el-button @click="closeAddEvent" size="medium">取消</el-button>
                            </div>
                        </el-dialog>
                    </div>
                    <div v-for="item in eventList" :key="item.id">
                        <div style="margin: 10px;" @click="updateEventContent(item.id)" class="eventItem">
                            <span>
                                {{item.eventTitle}}
                            </span>
                            <p style="font-size: 0.8rem; color: #B4BCCC;margin-top: 5px;">
                                {{item.eventTime}}
                            </p>
                            <el-button type="danger" size="mini" @click="deleteTask(item.id)"
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
                    <div style="margin: 5%; text-align: center">
                        {{content}}
                    </div>
                    <el-dialog
                            title="内容编辑"
                            center
                            :visible.sync="isEditContent"
                            :before-close="handleClose">
                        <div>
                            <el-input type="textarea" v-model="content" :autosize="{ minRows: 5}"/>
                        </div>
                        <div slot="footer">
                            <el-button @click="updateContent" type="primary" size="medium">确认保存</el-button>
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
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";

    export default {
        name: "event",
        components: {MyFooter, MyTitle},
        data() {
            return {
                eventList: [
                    {id: 1, eventTitle: 'title', eventTime: '13点26分'},
                    {id: 2, eventTitle: 'title-2', eventTime: '13点16分'},
                    {id: 3, eventTitle: 'title-3', eventTime: '13点16分'},
                    {id: 4, eventTitle: 'title-4', eventTime: '13点16分'},
                    {id: 5, eventTitle: 'title-5', eventTime: '13点16分'},
                    {id: 6, eventTitle: 'title-6', eventTime: '13点16分'},
                    {id: 7, eventTitle: 'title-7', eventTime: '13点16分'},
                ],
                isAddEvent: false,
                timeRange: '',
                repeat: 'no',
                content: 'content',
                editEventContent: '',
                isEditContent: false
            }
        },
        mounted() {
            this.getUserEvent()
        },
        methods: {
            getUserEvent: function () {
                // TODO 获取用户任务列表
            },
            showAddEvent: function () {
                // TODO 显示添加任务窗口
                this.isAddEvent = !this.isAddEvent
            },
            addEvent: function () {
                //TODO 添加任务
                this.isAddEvent = !this.isAddEvent
            },
            updateEventContent: function (eventID) {
                //TODO 获取点击任务内容
                this.content = this.eventList[eventID - 1].eventTitle
            },
            editContent: function () {
                this.isEditContent = !this.isEditContent
            },
            updateContent: function () {
                //TODO 提交更改信息
                this.isEditContent = false
            },
            closeEditContent: function () {
                this.isEditContent = false
            },
            closeAddEvent: function () {
                this.isAddEvent = false
            },
            deleteTask: function () {
                //TODO 删除任务
            },
            handleClose(done) {
                this.$confirm('确认取消？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            }
        }
    }
</script>

<style scoped>
    .bodyDiv {
        display: inline-block;
        background-color: #efefef;
        width: 100%;
        /*min-height: 100%;*/
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
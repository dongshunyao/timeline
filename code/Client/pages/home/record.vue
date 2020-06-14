<template>
    <div>
        <my-title style="width: 100%;"/>
        <div class="bodyDiv">
            <div style="width: 40%;float: left;margin: 10px 5%;">
                <el-card>
                    <div>
                        <span style="margin-right: 10px;">记录</span>
                        <el-button @click="showAddRecord" size="small" type="primary">添加记录</el-button>
                        <el-input size="small" placeholder="搜索" style="width: 40%;float: right"/>
                        <el-dialog
                                title="添加记录"
                                center
                                :visible.sync="isAddRecord"
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
                                <el-button @click="addRecord" type="primary" size="medium">确认添加</el-button>
                                <el-button @click="closeAddRecord" size="medium">取消</el-button>
                            </div>
                        </el-dialog>
                    </div>
                    <div v-for="item in recordList" :key="item.id">
                        <div style="margin: 10px;" @click="updateRecordContent(item.id)" class="">
                            <span>
                                {{item.recordTitle}}
                            </span>
                            <p style="font-size: 0.8rem; color: #B4BCCC;margin-top: 5px;">
                                {{item.recordTime}}
                            </p>
                            <el-button type="danger" size="mini" @click="deleteTask(item.id)"
                                       style="float: right; height: 20px; padding: 3px; z-index: 10">
                                删除记录
                            </el-button>
                            <el-divider/>
                        </div>
                    </div>
                </el-card>
            </div>
            <div style="width: 40%;float: left;margin: 10px 5%;">
                <el-card>
                    <div>
                        <span>记录</span>
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
        <my-footer />
    </div>
</template>

<script>
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";
    export default {
        name: "record",
        components: {MyFooter, MyTitle},
        data() {
            return {
                recordList: [
                    {id: 1, recordTitle: 'title', recordTime: '13点26分'},
                    {id: 2, recordTitle: 'title-2', recordTime: '13点16分'},
                    {id: 3, recordTitle: 'title-3', recordTime: '13点16分'},
                    {id: 4, recordTitle: 'title-4', recordTime: '13点16分'},
                    {id: 5, recordTitle: 'title-5', recordTime: '13点16分'},
                    {id: 6, recordTitle: 'title-6', recordTime: '13点16分'},
                    {id: 7, recordTitle: 'title-7', recordTime: '13点16分'},
                ],
                isAddRecord: false,
                timeRange: '',
                repeat: 'no',
                content: 'content',
                editRecordContent: '',
                isEditContent: false
            }
        },
        mounted() {
            this.getUserRecord()
        },
        methods: {
            getUserRecord: function () {
                // TODO 获取用户记录列表
            },
            showAddRecord: function () {
                // TODO 显示添加记录窗口
                this.isAddRecord = !this.isAddRecord
            },
            addRecord: function () {
                //TODO 添加记录
                this.isAddRecord = !this.isAddRecord
            },
            updateRecordContent: function (recordID) {
                //TODO 获取点击记录内容
                this.content = this.recordList[recordID - 1].recordTitle
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
            closeAddRecord: function () {
                this.isAddRecord = false
            },
            deleteTask: function (taskID) {
                //TODO 删除记录
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
</style>
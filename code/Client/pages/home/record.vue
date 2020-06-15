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
                                        <el-input v-model="newRecordItem.title" />
                                    </el-form-item>

                                    <el-form-item label="时间选择">
                                        <el-time-picker is-range range-separator="至" start-placeholder="开始时间"
                                                        end-placeholder="结束时间" placeholder="选择时间范围"
                                                        v-model="timeRange"/>
                                    </el-form-item>

                                    <el-form-item label="描述">
                                        <el-input v-model="newRecordItem.detail" type="textarea" :autosize="{ minRows: 5}"/>
                                    </el-form-item>
                                </el-form>
                            </div>
                            <div slot="footer">
                                <el-button @click="addRecord" type="primary" size="medium">确认添加</el-button>
                                <el-button @click="closeAddRecord" size="medium">取消</el-button>
                            </div>
                        </el-dialog>
                    </div>
                    <div v-for="item in recordList" :key="item.rid">
                        <div style="margin: 10px;" @click="updateRecordContent(item.rid)" class="">
                            <span>
                                {{item.time}}
                            </span>
                            <p style="font-size: 0.8rem; color: #B4BCCC;margin-top: 5px;">
                                {{formatTime(item.time)}}
                            </p>
                            <el-button type="danger" size="mini" @click="deleteTask(item.rid)"
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
                            <el-input type="textarea" v-model="recordItem.detail" :autosize="{ minRows: 5}"/>
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
        name: "record",
        components: {MyFooter, MyTitle},
        data() {
            return {
                recordList: [
                    {rid: 1, title: 'title1', time: '13点26分', detail: '', picture: []},
                    {rid: 2, title: 'title2', time: '13点26分', detail: '', picture: []},
                    {rid: 3, title: 'title3', time: '13点26分', detail: '', picture: []},
                    {rid: 4, title: 'title4', time: '13点26分', detail: '', picture: []}
                ],
                isAddRecord: false,
                timeRange: '',
                repeat: '0',
                editRecordContent: '',
                isEditContent: false,
                recordItem: {rid: 1, title: 'title1', time: '13点26分', detail: '', picture: []},
                newRecordItem: {rid: 1, title: 'title1', time: '13点26分', detail: '', picture: []}
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
                this.recordItem = this.recordList[recordID - 1]
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
</style>
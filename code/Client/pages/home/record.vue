<template>
    <div>
        <my-title :active-index="activeIndex" style="width: 100%;"/>
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
                    </div>
                    <div v-for="item in recordList" :key="item.rid">
                        <div style="margin: 10px;" @click="updateRecordContent(item.rid)" class="recordItem">
                            <span>
                                {{item.title}}
                            </span>
                            <p style="font-size: 0.8rem; color: #B4BCCC;margin-top: 5px;">
                                {{formatTime(item.time*1000)}}
                            </p>
                            <el-button type="danger" size="mini" @click="deleteRecord(item.rid)"
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
                        <div>
                            <p style="font-size: 1.2rem">
                                {{recordItem.title}}
                            </p>
                            <div style="font-size: 0.8rem; color: #a6a9ad">
                                <span>{{formatTime(new Date(recordItem.time*1000))}}</span>
                            </div>
                            <el-divider/>
                        </div>
                        <div>
                            {{recordItem.detail}}
                        </div>
                    </div>
                    <el-dialog
                            title="内容编辑"
                            center
                            :visible.sync="isEditContent"
                            :before-close="handleClose">
                        <div>
                            <el-input type="textarea" v-model="recordItem.detail" :autosize="{ minRows: 5}"/>
                            <div style="margin: 10px;">
                                <input type="file" @change="uploadFile" />
                            </div>
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
    import API from "../../api";
    import {MFAPI} from "../../api";
    import qs from 'qs'
    import Cookies from "js-cookie"
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";

    export default {
        name: "record",
        components: {MyFooter, MyTitle},
        data() {
            return {
                activeIndex:'1',
                recordList: [
                    {rid: 1, title: 'title1', time: '', detail: '', picture: []},
                    {rid: 2, title: 'title2', time: '', detail: '', picture: []},
                    {rid: 3, title: 'title3', time: '', detail: '', picture: []},
                    {rid: 4, title: 'title4', time: '', detail: '', picture: []}
                ],
                isAddRecord: false,
                timeRange: '',
                repeat: '0',
                editRecordContent: '',
                isEditContent: false,
                recordItem: {rid: 1, title: '', time: '', detail: '', picture: []},
                newRecordItem: {rid: 1, title: '', time: '', detail: '', picture: []}
            }
        },
        mounted() {
            this.getUserRecord()
        },
        methods: {
            getUserRecord: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token")
                };
                data = qs.stringify(data);
                API.allRecord(data)
                    .then(res => {
                        this.recordList = res.list
                        if (res.state === 0) {
                            if (this.recordList.length > 0) {
                                this.recordItem.rid = this.recordList[0].rid
                                this.recordItem.title = this.recordList[0].title
                                this.recordItem.detail = this.recordList[0].detail
                                this.recordItem.time = this.recordList[0].time
                            } else {
                                this.recordItem.begin = null
                                this.recordItem.end = null
                            }
                        } else {
                            alert('获取记录失败')
                        }
                    })
                    .catch(res => {
                        alert(res)
                    })
            },
            showAddRecord: function () {
                this.isAddRecord = !this.isAddRecord
            },
            addRecord: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    title: this.newRecordItem.title,
                    time: new Date(this.newRecordItem.time).valueOf() / 1000,
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
            updateRecordContent: function (recordID) {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    rid: recordID
                }
                data = qs.stringify(data)
                API.recordDetail(data)
                    .then(res => {
                        if (res.state === 0) {
                            this.recordItem.rid = res.rid
                            this.recordItem.title = res.title
                            this.recordItem.detail = res.detail
                            this.recordItem.time = res.time
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
            updateContent: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    detail: this.recordItem.detail
                }
                data = qs.stringify(data)
                API.updateRecord(data)
                    .then(res => {
                        if (res.state === 0) alert('更新成功')
                        else alert('更新失败')

                        this.getUserRecord()
                    })
                    .catch(res => {
                        alert(res)
                    })

                this.isEditContent = false
            },
            closeEditContent: function () {
                this.isEditContent = false
            },
            closeAddRecord: function () {
                this.isAddRecord = false
            },
            deleteRecord: function (recordID) {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    rid: recordID
                }
                data = qs.stringify(data)
                API.deleteRecord(data)
                    .then(res => {
                        if (res.state === 0) alert('删除成功')
                        else alert('删除失败')

                        this.getUserRecord()
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
                    month = date.getMonth() + 1,
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
            },
            uploadFile: function (event) {
                if (event.target.files.length > 0) {
                    let data = {
                        uid: Cookies.get('uid'),
                        token: Cookies.get('token'),
                        picture: event.target.files[0]
                    }
                    data = qs.stringify(data);
                    var formData = new FormData();
                    formData.append('uid', Cookies.get('uid'));
                    formData.append('token', Cookies.get('token'));
                    formData.append('pic', event.target.files[0]);
                    console.log(formData);
                    console.log(event.target.files[0]);
                    //API.uploadFile(data)
                    API.uploadFile(formData)
                        .then(res => {
                            if (res.state === 0) {
                                
                            }
                        })
                        .catch(res => {
                            alert(res)
                        })
                }
            }
        }
    }
</script>

<style scoped>
    .bodyDiv {
        display: inline-block;
        background-color: #efefef;
        width: 100%;
        min-height: 620px;
    }

    .recordItem {
        text-align: center;
    }

    .recordItem:hover {
        background-color: #efefef;
        transition: ease-in-out;
        transition-duration: 0.4s;
    }
</style>
<template>
    <el-card style="height: 630px;overflow: auto">
        <div style="margin-top: 5px;margin-left: 5px">
            <span style="font-size: 18px">{{task.title}}</span>
            <i @click="editContent" class="el-icon-edit" style="float: right;"></i>
        </div>

        <div style="color: #8c939d;font-size: 12px;margin-top: 5px;margin-left: 5px">
            <span style="margin-right: 5px">{{task.begin}}</span>
            -
            <span style="margin-left: 5px">{{task.end}}</span>
        </div>
        <el-divider></el-divider>
        <div style="margin-left: 5px">
            {{task.detail}}
        </div>
        <el-dialog
                title="内容编辑"
                center
                :visible.sync="isEditContent"
                :before-close="handleClose">
            <div>
                <el-input type="textarea" v-model="task.detail" :autosize="{ minRows: 5}"/>
            </div>
            <div slot="footer">
                <el-button @click="updateContent(task.tid)" type="primary" size="medium">确认保存</el-button>
                <el-button @click="closeEditContent" size="medium">取消</el-button>
            </div>
        </el-dialog>
    </el-card>
</template>

<script>
    import Cookies from "js-cookie";
    import qs from "qs";
    import API from "../api";

    export default {
        name: "detailCard",
        props:{
            task:{
                type:Object,
            }
        },
        data(){
            return{
                isEditContent:false,
                content:'',
                // taskItem: {tid: 0, type: 0, group: 0, state: 0, begin: 0, end: 0, title: '', detail: ''},
            }
        },

        methods:{
            editContent: function () {
                this.isEditContent = !this.isEditContent
            },
            updateContent: function (taskID) {
                let data = {
                    uid: Cookies.get('uid'),
                    token: Cookies.get('token'),
                    tid: taskID,
                    detail: this.task.detail
                };
                data = qs.stringify(data);
                API.updateTask(data)
                    .then(res => {
                        if (res.state === 0) alert('成功');
                        else alert('失败');

                        this.getUserEvent()
                    })
                    .catch(res => {
                        alert(res)
                    });

                this.isEditContent = false
            },
            handleClose(done) {
                this.$confirm('确认取消？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {
                    });
            },
            closeEditContent: function () {
                this.isEditContent = false
            },
            getUserEvent: function () {
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token")
                };
                data = qs.stringify(data);
                API.allTask(data)
                    .then(res => {
                        if (res.state === 0) {
                            
                        } else {
                            alert('错误代码' + res.state)
                        }
                    })
                    .catch(res => {
                        alert(res)
                    })
            },
        }

    }
</script>

<style scoped>
    >>> .el-divider--horizontal{
        margin-top: 15px;
    }
</style>
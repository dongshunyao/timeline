<template>
    <el-card>
        <div style="margin-top: 5px;margin-left: 5px">
            <span style="font-size: 18px">{{record.title}}</span>
            <i @click="editContent" class="el-icon-edit" style="float: right;"></i>
        </div>

        <div style="color: #8c939d;font-size: 12px;margin-top: 5px;margin-left: 5px">
            <span style="margin-right: 5px">{{record.begin}}</span>
        </div>
        <el-divider></el-divider>
        <div style="margin-left: 5px">
            {{record.detail}}
        </div>
    </el-card>
</template>

<script>
    export default {
        name: "recordCard",
        props:{
            record:{
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

</style>
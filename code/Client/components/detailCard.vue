<template>
    <el-card>
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
                :visible.sync="isEditContent">
            <div>
                <el-input type="textarea" v-model="content" :autosize="{ minRows: 5}"/>
            </div>
            <div slot="footer">
                <el-button type="primary" size="medium">确认保存</el-button>
                <el-button @click="this.isEditContent=false" size="medium">取消</el-button>
            </div>
        </el-dialog>
    </el-card>
</template>

<script>
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
            }
        },

        methods:{
            editContent(){

            },
        }

    }
</script>

<style scoped>
    >>> .el-divider--horizontal{
        margin-top: 15px;
    }
</style>
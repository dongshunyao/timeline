<template>
    <div style="">
        <div style="width: 40%;float: left;margin: 0 5%;">
            <el-card>
                <div>
                    <span style="margin-right: 10px;">事件</span>
                    <el-button size="small" type="primary">添加事件</el-button>
                    <el-input size="small" placeholder="搜索" style="width: 40%;float: right"/>
                </div>
                <div>
<!--                    TODO: 事件列表，表格实现-->
                </div>
            </el-card>
        </div>
        <div style="width: 40%;float: left;margin: 0 5%;">
            <el-card>
                <div>
                    <span>事件</span>
                    <i class="el-icon-edit" style="float: right;"></i>
                </div>
                <div>
                    内容
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        name: "event"
    }
</script>

<style scoped>

</style>
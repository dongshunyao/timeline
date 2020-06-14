<template>
    <div class="timeLine">
        <el-timeline reverse>
            <el-timeline-item timestamp="2018/4/12" placement="top">
                <el-card>
                    <h4>事件：198191</h4>
                    <p>时间：王小虎 提交于 2018/4/12 20:46</p>
                </el-card>
            </el-timeline-item>
            <el-timeline-item timestamp="2018/4/13" placement="top">
                <el-card>
                    <h4>事件：更新 Github 模板</h4>
                    <p>时间：王小虎 提交于 2018/4/12 20:46</p>
                </el-card>
            </el-timeline-item>
        </el-timeline>
    </div>
</template>

<script>
    export default {
        name: "TimeLine",
        data() {
            return {

            }
        },
        mounted() {

        },
        methods: {

        }
    }
</script>

<style scoped>
    .timeLine {
        width: 800px;
        margin: 20px auto;
    }
</style>
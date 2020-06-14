<template>
    <div class="timeLine">
        <div class="block">
            <el-timeline>
                <el-timeline-item v-for="item in AllList" :color="'#abcdef'" :key="item.begin" :timestamp="item.begin" placement="top">
                    <el-card style="width: 500px">
                        <h4>{{item.title}}</h4>
                        <p>{{item.detail}}</p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </div>
    </div>
</template>

<script>
    import Cookies from 'js-cookie';
    export default {
        name: "TimeLine",
        props:{
            AllList: {
                type: Array,
            }
        },
        data() {
            return {
                token:Cookies.get("token"),
                uid:1,
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
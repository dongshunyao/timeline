<template>
    <el-card>
        <div class="tableClass">
            <div style="display: table-row;">
                <div class="tableTitle" style="width: 100px">
                </div>
                <div class="tableTitle">
                    星期一
                </div>
                <div class="tableTitle">
                    星期二
                </div>
                <div class="tableTitle">
                    星期三
                </div>
                <div class="tableTitle">
                    星期四
                </div>
                <div class="tableTitle">
                    星期五
                </div>
                <div class="tableTitle">
                    星期六
                </div>
                <div class="tableTitle">
                    星期日
                </div>
            </div>
            <div
                    :class="{'grayLine': (index % 2 === 0)}"
                    style="display: table-row;"
                    v-for="(item, index) in finalList"
                    :key="item.id">
                <div class="tableCell">
                    {{item.time}}
                </div>
                <div class="tableCell">
                    {{item.day1}}
                </div>
                <div class="tableCell">
                    {{item.day2}}
                </div>
                <div class="tableCell">
                    {{item.day3}}
                </div>
                <div class="tableCell">
                    {{item.day4}}
                </div>
                <div class="tableCell">
                    {{item.day5}}
                </div>
                <div class="tableCell">
                    {{item.day6}}
                </div>
                <div class="tableCell">
                    {{item.day7}}
                </div>
            </div>
        </div>
    </el-card>
</template>

<script>
    export default {
        name: "CalendarWeek",
        data(){
            return{
                baseList:[{
                    begin:"2020/4/12",
                    title:"任务1",
                    detail:"This is task 1",
                },{
                    begin:"2018/4/16",
                    title:"任务2",
                    detail:"This is task 2",
                },{
                    begin:"2018/6/12",
                    title:"任务3",
                    detail:"This is task 3",
                },{
                    begin:"2018/8/10",
                    title:"任务4",
                    detail:"This is task 4",
                }],
                finalList:[{
                    time:"0:00-6:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"6:00-8:00",
                    day1:"任务0 任务5",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"任务1",
                    day7:"",
                },{
                    time:"8:00-10:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"任务1",
                    day7:"",
                },{
                    time:"10:00-12:00",
                    day1:"",
                    day2:"",
                    day3:"任务2",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"12:00-14:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"14:00-16:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"任务3",
                },{
                    time:"16:00-18:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"任务3",
                },{
                    time:"18:00-20:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"任务3",
                },{
                    time:"20:00-22:00",
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"任务1",
                    day7:"",
                },{
                    time:"22:00-24:00",
                    day1:"",
                    day2:"",
                    day3:"任务8",
                    day4:"",
                    day5:"任务5",
                    day6:"",
                    day7:"",
                },],
            }
        },

        methods:{
            setList(){

            }
        },
    }
</script>

<style scoped>
    .tableClass {
        display: table;
        width: 100%;
        padding: 0 10px 20px 20px;
        border-collapse: collapse;
    }

    .tableTitle{
        display: table-cell;
        text-align: center;
        font-size: 15px;
        padding: 5px;
        color: gray;
    }

    .tableCell{
        display: table-cell;
        text-align: center;
        font-size: 15px;
        padding: 20px 10px;
    }

    .titleClass {
        position: fixed;
        color: gray;
    }

    .grayLine{
        background-color: #f5f5f5;
    }
</style>
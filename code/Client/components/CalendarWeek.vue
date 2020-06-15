<template>
    <el-card v-loading="loading">
        <div class="tableClass">
            <div style="display: table-row;">
                <div class="tableTitle" style="width: 100px">
                </div>
                <div class="tableTitle">
                    星期日
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
        props:{
            baseList:{
                type:Array,
            }
        },
        data(){
            return{
                loading:false,
                finalList:[{
                    time:"0:00-6:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"6:00-8:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"8:00-10:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"10:00-12:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"12:00-14:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"14:00-16:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"16:00-18:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"18:00-20:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"20:00-22:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },{
                    time:"22:00-24:00",
                    day:[],
                    day1:"",
                    day2:"",
                    day3:"",
                    day4:"",
                    day5:"",
                    day6:"",
                    day7:"",
                },],
            }
        },

        mounted(){
            this.setList();
        },

        methods:{
            setList(){
                this.loading=true;
                this.finalList.forEach(item=>{
                    item.day1="";
                    item.day2="";
                    item.day3="";
                    item.day4="";
                    item.day5="";
                    item.day6="";
                    item.day7="";
                });
                let wk = new Date().getDay();
                let dd = new Date().getDate();

                console.log(this.baseList);

                this.baseList.forEach(item=>{
                    item.day=new Date(item.time * 1000).getDate();
                    item.hours=new Date(item.time * 1000).getHours();
                    item.xingqi=new Date(item.time * 1000).getDay();

                    console.log(dd - wk);

                    if(item.day>dd-wk+7 || item.day< dd - wk){
                        return true;
                    }

                    if(item.hours>0 && item.hours<6){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[0].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[0].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[0].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[0].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[0].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[0].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[0].day7+=item.title;
                                break;
                        }
                    }else if(item.hours<8){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[1].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[1].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[1].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[1].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[1].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[1].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[1].day7+=item.title;
                                break;
                        }

                    }else if(item.hours<10){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[2].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[2].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[2].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[2].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[2].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[2].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[2].day7+=item.title;
                                break;
                        }

                    }else if(item.hours<12){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[3].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[3].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[3].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[3].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[3].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[3].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[3].day7+=item.title;
                                break;
                        }

                    }else if(item.hours<14){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[4].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[4].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[4].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[4].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[4].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[4].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[4].day7+=item.title;
                                break;
                        }

                    }else if(item.hours<16){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[5].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[5].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[5].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[5].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[5].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[5].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[5].day7+=item.title;
                                break;
                        }
                    }else if(item.hours<18){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[6].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[6].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[6].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[6].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[6].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[6].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[6].day7+=item.title;
                                break;
                        }
                    }else if(item.hours<20){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[7].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[7].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[7].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[7].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[7].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[7].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[7].day7+=item.title;
                                break;
                        }
                    }else if(item.hours<22){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[8].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[8].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[8].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[8].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[8].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[8].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[8].day7+=item.title;
                                break;
                        }

                    }else if(item.hours<24){
                        switch (item.xingqi) {
                            case 0:
                                this.finalList[9].day1+=item.title;
                                break;
                            case 1:
                                this.finalList[9].day2+=item.title;
                                break;
                            case 2:
                                this.finalList[9].day3+=item.title;
                                break;
                            case 3:
                                this.finalList[9].day4+=item.title;
                                break;
                            case 4:
                                this.finalList[9].day5+=item.title;
                                break;
                            case 5:
                                this.finalList[9].day6+=item.title;
                                break;
                            case 6:
                                this.finalList[9].day7+=item.title;
                                break;
                        }
                    }
                });

                this.loading=false;
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
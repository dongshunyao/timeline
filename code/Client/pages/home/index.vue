<template>
    <div class="con">
        <div class="wrap">
            <div class="main">
                <my-title :active-index="activeIndex" style="width: 100%"></my-title>
                <div>
                    <list :ismain="true" style="width: 44%;margin-left: 6%;margin-top: 20px;margin-bottom: 10px;min-height: 595px;float: left"></list>
                    <div style="width: 44%;margin-left: 1%;margin-top: 20px;margin-bottom: 10px;height: 595px;float: left">
                        <event-list></event-list>
                        <record-list style="margin-top: 10px"></record-list>
                    </div>
                </div>
            </div>
            <div class="footer">
                <my-footer/>
            </div>
        </div>
    </div>

</template>

<script>
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";
    import List from "../../components/list";
    import EventList from "../../components/EventList";
    import RecordList from "../../components/recordList";
    export default {
        name: "firstPage",
        components: {RecordList, EventList, List, MyFooter, MyTitle},
        data(){
            return{
                activeIndex:'1',
            }
        }
    }
</script>

<style scoped>
    .con{
        position: absolute;
        height: 100%;
        width: 100%;
        top:0;bottom: 0;left: 0;right: 0px
    }
    .wrap{
        
        min-height: 100%;
        width: 100%;
        position: relative;
        
        display:-moz-box; 
        display:-webkit-box; 
        display:-o-box; 
        display:box;

        -moz-box-orient:vertical; 
        -webkit-box-orient:vertical; 
        -o-box-orient:vertical; 
        box-orient:vertical; 

        -moz-box-align:center; 
        -webkit-box-align:center; 
        -o-box-align:center; 
        box-align:center; 

        -moz-box-pack:center; 
        -webkit-box-pack:center; 
        -o-box-pack:center; 
        box-pack:center;      
    }
    .main{
        width: 100%;
         -moz-box-flex: 1; 
        -webkit-box-flex: 1; 
        box-flex: 1;
        background-color: #efefef;
    }
    .footer{
        width:100%;
        height: 3rem;
    }
</style>
<template>
    <div>
        <my-title :active-index="activeIndex" style="width: 100%"></my-title>
        <div class="bodyDiv">
            <list :ismain="true" style="width: 44%;margin-left: 6%;margin-top: 20px;margin-bottom: 10px;min-height: 595px;float: left"></list>
            <div style="width: 44%;margin-left: 1%;margin-top: 20px;margin-bottom: 10px;height: 595px;float: left">
                <event-list></event-list>
                <record-list style="margin-top: 10px"></record-list>
            </div>
        </div>
        <my-footer style="bottom: 0"/>
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
    .bodyDiv{
        display: inline-block;
        background-color: #efefef;
        min-width: 100%;
    }
</style>
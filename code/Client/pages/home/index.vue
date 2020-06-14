<template>
    <div>
        <my-title :active-index="activeIndex" style="width: 100%"></my-title>
        <div class="bodyDiv">
            <list style="width: 45%;margin-left: 3%;margin-top: 20px;margin-bottom: 10px"></list>
        </div>
        <my-footer style="bottom: 0"/>
    </div>
</template>

<script>
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";
    import List from "../../components/list";
    export default {
        name: "firstPage",
        components: {List, MyFooter, MyTitle},
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
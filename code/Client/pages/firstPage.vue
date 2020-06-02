<template>
    <div>
        <my-title style="width: 100%"></my-title>
        <div class="bodyDiv">

        </div>
        <my-footer style="bottom: 0"></my-footer>
    </div>
</template>

<script>
    import MyTitle from "../components/myTitle";
    import MyFooter from "../components/myFooter";
    export default {
        name: "firstPage",
        components: {MyFooter, MyTitle}
    }
</script>

<style scoped>
    .bodyDiv{
        background-color: #efefef;
        min-height: 630px;
    }
</style>
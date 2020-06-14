<template>
    <div>
        <my-title/>
        <div>
            <time-line></time-line>
        </div>
        <my-footer/>
    </div>
</template>

<script>
    import TimeLine from "../../components/TimeLine";
    import MyTitle from "../../components/myTitle";
    import MyFooter from "../../components/myFooter";
    export default {
        name: "index",
        components: {MyFooter, MyTitle, TimeLine}
    }
</script>

<style scoped>

</style>
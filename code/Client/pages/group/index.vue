<template>
    <div class="con">
        <div class="wrap">
            <div class="main">
                <my-title :active-index="activeIndex"/>
                <!-- 
                <div style="width: 18%;margin-left: 41%;margin-top: 30px">
                    <h3 style="margin-top: 35px;float: left">请付费后解锁该功能</h3>
                    <img src="../../assets/love.jpg" style="float: left;margin-left: 20px">
                </div>
                -->

                <div style="margin: 20px;float: left;width: 100%">
                    <groupList style="margin: 20px;width: 40%;height: 500px"
                        title = "管理的群组" manage = true :listData = "manageList"
                    />
                    <groupList style="margin: 20px;width: 40%;height: 500px"
                        title = "加入的群组" manage = false :listData = "joinList"
                    />
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
    import groupList from "./groupList";
    import Cookies from 'js-cookie'
    import API from "../../api";
    import qs from "qs";


    export default {
        name: "group",
        components: {MyFooter, MyTitle, groupList},
        data() {
            return {
                activeIndex:'2',
                manageList: [],
                joinList: [],
            }
        },
        created: function () {
            this.fetchData();
        },
        methods: {
            fetchData: function(){
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                }
                data = qs.stringify(data)
                API.groupList(data)
                    .then(res => {
                        if (res.state === 0) {
                            this.manageList = res.listmanage;
                            this.joinList = res.listin;
                        }
                        console.log(this.manageList);
                        console.log(this.joinList);

                    })
                    .catch(res => {
                        alert(res)
                    })
                ;
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
        text-align: center;
        
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
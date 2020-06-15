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
                        @showInfo = "gid => {showInfo(gid)}"
                    />
                    <groupList style="margin: 20px;width: 40%;height: 500px"
                        title = "加入的群组" manage = false :listData = "joinList"
                        @showInfo = "gid => {showInfo(gid)}"
                    />
                </div>
                

            </div>
            <div class="footer">
                <my-footer/>
            </div>
        </div>
        
        <div class='popContainer' v-if="divShow" style="padding: 50px">
            <el-card style="width: 50%; margin: 0 auto;">
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="群组ID">
                    <p>{{showingGid}}</p>
                  </el-form-item>
                  <el-form-item label="群组ID">
                    <el-input v-model="form.name">7777</el-input>
                  </el-form-item>
                  <el-form-item label="成员列表">
                    <el-table
                        :data="form.member"
                        style="width: 100%">
                        <el-table-column
                            label="uid"
                            width="180">
                            <template slot-scope="scope">
                                <i class="el-icon-time"></i>
                                <span style="margin-left: 10px">{{scope.row.id}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                            label="昵称">
                            <template slot-scope="scope">
                                <p>{{scope.row.name}}</p>
                            </template>
                        </el-table-column>
                        <el-table-column label="操作" >
                            <template slot-scope="scope">
                                <el-button
                                    size="mini"
                                    type="danger"
                                    @click="doKik(scope.row.id,scope.row.name)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                  </el-form-item>
                  <el-form-item>
                    <!--<el-button type="primary" @click="onSubmit">立即创建</el-button>-->
                    <el-button @click="dropCover()">返回</el-button>
                  </el-form-item>
                </el-form>
            </el-card>
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
                divShow: false,
                showingGid: -1,
                form: {
                  name: '',
                  member: [],
                  task : [],
                  wantjoin : [],
                },
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
            },
            showInfo: function(gid){
                this.divShow = true;
                this.showingGid = gid;
                let data = {
                    uid: Cookies.get("uid"),
                    token: Cookies.get("token"),
                    id: gid
                }
                data = qs.stringify(data)
                API.groupInfo(data)
                    .then(res => {
                        if (res.state === 0) {
                            this.form = res;
                        }
                    })
                    .catch(res => {
                        alert(res)
                    })
                ;
            },
            doKik: function(uid,name){
                this.$confirm('要从组 ' + this.form.name + '(' + this.showingGid + ') 中移除用户 ' + name +'(' + uid +') 吗？').then(_ => {
                    let data = {
                        uid: Cookies.get("uid"),
                        token: Cookies.get("token"),
                        gid: this.showingGid,
                        op: "del",
                        opuid: uid,
                    }
                    data = qs.stringify(data)
                    API.groupManage(data)
                        .then(res => {
                           this.showInfo(this.showingGid);
                        })
                        .catch(res => {})
                    ;
                }).catch( _ => {});
            },
            dropCover: function(){
                this.divShow = ! this.divShow;
            }
        }
    }
</script>

<style scoped>
        

    div.popContainer{
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: rgba(0,0,0,0.3);
        z-index: 1;
    }

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
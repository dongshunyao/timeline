<template>
    <el-card style="display: inline-block;">
        <div style="">
            <p style="font-size: 18px;float: left">{{title}}</p>

            <el-table
                :data="listData"
                style="width: 100%">
                <el-table-column
                    label="组名"
                    width="180">
                    <template slot-scope="scope">
                        <i class="el-icon-time"></i>
                        <span style="margin-left: 10px">{{ scope.row.name }}</span>
                    </template>
                </el-table-column>
                <el-table-column
                    label="组号">
                    <template slot-scope="scope">
                        <p>{{ scope.row.id }}</p>
                    </template>
                </el-table-column>
                <el-table-column label="操作" v-if="manage == 'true'" >
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            @click=";">编辑</el-button>
                        <el-button
                            size="mini"
                            type="danger"
                            @click=";">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>

        </div>
    </el-card>
</template>

<script>
    export default {
        name: "groupList",
        components: {},
        props: ['title','manage','listData'],
        data() {
            return {
                activeIndex:'2',
            }
        },
        created: function () {
            console.log(this.listData);
        },
        methods: {
            
        }
    }
</script>

<style scoped>

</style>
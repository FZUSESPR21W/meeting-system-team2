<template>
  <div>
    <el-button type="primary" :plain="true" @click="noticeAll()"
        style="position:relative;left:20%;margin-bottom:20px;margin-top:30px">
        <i class="el-icon-bell"></i><span>全部提醒</span></el-button>
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) ||
                    data.email.toLowerCase().includes(search.toLowerCase()))"
    class="el-table" style="width:70%">
    <el-table-column
      label="邮箱"
      prop="email">
    </el-table-column>
    <el-table-column
      label="用户名"
      prop="name">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="small"
          type="primary" :plain="true"
          @click="notice(scope.$index, scope.row)"><i class="el-icon-bell"></i><span>提醒</span></el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王小虎',
        }, {
          email: '123456789@qq.com',
          name: '王大虎',
        }],
        search: ''
      }
    },
    methods: {
      notice(index, row) {

        console.log(row.email);
        //提醒！
        this.$message({
          showClose: true,
          message: '提醒成功！',
          type: 'success'
        });
      },
      noticeAll(){
        this.$message({
        //给所有用户发送提醒
            
          showClose: true,
          message: '全部提醒成功！',
          type: 'success'
        });
      }
    },
  }
</script>

<style>
    .el-table{
        right:10%;
        margin-left: 30%;
        overflow-y:scroll;
        overflow-x:hidden;
        top: 0;
        bottom:0;
    }
</style>
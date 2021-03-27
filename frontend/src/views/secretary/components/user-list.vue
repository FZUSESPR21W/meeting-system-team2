<template>
  <div>
    <el-button type="primary" plain style="left:20%;">主要按钮</el-button>
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) ||
                    data.email.toLowerCase().includes(search.toLowerCase()))"
    style="width: 70%;position:fixed;right:10%">
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
          placeholder="输入用户名搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="small"
          type="primary" plain
          @click="handleDelete(scope.$index, scope.row)"><i class="el-icon-bell"></i><span>提醒</span></el-button>
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
          name: '王大虎',
        }],
        search: ''
      }
    },
    methods: {
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
  }
</script>
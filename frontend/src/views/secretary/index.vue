<template>
  <div>
    <navBarTop/>
    <el-container>

      <el-container>
        <el-aside width="15%">Aside</el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
    <userList/>
    <bottomBar/>
  </div>
</template>

<style scoped>

</style>
<script>
import bottomBar from '@/components/footer'
import navBarTop from './components/nav-bar-top.vue'
import userList from './components/user-list.vue'

export default {
  name: "index",
  components:{
    bottomBar,
    navBarTop,
    userList,
  },
}
</script>

<style>
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
.header {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  background:white;
}
</style>

<template>
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose">

      <el-submenu index="1">    
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>导航</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">用户人数</el-menu-item>
          <el-menu-item index="1-2">用户列表</el-menu-item>
          <el-menu-item index="1-2">论坛人数</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
  
    </el-menu>
    
</template>
 
<script>
export default {
    name: "index",
    
    data(){
        return{
            msg: "Welcome to Your Vue.js App"
        }
    },
   
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
    }

}
</script>
    
<style>
     
</style>
<template>
  <div class="side">
    <el-menu default-active="2" class="el-menu-vertical" @open="handleOpen" @close="handleClose">
      <el-menu-item index="1-1">用户人数</el-menu-item>
      <el-menu-item index="1-2">用户列表</el-menu-item>
      <el-menu-item index="1-2">论坛人数</el-menu-item>

  
    </el-menu>
  </div>
    
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
      changeLanguage(lan) {
      this.$i18n.locale = lan
      this.reloadMenuData()
    },
    }

}
</script>
    
<style>
     
</style>
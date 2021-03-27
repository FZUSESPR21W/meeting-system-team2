<template>
  <div class="side">
    <p>XXXXX后台</p>
    <el-menu :default-active="menuActiveIndex" class="el-menu-vertical" :router="true">
      <el-menu-item v-for="(menuItem,index) in menuList" :index="menuItem.path" :key="menuItem.title" v-if="menuItem.permission == permission">
        <i :class="menuItem.icon"/>
        {{ menuItem.title }}
      </el-menu-item>
      <!-- <el-menu-item index="1-1">用户人数</el-menu-item>
      <el-menu-item index="1-2">用户列表</el-menu-item>
      <el-menu-item index="1-2">论坛人数</el-menu-item> -->

      <el-submenu index="" class="lan">
        <template slot="title">{{ $t('index.language') }}</template>
        <el-menu-item index="" @click="changeLanguage('zh')">中文</el-menu-item>
        <el-menu-item index="" @click="changeLanguage('en')">English</el-menu-item>
      </el-submenu>

      <!-- </el-submenu> -->
  
    </el-menu>
  </div>
    
</template>
 
<script>
export default {
    name: "index",
    
    data(){
      return {
        menuActiveIndex: '',
        menuList: []
      }
    },
    created() {
      this.reloadMenuData()
      this.menuActiveIndex  = this.$route.path
    },
    computed: {
      //权限
      permission() {
        return 2
      }
    },
   
    methods: {
      changeLanguage(lan) {
      this.$i18n.locale = lan
      this.reloadMenuData()
      },
      reloadMenuData() {
      this.menuList = [
        {
          //标题
          title: this.$t('index.personalCenter'),
          //图表
          icon: 'el-icon-user-solid',
          //url路径
          path: '/chairman',
          //权限 2为主席， 3为分论坛主席， 4为秘书
          permission: '2'
        },
        {
          title: this.$t('index.messageCenter'),
          icon: 'el-icon-message-solid',
          path: '/detail',
          permission: '2'
        },
        {
          title: this.$t('index.logout'),
          icon: 'el-icon-switch-button',
          path: '/secretary',
          permission: '2'
        },
        
      ]
    }
    }

}
</script>
    
<style>
     
</style>
<template>
  <div class="side">
    <el-menu :default-active="menuActiveIndex" class="el-menu-vertical" :router="true">
      <el-menu-item v-for="(menuItem,index) in menuList" :index="menuItem.path" :key="menuItem.title" v-if="menuItem.permission == permission">
        <i :class="menuItem.icon"/>
        {{ menuItem.title }}
      </el-menu-item>

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
          title: this.$t('sidebar.overview'),
          //图表
          icon: 'el-icon-user-solid',
          //url路径
          path: '/chairman',
          //权限 2为分论坛主席， 3为秘书， 4为大主席
          permission: '2'
        },
        {
          title: this.$t('sidebar.subscribers'),
          icon: 'el-icon-s-data',
          path: '/detail',
          permission: '2'
        },
        {
          title: this.$t('sidebar.userList'),
          icon: 'el-icon-s-unfold',
          path: '/admin/secretary',
          permission: '2'
        },
        {
          title: this.$t('sidebar.deliver'),
          icon: 'el-icon-finished',
          path: '/admin/secretary',
          permission: '2'
        },
        
      ]
    }
    }

}
</script>
    
<style>
.side{
  width: 18%;
  position:absolute;
}
     
</style>
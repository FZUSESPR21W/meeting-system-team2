<template>
  <div class="top full_width">
    <p class="meeting_name">XXXXXX会议</p>
    <el-menu :default-active="menuActiveIndex" class="el-menu" mode="horizontal" :router="true">
      <el-menu-item v-for="(menuItem,index) in menuList" :index="menuItem.path" :key="menuItem.title" v-if="menuItem.permission.indexOf(permission) >= 0">
        <i :class="menuItem.icon"/>
        {{ menuItem.title }}
      </el-menu-item>
      <el-submenu index="">
        <template slot="title">{{ $t('index.language') }}</template>
        <el-menu-item index="" @click="changeLanguage('zh')">中文</el-menu-item>
        <el-menu-item index="" @click="changeLanguage('en')">English</el-menu-item>
        <el-menu-item index="" @click="changeLanguage('ja')">日本語</el-menu-item>
        <el-menu-item index="" @click="changeLanguage('fr')">Français</el-menu-item>
        <el-menu-item index="" @click="changeLanguage('de')">Deutsch</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>

</template>

<script>
export default {
  name: "index",
  data() {
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
      let permission = '0'
      try{
        permission = this.$store.state.userData.authority.toString()
      }
      catch(e){
        return permission
      }
      return permission
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
          title: this.$t('index.home'),
          //图标
          icon: 'el-icon-s-home',
          //url路径
          path: '/',
          //权限 0为所有用户, 1为已登录的普通用户
          permission: ['0','1']
        },
        {
          title: this.$t('index.personalCenter'),
          icon: 'el-icon-user-solid',
          path: '/user/center',
          permission: ['0','1']
        },
        {
          title: this.$t('index.messageCenter'),
          icon: 'el-icon-message-solid',
          path: '/user/message',
          permission: ['0','1']
        },
        {
          title: this.$t('index.logout'),
          icon: 'el-icon-switch-button',
          path: '/user/logout',
          permission: ['1']
        },
        {
          title: this.$t('index.login'),
          icon: 'el-icon-key',
          path: '/login',
          permission: ['0']
        }
      ]
    }
  }
}
</script>

<style scoped>
.top {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #E6E6E6;
}

.meeting_name {
  font-size: 34px;
  margin: 0;
  margin-left: 30px;
  color: #409EFF
}

.el-menu {
  border-bottom: 0;
}
</style>
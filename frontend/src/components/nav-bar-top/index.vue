<template>
  <div class="home_top full_width">
    <p class="meeting_name">XXXXXX会议</p>
    <el-menu :default-active="menuActiveIndex" class="el-menu-demo" mode="horizontal" :router="true">
      <el-menu-item v-for="(menuItem,index) in menuList" :index="menuItem.path" :key="menuItem.title" >
        <i :class="menuItem.icon"/>
        {{ menuItem.title }}
      </el-menu-item>
      <el-submenu index="">
        <template slot="title">{{ $t('index.language') }}</template>
        <el-menu-item index="" @click="changeLanguage('zh')">中文</el-menu-item>
        <el-menu-item index="" @click="changeLanguage('en')">English</el-menu-item>
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
          path: '/'
        },
        {
          title: this.$t('index.personalCenter'),
          icon: 'el-icon-user-solid',
          path: '/user/center'
        },
        {
          title: this.$t('index.messageCenter'),
          icon: 'el-icon-message-solid',
          path: '/user/message'
        },
        {
          title: this.$t('index.logout'),
          icon: 'el-icon-switch-button',
          path: '/user/logout'
        }
      ]
    },
    changeViews(path) {
      this.$router.push(path)
    }
  }
}
</script>

<style scoped>
.home_top {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.meeting_name {
  font-size: 34px;
  margin: 0;
  margin-left: 30px;
  color: #409EFF
}
</style>
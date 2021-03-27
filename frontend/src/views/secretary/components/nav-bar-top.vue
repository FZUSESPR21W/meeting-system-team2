<template>
  <div class="top full_width">
    <p class="meeting_name"></p>
    <el-menu :default-active="menuActiveIndex" class="el-menu" mode="horizontal" :router="true">
      <el-menu-item v-for="(menuItem,index) in menuList" :index="menuItem.path" :key="menuItem.title">
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
  computed: {
    //权限
    permission() {
      return 0
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
          title: this.$t('index.logout'),
          icon: 'el-icon-switch-button',
          path: '/user/logout',
          permission: '1'
        },
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
  z-index: 1;
}

.meeting_name {
  font-size: 34px;
  margin: 0;
}

.el-menu {
  border-bottom: 0;
}
</style>
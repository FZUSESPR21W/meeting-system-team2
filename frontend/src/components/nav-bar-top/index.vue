<template>
  <el-menu :default-active="menuActiveIndex" class="el-menu-demo" mode="horizontal">
    <el-menu-item v-for="(menuItem,index) in menuList" :index="(index + 1).toString()" :key="menuItem.title">
      <i :class="menuItem.icon"/>
      {{ menuItem.title }}
    </el-menu-item>
    <el-submenu index="5">
      <template slot="title">{{ $t('index.language') }}</template>
      <el-menu-item index="2-1" @click="changeLanguage('zh')">中文</el-menu-item>
      <el-menu-item index="2-2" @click="changeLanguage('en')">English</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      menuActiveIndex: '1',
      menuList: []
    }
  },
  created() {
    this.reloadMenuData()
  },
  methods: {
    changeLanguage(lan) {
      this.$i18n.locale = lan
      this.reloadMenuData()
    },
    reloadMenuData() {
      this.menuList = [
        {
          title: this.$t('index.home'),
          icon: 'el-icon-s-home'
        },
        {
          title: this.$t('index.personalCenter'),
          icon: 'el-icon-user-solid'
        },
        {
          title: this.$t('index.messageCenter'),
          icon: 'el-icon-message-solid'
        },
        {
          title: this.$t('index.logout'),
          icon: 'el-icon-switch-button'
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>
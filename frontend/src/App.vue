<template>
  <div id="app">
    <navBarTop @changeLanguage="$refs.bottom.$emit('changeLanguage')"/>
    <router-view />
    <bottomBar ref="bottom"/>
  </div>
</template>

<script>
import bottomBar from '@/components/footer'
import navBarTop from '@/components/nav-bar-top'
export default {
  name: 'app',
  components: {
    bottomBar,
    navBarTop
  },
  created() {
    this.$store.commit('getLocalUserData')
  }
}
</script>

<style>
html {
  height: 100%;
}

body {
  margin: 0;
  height: 100%;
}

#app {
  height: 100%;
}


.full_width {
  width: 100%;
}

.full_height {
  height: 100%;
}

::-webkit-scrollbar { width: 0 !important }
</style>

<template>
  <div id="app">
    <navBarTop />
    <router-view />
    <bottomBar />
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

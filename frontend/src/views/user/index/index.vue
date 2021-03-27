<template>
  <div>
    <navBarTop />
    <router-view />
  </div>
</template>

<script>
import navBarTop from '@/components/nav-bar-top'
export default {
  name: "index",
  components: {
    navBarTop
  }
}
</script>

<style scoped>

</style>
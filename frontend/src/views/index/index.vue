<template>
  <div>
    <navBarTop />
    <meetingList />
  </div>
</template>

<script>
import navBarTop from '@/components/nav-bar-top'
import meetingList from './components/meeting-list'

export default {
  name: "index",
  components: {
    navBarTop,
    meetingList
  }
}
</script>

<style scoped>

</style>
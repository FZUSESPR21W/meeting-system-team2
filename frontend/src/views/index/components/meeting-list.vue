<template>
  <div class="meeting_list">
    <meetingItem v-for="item in meetingList" :key="item.name" :data="item"/>
  </div>
</template>

<script>
import meetingItem from './meeting-item'

export default {
  name: "meeting-list",
  components: {
    meetingItem
  },
  created() {
    this.$api.Meeting.getMeetingListWithOutParams().then(res => {
      this.meetingList = res.data.data.meetingList
    })
  },
  data() {
    return {
      meetingList: []
    }
  }
}
</script>

<style scoped>
.meeting_list {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}
</style>
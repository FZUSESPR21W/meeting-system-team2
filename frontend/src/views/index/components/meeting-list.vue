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
  data() {
    return {
      meetingList: [
        {
          name: '机器学习',
          president: 'doctor.机器',
          conveneTime: '2021-3-27',
          describe: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        },
        {
          name: '计算机视觉',
          president: 'doctor.视觉',
          conveneTime: '2021-3-27',
          describe: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        },
        {
          name: '人工智能',
          president: 'doctor.人工智能',
          conveneTime: '2021-3-27',
          describe: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        },
        {
          name: '人机交互',
          president: 'doctor.交互',
          conveneTime: '2021-3-27',
          describe: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        },
        {
          name: '计算机图形学',
          president: 'doctor.图形学',
          conveneTime: '2021-3-27',
          describe: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        },
        {
          name: '面向对象',
          president: 'doctor.对象',
          conveneTime: '2021-3-27',
          describe: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
        }
      ]
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
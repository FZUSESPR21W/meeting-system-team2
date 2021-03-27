<template>
  <div class="home_page_contianer">
    <el-carousel indicator-position="outside" height="550px" class="full_width" >
      <el-carousel-item v-for="item in 4" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
    <div class="meeting_schedule">
      <p class="meeting_list_title">{{ $t('index.meetingSchedule') }}</p>
      <el-steps :active="2" class="meeting_schedule_line" align-center>
        <el-step :title=" $t('index.day') + '1' " description="开幕礼&主席发言"></el-step>
        <el-step :title=" $t('index.day') + '2' " description="各分论坛同步开启"></el-step>
        <el-step :title=" $t('index.day') + '3' " description="邀请各学术大佬发言"></el-step>
        <el-step :title=" $t('index.day') + '4' " description="闭幕"></el-step>
      </el-steps>
    </div>
    <div class="meeting_list_container">
      <p class="meeting_list_title">{{ $t('index.subForum') }}</p>
      <meetingList />
    </div>
  </div>
</template>

<script>
import navBarTop from '@/components/nav-bar-top'
import meetingList from './components/meeting-list'
import bottomBar from '@/components/footer'

export default {
  name: "index",
  components: {
    navBarTop,
    meetingList,
    bottomBar
  }
}
</script>

<style scoped>
.meeting_list_title {
  font-size: 34px;
  color: #000;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.meeting_list_container {
  width: 80%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}


.home_page_contianer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.meeting_list_title {
}

.meeting_schedule {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
}

.meeting_schedule_line {
  width: 80%;
}



</style>
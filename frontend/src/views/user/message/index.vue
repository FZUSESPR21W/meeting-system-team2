<template>
  <div class="message_contianer full_height">
    <div class="my_forum_list">
      <p class="list_title">{{ $t('message.myMeetings') }}</p>
      <div class="my_forum_list_item" v-for="(itemList,index) in meetingList" @click="selectMeeting(index, itemList.id)"
           :id="'meeting_list' + index">
        <p class="meeting_title">
          {{ itemList.name }}
          <el-tag :type="itemList.status == 0 ? 'success' : 'danger'">{{ itemList.status == 0 ? $t('message.check') : $t('message.uncheck') }}</el-tag>
        </p>
        <p class="meeting_content">
          <i class="el-icon-user-solid"/>
          {{ itemList.chairman_name }}
        </p>
        <p class="meeting_content">{{ itemList.context.slice(0, 20) + '...' }}</p>
        <p class="meeting_time">
          <i class="el-icon-time"/>
          2021-3-27
        </p>
      </div>
    </div>
    <div class="sub_forum_message">
      <p class="sub_forum_name">{{ selectMeetingInfo.name }}</p>
      <el-divider/>
      <el-card v-for="messageData in subForumMessage" class="card_contiaer" :key="messageData.title">
        <div slot="header">
          <span>{{ messageData.title }}</span>
        </div>
        <div class="publisher">
          <i class="el-icon-user-solid icon"/>
          <p class="publisher_name">{{ messageData.authorId }}</p>
        </div>
        <div>
          <p class="message_describe">
            {{ messageData.context }}
          </p>
        </div>
        <div class="message_start_time">
          <i class="el-icon-time"/>
          {{ messageData.postTime }}
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",
  created() {
    this.$api.Meeting.getMeetingList(this.$store.state.userData.name).then(res => {
      this.meetingList = res.data.data.meetingList
    })
  },
  data() {
    return {
      meetingList: [],
      selectMeetingInfo: {},
      subForumMessage: []
    }
  },
  methods: {
    selectMeeting(index,meetId) {

      this.selectMeetingInfo = this.meetingList[index]
      for (let i = 0; i < this.meetingList.length; i++) {
        document.getElementById('meeting_list' + i).className = 'my_forum_list_item'
        if (i == index) {
          document.getElementById('meeting_list' + i).className = 'my_forum_list_item_active'
        }

      }

      this.$api.Meeting.getPostList(meetId).then(res => {
        this.subForumMessage = res.data.data.postList
      })


    }
  }
}
</script>

<style scoped>
.message_contianer {
  padding-bottom: 40px;
  display: flex;
}

.my_forum_list {
  height: 100%;
  background-color: #F7F7F7;
  width: 350px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.my_forum_list_item {
  width: 90%;
  background-color: white;
  border: 1px solid #E8E8E8;
  border-radius: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
  cursor: pointer;
}

.my_forum_list_item:hover {
  background-color: #65BD77;
  color: white;
}

.my_forum_list_item:hover .meeting_time {
  color: white;
}

.my_forum_list_item:hover .icon {
  color: white;
}

.my_forum_list_item:hover .meeting_content {
  color: white;
}

.my_forum_list_item_active {
  background-color: #65BD77;
  color: white;
  width: 90%;
  border: 1px solid #E8E8E8;
  border-radius: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
  cursor: pointer;
}

.my_forum_list_item_active p{
  margin: 10px;
}

.my_forum_list_item_active .meeting_time {
  color: white;
}

.my_forum_list_item_active .icon {
  color: white;
}

.my_forum_list_item_active .meeting_content {
  color: white;
}


.list_title {
  color: #717179;
  font-size: 16px;
}

.meeting_title {
  font-weight: 700;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.meeting_time {
  color: grey;
  font-size: 13px
}

.my_forum_list_item p {
  margin: 10px;
}

.sub_forum_message {
  width: 80%;
}

.meeting_content {
  font-size: 13px;
  color: grey
}

.sub_forum_message {
  font-size: 24px;
}

.sub_forum_name {
  margin: 10px;
  color: #828279
}

.icon {
  width: 50px;
  height: 50px;
  font-size: 40px;
  border-radius: 100%;
  border: 1px solid grey;
  display: flex;
  justify-content: center;
  align-items: center;
}

.publisher {
  display: flex;
  align-items: center;
}

.publisher_name {
  font-size: 1.25rem;
  font-weight: bold;
  margin-left: 15px;
}

.message_describe {
  word-wrap: break-word;
  word-break: break-all;
  overflow: hidden;
  font-size: 15px;
}

.message_start_time {
  color: grey;
  font-size: 13px;
}

.card_contiaer {
  width: 100%;
  margin: 10px
}
</style>
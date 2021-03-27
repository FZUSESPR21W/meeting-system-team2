<template>
    <el-card class="card_contiaer">
      <div slot="header" >
        <span class="title">{{ data.name }}</span>
      </div>
      <p class="president_describe">{{ $t('index.subForumPresident') }}</p>
      <div class="president">
        <i class="el-icon-user-solid icon" />
        <p class="president_name">{{ data.chairman_name }}</p>
      </div>
      <div>
        <p class="meeting_describe">
          {{ data.context }}
        </p>
      </div>
      <el-button type="primary" class="meeting_button" plain>{{ $t('index.checkForumDetail') }}</el-button>
      <div class="meeting_start_time">
        <i class="el-icon-time" />
        2021-3-27
      </div>
    </el-card>
</template>

<script>
export default {
  name: "meeting-item",
  props: {
    data: {
      type: Object
    }
  }
}
</script>

<style scoped>
.title {
  font-size: 34px;
  color: #000;
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

.president {
  display: flex;
  align-items: center;
}

.president_name {
  font-size: 1.25rem;
  font-weight: bold;
  margin-left: 15px;
}

.meeting_describe {
  word-wrap: break-word;
  word-break: break-all;
  overflow: hidden;
  font-size: 15px;
}

.meeting_start_time {
  color: grey;
  font-size: 13px;
}

.meeting_button {
  margin-bottom: 10px;
}

.president_describe {
  color: grey;
  font-size: 13px;
}

.card_contiaer {
  width: 450px;
  margin: 10px
}

</style>
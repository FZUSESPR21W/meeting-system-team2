<template>
  <div class="center_background">
    <div class="center_table">
      <div class="center_title">{{$t('user.personalCenter')}}</div>
      <div class="center_detail">
        <div class="detail_username">
          <span class="detail_span">{{$t('user.username')}}</span>
          <span class="username_data">xxxxxxxxxxxx</span>
        </div>
        <div class="detail_email">
          <span class="detail_span">{{$t('user.email')}}</span>
          <span class="email_data">123456789@qq.com</span>
        </div>
        <div class="detial_register_time">
          <span class="detail_span">{{$t('user.registerTime')}}</span>
          <span class="register_time_data"
            >2020年01月01日 15：00 （UTC+8）</span>
        </div>
        <div class="bbs_member">
          <span class="member_data">{{$t('user.jointBbs')}}</span>
          <el-checkbox v-model="ml_ischeck" id="1">{{$t('interest.machineLlearning')}}</el-checkbox>
          <el-checkbox v-model="net_ischeck" id="2">{{$t('interest.computerVision')}}</el-checkbox>
          <el-checkbox v-model="tp_ischeck" id="3">{{$t('interest.neuralNetwork')}}</el-checkbox>
        </div>
        <el-button class="personal_detail_confirm">{{$t('user.confirm')}}</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      ml_ischeck: true,
      net_ischeck: false,
      tp_ischeck: false,
    };
  },
};
</script>

<style scoped>
.center_background{
  height: 100%;
  background-color: #FAFBFC;
}
.center_table {
  padding-left: 5%;
  margin: 0 auto;
  width: 60%;
  height: 100%;
  background-color: white;
}
.detail_span{
  color: gray;
}
</style>
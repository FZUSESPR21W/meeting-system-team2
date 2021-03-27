<template>
  <div class="center_background">
    <div class="center_table">
      <div class="title_contianer">
        <div class="decorate" />
        <div class="center_title">{{ $t("user.personalCenter") }}</div>
      </div>
      <el-divider />
      <div class="center_detail">
        <div class="detail">
          <i class="el-icon-user-solid icon" />
          <span class="detail_span">{{ $t("user.username") }}</span>
          <span class="detail_data">{{ localUserName }}</span>
        </div>
        <div class="detail">
          <i class="el-icon-message icon" />
          <span class="detail_span">{{ $t("user.email") }}</span>
          <span class="detail_data">{{ localEmail }}</span>
        </div>
        <div class="detail">
          <i class="el-icon-time icon" />
          <span class="detail_span">{{ $t("user.registerTime") }}</span>
          <span class="detail_data">{{ loaclrTime }}</span>
        </div>
        <div class="bbs_member">
          <i class="el-icon-s-grid icon" />
          <span class="detail_span">{{ $t("user.jointBbs") }}</span>
          <el-checkbox v-model="ml_ischeck" id="1">{{
            $t("interest.machineLlearning")
          }}</el-checkbox>
          <el-checkbox v-model="net_ischeck" id="2">{{
            $t("interest.computerVision")
          }}</el-checkbox>
          <el-checkbox v-model="tp_ischeck" id="3">{{
            $t("interest.neuralNetwork")
          }}</el-checkbox>
        </div>
        <el-divider />
        <el-button class="personal_detail_confirm">{{
          $t("user.confirm")
        }}</el-button>
      </div>
    </div>
  </div>
</template>

<script>
function renderTime(date) {
  var dateee = new Date(date).toJSON();
  return new Date(+new Date(dateee) + 8 * 3600 * 1000)
    .toISOString()
    .replace(/T/g, " ")
    .replace(/\.[\d]{3}Z/, "");
}
export default {
  name: "index",
  data() {
    return {
      localUserName: this.$store.state.userData.name,
      localEmail: this.$store.state.userData.email,
      loaclrTime: this.$store.state.userData.registerTime,
      ml_ischeck: true,
      net_ischeck: false,
      tp_ischeck: false,
    };
  },
  created() {

  },
};
</script>

<style scoped>
.center_background {
  height: 100%;
  background-color: #fafbfc;
  padding-top: 5%;
}
.center_table {
  padding: 30px;
  margin: 0 auto;
  width: 1000px;
  height: 50%;
  background-color: white;
  border-radius: 10px;
  box-shadow: 15px 0 15px -15px grey, -15px 0 15px -15px grey;
}
.detail_span {
  color: gray;
  width: 200px;
  /* background-color: violet; */
  /* display: inline; */
  display: inline-block;
}
.center_title {
  font-size: 25px;
}
.detail {
  margin-top: 20px;
}
.personal_detail_confirm {
  background-color: #409eff;
  color: white;
  float: right;
}
.bbs_member {
  margin-top: 20px;
}

.decorate {
  width: 5px;
  height: 25px;
  background-color: #409eff;
  margin-right: 10px;
}

.title_contianer {
  display: flex;
  align-items: center;
  padding-top: 30px;
}

.icon {
  color: grey;
  margin-right: 10px;
}
</style>
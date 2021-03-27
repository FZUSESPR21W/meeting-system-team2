<template>
  <div class="center_table">
    <div class="center_title">
      个人中心
    </div>
    <div class="center_detail">
      <div class="detail_username">
        <span class="username_span">用户名:</span>
        <span class="username_data">xxxxxxxxxxxx</span>
      </div>
      <div class="detail_email">
        <span class="email_span">电子邮箱</span>
        <span class="email_data">123456789@qq.com</span>
      </div>
      <div class="detial_register_time">
        <span class="register_time_span">注册时间：</span>
        <span class="register_time_data">2020年01月01日 15：00 （UTC+8）</span>
      </div>
      <div class="bbs_member">
        <span class="member_data">参与论坛：</span>
        <el-checkbox v-model="ml_ischeck" id="1">机器学习</el-checkbox>
        <el-checkbox v-model="net_ischeck" id="2">神经网络</el-checkbox>
        <el-checkbox v-model="tp_ischeck" id="3">知识图谱</el-checkbox>
      </div>
      <el-button class="personal_detail_confirm">修改</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      ml_ischeck :true,
      net_ischeck :false,
      tp_ischeck :false,
    }
  }
}
</script>

<style scoped>
  .center_tabel {
    background-color: silver;
  }
</style>
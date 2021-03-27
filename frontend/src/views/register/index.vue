<template>
  <div>
    <div class="register_label">
      <div class="outer_label">
        <div class="register_title">{{ $t('register.title') }}</div>
      </div>
      <div class="inner_label">
        <form action="" class="register_form">
          <label for="register_field" class="register_form_field"
            >{{ $t('register.username') }}<a style="color: red"> *</a></label
          >
          <el-input
            type="text"
            class="form_label"
            v-model="userName"
            show-password
          ></el-input>
          <label for="pwd_field" class="register_form_field"
            >{{ $t('register.password') }}<a style="color: red"> *</a></label
          >
          <el-input
            class="form_label"
            v-model="password"
            show-password
          ></el-input>
          <label for="rePwd_field" class="register_form_field"
            >{{ $t('register.rePassword') }}<a style="color: red"> *</a></label
          >
          <el-input
            class="form_label"
            v-model="rePassword"
            show-password
          ></el-input>
          <el-button class="register_btn" @click.native="register">{{
            $t('register.register')
          }}</el-button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import navBarTop from "@/components/nav-bar-top";
export default {
  name: "index",
  components: {
    navBarTop,
  },
  data() {
    return {
      userName: "",
      password: "",
      rePassword: "",
    };
  },
  methods: {
    register() {
        if(this.password === this.rePassword) {
            this.$api.User.register(this.userName,this.password,this.rePassword)
            .then(res => {
                if(res.data.message === 'success') {
                    //localStorage.setItem('username',this.userName)
                    //localStorage.setItem('authority',res.data.authority)
                    this.$message.success('注册成功，正在为您跳转……')

                    //跳转
                } else if (res.data.message === 'failed') {
                    this.$message.error('用户名已被注册')
                }
            })
            .then(res => {
                console.log(res.error)
            })
        } else {
            this.$message.error('')
        }
    },
  },
};
</script>

<style scoped>
.register_label {
  position: relative;
  margin: 0 auto;
  width: 1000px;
}
.outer_label {
  margin: 0 auto;
  width: 100px;
  text-align: center;
}
.inner_label {
  margin: 0 auto;
  width: 70%;
  height: 400px;
  text-align: center;
}
.form_label {
  margin: 0 auto;
  width: 80%;
  /* height: 60%; */
  margin-top: 5px;
  margin-bottom: 5px;
  border-radius: 6px;
  display: block;
}
.register_btn {
  padding-top: 10px;
  margin: 0 auto;
  margin-top: 30px;
  display: block;
  width: 80%;
  background-color: #2c974b;
  color: white;
}
.register_form_field {
  padding-top: 10px;
  margin-left: 10%;
  margin-top: 10px;
  margin-bottom: 10px;
  display: block;
  float: left;
}
.register_form {
  margin: 0 auto;
  width: 90%;
  height: 95%;
  background-color: #f6f8fa;
}
.register_title {
  margin-top: 50px;
  margin-bottom: 30px;
  font-size: 25px;
  font-family: "微软雅黑";
}
</style>
<template>
  <div>
    <div class="login_label">
      <div class="outer_label">
        <div class="login_title">{{ $t("login.title") }}</div>
      </div>
      <div class="inner_label">
        <form action="" class="login_form">
          <label for="login_field" class="login_form_field">{{
              $t("login.username")
            }}</label>
          <el-input
              type="text"
              class="form_label"
              v-model="userName"
          ></el-input>
          <label for="pwd_field" class="login_form_field">{{
              $t("login.password")
            }}</label>
          <el-input
              type="text"
              class="form_label"
              v-model="password"
              show-password
          ></el-input>
          <el-button class="login_btn" @click="login">{{
              $t("login.login")
            }}
          </el-button>
        </form>
        <div class="footer_label">
          <div class="register">
            {{
              $t("login.hint")
            }}<a class="register_link" @click="$router.push('/register')">{{ $t("login.register") }}</a>
          </div>
        </div>
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
    }
  },
  methods: {
    login() {
      this.$api.User.login(this.userName, this.password).then(res => {
        if (res.data.message === 'success') {
          //localStorage.setItem('username',this.userName)
          //localStorage.setItem('authority',res.data.data.authority)
          this.$message.success('登录成功')
          // alert('登录成功！')

          let authority = res.data.data.authority

          this.$api.User.getUserInfo().then((res) => {

            let userData = res.data.data.userList

            this.$store.commit('setUserData', {
              name: userData.userName,
              email: userData.email,
              registerTime: userData.registerTime,
              authority
            })


            if (authority === 1) { //普通用户
              this.$router.push('/user')
            } else if (authority === 2) { //分论坛主席
              this.$router.push('/detail')
            } else if (authority === 3) { //秘书
              this.$router.push('/admin/secretary')
            } else if (authority === 4) { //大主席
              this.$router.push('/chairman')
            }

          })



        } else if (res.data.message === 'failed') {
          this.$message.error('用户名或密码错误')
        }
      })
    },
  },
};
</script>

<style scoped>
.login_label {
  position: relative;
  margin: 0 auto;
  width: 1000px;
}

.outer_label {
  margin: 0 auto;
  width: 300px;
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

.login_btn {
  padding-top: 10px;
  margin: 0 auto;
  margin-top: 30px;
  display: block;
  width: 80%;
  background-color: #2c974b;
  color: white;
}

.login_form_field {
  padding-top: 10px;
  margin-left: 10%;
  margin-top: 10px;
  margin-bottom: 10px;
  display: block;
  float: left;
}

.login_form {
  margin: 0 auto;
  width: 50%;
  height: 70%;
  background-color: #f6f8fa;
}

.login_title {
  margin-top: 50px;
  margin-bottom: 30px;
  font-size: 25px;
  font-family: "微软雅黑";
  width: 100%;
}

.footer_label {
  margin: 0 auto;
  width: 50%;
  height: 10%;
  margin-top: 15px;
  border: 1px solid rgba(0, 0, 0, 0.75);
  border-radius: 3px;
  font-size: 15px;
}

.register {
  height: 90%;
  margin-top: 2.5%;
}

.register_link {
  color: #4996c9;
  text-decoration: none;
  cursor: pointer;
}
</style>
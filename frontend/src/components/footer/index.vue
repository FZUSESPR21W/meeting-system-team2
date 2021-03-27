<template>
<div class="footer">
    <el-row>
  <el-col :span="4"><div ></div></el-col>
  <el-col :span="2"><div>
          <a href="" class="footer-font">关于会议</a>
        </div></el-col>
  <el-col :span="2"><div >
        <el-dropdown :hide-on-click="false">
        <span class="el-dropdown-link">
            关于我们<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
            <el-dropdown-menu>
            <el-dropdown-item @click="openGithub('https://github.com/RoseSavona')">肖恩嘻嘻</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/yrc123')">羊肉串</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/2018FZUSELYK')">YukioLee</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/221801123')">WiLLyy</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/GaryChan029')">CLH029</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/Liangdayi')">不到65kg不改名</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/Aurora418/')">Aurora</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/raiLGun2000')">railgunSE</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/6586744')">6586744</el-dropdown-item>
            <el-dropdown-item @click="openGithub('https://github.com/Mr-Qingkong')">至沁</el-dropdown-item>
            </el-dropdown-menu>
        </template>
        </el-dropdown>
        </div></el-col>
  <el-col :span="8"><div>
          <a href="" class="footer-font">Copyright ©2021 发际线与我作队, All Rights Reserved.</a>
        </div></el-col>
  <el-col :span="3"><div>
          <a href="" class="footer-font">条款</a>
        </div></el-col>
  <el-col :span="5"></el-col>
</el-row>
</div>
</template>

<style>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .footer{
    width: 100%;
    position: fixed;    
    bottom: 0;
    left:20%;
  }
  .footer-font {
      color: #AAAAAA;
      text-decoration:none;
  }
  .footer-font:hover{
      color: #000000;
  }
  .el-dropdown-link {
    cursor: pointer;
    color: #AAAAAA;
  }
</style>


<script>

export default {
    name:"index", 
    data:{
    },
    methods:{
        openGithub(path){
            var tempwindow=window.open('_blank');
            tempwindow.location=path;
        },
    },
}
</script>

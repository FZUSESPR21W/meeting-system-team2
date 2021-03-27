<template>
<el-container>
    <el-aside>
      <navBarSide/>
   </el-aside> 

    <el-main>
      <h2>会议数据</h2>
      <div v-if="isShow">
        <Echarts/>
        <el-button type="primary" id="release" @click="isShow=!isShow">发布会议</el-button>
        <p id="num">会议总人数：{{num}}</p>
      </div>
    </el-main>
</el-container>



</template>
 
<script>
import navBarSide from '@/components/nav-bar-side'
import Echarts from './components/echarts.vue'
export default {
    name: "index",
    components: {
      navBarSide,
      Echarts
    },
    data(){
        return{
            isShow: true,
            num: 1200,
        }
    },
    
    methods: {
      
    }

}
 
</script>
    
<style>
  #myChart{
    float:left;
  }
  #relesase{
    float: right;
    margin-right: 260px;
  }
  #num{
    clear: both;
  }

</style>
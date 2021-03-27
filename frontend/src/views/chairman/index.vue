<template>
<el-container class="content">
    <el-aside>
      <navBarSide/>
   </el-aside> 

    <el-main>
      <h2>会议数据</h2>
      <div>
        <Echarts/>
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

  #num{
    margin-left: 500px;
    margin-top: 50px;
    
  }
  .content{
    height: 100%;
  }

</style>
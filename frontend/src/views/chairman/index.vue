<template>
<el-container>
    <el-aside>
      <navBarSide/>
   </el-aside> 

    <el-main>
      <h2>时间分布图</h2>
      <Echarts/>
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
            msg: "Welcome to Your Vue.js App"
        }
    },
    
    methods: {
      
    }

}
 
</script>
    
<style>
     
</style>
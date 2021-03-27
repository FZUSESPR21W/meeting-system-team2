<template>
  <div>
      <div>
        <h1>论坛数据详情页</h1>
      </div>
      <sumChart />  
  </div>
</template>

<script>
import sumChart from '@/components/echart-sub-sum';
export default {
name: "index",
components: {
    sumChart
  },
  data() {
    return {
    }
},
methods: {
    }
}
</script>

<style scoped>

</style>
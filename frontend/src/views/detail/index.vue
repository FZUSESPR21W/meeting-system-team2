<template>
  <div>
    <navBarSide class="sideBar"/>
    <sumChart />
  </div>
</template>

<script>
import sumChart from '@/components/echart-sub-sum';
import navBarSide from '@/components/nav-bar-side';
export default {
name: "index",
components: {
    sumChart,
    navBarSide
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
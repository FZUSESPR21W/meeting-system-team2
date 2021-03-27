<template>
<div id="sumChart" :style="{width: '300px', height: '300px'}"></div>
</template>

<script>
export default {
  name: 'sum',
  data () {
    return {
      msg: 'sum showed'
    }
  },
  mounted(){
    this.drawLine();
  },
  methods: {
    drawLine(){
        // 基于准备好的dom，初始化echarts实例
        let sumChart = this.$echarts.init(document.getElementById('sumChart'))
        // 绘制图表
        sumChart.setOption({
            title: { text: '各论坛分会关注人数' },
            tooltip: {},
            xAxis: {
                data: ["CVPR","ECCV","ICCV"]
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                name: '关注人数',
                type: 'bar',
                data: [5, 20, 36],
                smooth: true
            }]
        });
    }
  }
}
</script>
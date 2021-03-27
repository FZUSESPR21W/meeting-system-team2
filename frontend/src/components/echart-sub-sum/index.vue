<template>
<div id="sumChart" :style="{width: '666px', height: '560px',left: '500px',top: '50px',}"></div>
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
    let userNum = []
    this.$api.Echarts.getSubNum().
    then(res => {
        userNum = [res.data.data.list[1],res.data.data.list[2],res.data.data.list[3]]
        this.initChart(userNum);
    })
    
  },
  methods: {
    initChart(userNum){
        
        // 基于准备好的dom，初始化echarts实例
        let sumChart = this.$echarts.init(document.getElementById('sumChart'))
        // 绘制图表
        sumChart.setOption({
            title: { text: '各分会论坛关注人数' },
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
                data: userNum,
                smooth: true,
                itemStyle: {
                    normal: {
                    color: function(params) {
                        var colorList = ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#ca8622'];
                        return colorList[params.dataIndex]
                        }
                    }
                }
            }]
        });

        
    }
  }
}
</script>

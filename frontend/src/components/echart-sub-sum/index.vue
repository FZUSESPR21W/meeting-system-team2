<template>
<div id="sumChart" :style="{width: '800px', height: '800px'}"></div>
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
    this.initChart();
  },
  methods: {
    initChart(){
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
                data: [66,77,88],
                smooth: true
            }]
        });
        this.$axios.get('请求的接口')
            .then((res)=>{
                console.log('访问后台');
                this.labList=null;
                console.log(this.labList);  
                sumChart.setOption({
                    series:[
                        {
                            name: '关注人数',
                            type: 'bar',
                            data:this.labList,
                            smooth: true
                        }
                    ]
                })
            });
    }
  }
}
</script>
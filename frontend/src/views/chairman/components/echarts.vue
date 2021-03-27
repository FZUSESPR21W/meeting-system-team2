<template>
    <div id="myChart" :style="{width: '1100px', height: '500px',left:'400px',top:'50px'}"></div>
    
</template>
 
<script>
export default {
    name: "index",
    data(){
        return {

        }
    },
    mounted(){
        this.drawLine();
    },
    methods: {
      drawLine(){  
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('myChart'))
        // 绘制图表
        myChart.setOption(
        {
            title: {
            text: '关注用户时间分布图',
            // subtext: '纯属虚构'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
            type: 'cross'
            }
        },
        toolbox: {
            show: true,
            feature: {
            saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['00:00', '01:30', '03:00', '04:30', '06:00', '07:30', '09:00', '10:30', '12:00', '13:30', '15:00', '16:30', '18:00', '19:30', '21:00', '22:30', '24:00']
        },
        yAxis: {
            type: 'value',
            axisLabel: {
            formatter: '{value} '
            },
            axisPointer: {
                snap: true
            }
        },
        visualMap: {
            show: false,
            dimension: 0,
            pieces: [{
                lte: 6,
                color: 'green'
            }, 
            {
                gt: 6,
                lte: 8,
                color: 'red'
            }, 
            {
                gt: 8,
                lte: 14,
                color: 'green'
            }, 
            {
                gt: 14,
                lte: 17,
                color: 'red'
            }, 
            {
                gt: 17,
                color: 'green'
            }]
        },
        series: [
            {
                name: '关注人数',
                type: 'line',
                smooth: true,
                data: [300, 280, 250, 260, 270, 300, 550, 500, 400, 390, 380, 390, 400, 500, 600, 750, 800],
                // markArea: {
                //     itemStyle: {
                //         color: 'rgba(255, 173, 177, 0.4)'
                //     },
                //     data: [ [{
                //         name: '早高峰',
                //         xAxis: '07:30'
                //     }, {
                //         xAxis: '10:00'
                //     }], [{
                //         name: '晚高峰',
                //         xAxis: '17:30'
                //     }, {
                //         xAxis: '21:15'
                //     }] ]
                // }
            }
        ]
        });
       }
    }

}
</script>
    
<style>
     
</style>
<template>
    <div style="position: fixed;left:30%;top:20%">
        <h2>发送消息</h2>
        <el-input
            type="text"
            placeholder="请输入标题"
            v-model="title"
            maxlength="30"
            show-word-limit
            style="width:70%;margin-bottom:30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)"
            >
        </el-input>
        <el-input
            type="textarea"
            :autosize="{ minRows: 5}"
            placeholder="请输入内容"
            v-model="content"
            style="margin-bottom:30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">
        </el-input>
        <el-button type="primary" :plain="true" @click="sendMessage()" 
            style=" box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"
            >
            <i class="el-icon-s-promotion"></i><span>发送</span></el-button>
    </div>
</template>

<script>
export default {
    name: "index",
    data() {
    return {
      title: '',
      content: ''
    }
  },
    methods:{
        sendMessage(){
            if(this.title===''){
                this.$message({
                showClose: true,
                message: '标题不允许为空！',
                type: 'error'
                });
                return ;
            }
            console.log(this.title+'\n'+this.content);
            //发送

            //发送消息
            this.$message({
            showClose: true,
            message: '消息发送成功！',
            type: 'success'
            });
        }
    }
}
</script>

<style>
</style>
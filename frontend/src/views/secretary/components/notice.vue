<template>
    <div style="position: fixed;left:5%">
        <h2>发送消息</h2>
        <el-input
            type="text"
            placeholder="请输入标题"
            v-model="title"
            maxlength="30"
            show-word-limit
            style="width:70%;margin-bottom:30px"
            >
        </el-input>
        <el-input
            type="textarea"
            :autosize="{ minRows: 5}"
            placeholder="请输入内容"
            v-model="content"
            style="margin-bottom:30px">
        </el-input>
        <el-button type="primary" plain @click="sendMessage()">发送</el-button>
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
            console.log(this.title+'\n'+this.content);
        }
    }
}
</script>

<style>
</style>
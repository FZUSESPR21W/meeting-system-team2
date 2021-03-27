<template>

</template>

<script>
export default {
  name: "index",
  created() {
    this.$api.User.logout().then(res => {
      this.$message.success('登出成功')
      this.$store.commit('clearUserData')
      this.$router.push('/')
    })
  }
}
</script>

<style scoped>

</style>
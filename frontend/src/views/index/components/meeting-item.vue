<template>
  <div>
    {{ data.name }}
  </div>
</template>

<script>
export default {
  name: "meeting-item",
  props: {
    data: {
      type: Object
    }
  }
}
</script>

<style scoped>

</style>
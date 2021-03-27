<template>
  <div id="app">
    <router-view class="full_height" />
  </div>
</template>

<style>
html {
  height: 100%;
}

body {
  margin: 0;
  height: 100%;
}

#app {
  height: 100%;
}


.full_width {
  width: 100%;
}

.full_height {
  height: 100%;
}

::-webkit-scrollbar { width: 0 !important }
</style>

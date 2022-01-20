<template>
  <div id="app">
    <hello-world/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>

body{
    margin: 0;
    /* 100%窗口高度 */
    height: 100vh;
    /* 弹性布局 水平、垂直居中 */
    display: flex;
    align-items: center;
    justify-content: center;
    /* 背景径向渐变 */
    background: radial-gradient(circle at center,mediumpurple,#000);
}
</style>

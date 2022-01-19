<template>
  <div class="main">
      <button class="btn" @click="queryServerSideCurrentTime">获取服务端的当前时间</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  methods:{
    queryServerSideCurrentTime() {
      axios.get("/apis/current-time")
      .then(response => {
          alert(`服务端的当前时间是 ${response.data.now}`);
        })
      .catch(error => {
        console.log(error);
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.main {
  width:100%;
  height: 350px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.btn {
  display: block;
  background: rgba(200,220,255,0.4);
  border-radius: 5px;
  border: 1px solid transparent;
  box-shadow: 2px 2px gray;
}

</style>

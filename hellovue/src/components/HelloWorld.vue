<template>
    <div>
        <div class="heart">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>

        <div class="current-warpper">
            <span>服务端的当前时间 {{now}} </span>
        </div>

        <div class="author">
            <span>powered by neeky</span>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data:function() {
      return {
          now:'2022-01-01 00:00:00'
      };
  },
  methods:{
    queryServerSideCurrentTime() {
      axios.get("/apis/current-time")
      .then(response => {
          this.now = response.data.now
        })
      .catch(error => {
        console.log(error);
      })
    }
  },
  mounted:function() {
      setInterval(this.queryServerSideCurrentTime,1000)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.heart{
    width: 280px;
    height: 220px;
    display: flex;
    justify-content: space-between;
}
.heart span{
    /* 自定义属性值【划重点】 */
    --c:plum;
    --h:50%;
    --t:25%;
    /* var()函数用于插入自定义的属性值，如果一个属性值在多处被使用，该方法就很有用 */
    background-color: var(--c);
    width: 20px;
    border-radius: 10px;
    position: relative;
    height: var(--h);
    top: var(--t);
    /* 执行动画 infinite是无限次播放 */
    animation: beating 1s infinite;
}
.heart span:nth-child(1),
.heart span:nth-child(9){
    --c:lightcoral;
    --h:60px;
    --t:44px;
}
.heart span:nth-child(2),
.heart span:nth-child(8){
    --c:lightskyblue;
    --h:120px;
    --t:12px;
}
.heart span:nth-child(3),
.heart span:nth-child(7){
    --c:lightgreen;
    --h:160px;
    --t:0;
}
.heart span:nth-child(4),
.heart span:nth-child(6){
    --c:gold;
    --h:180px;
    --t:16px;
}
.heart span:nth-child(5){
    --c:plum;
    --h:188px;
    --t:32px;
}

.current-warpper {
    /* 内容居中*/
    display: flex;
    justify-content: center;
    align-items: center;

}

.current-warpper span {
    color:rgba(0,0,0,0.3);
    text-shadow: 1px 1px 3px rgba(255,255,255,0.7);
}

.author {
    /* 内容居中*/
    position: fixed;
    bottom:0;
    left:0;
    right:0;
    margin-left:auto;
    margin-right: auto;
    margin-top:auto;

    display: flex;
    justify-content: center;
    align-items: flex-start;
}

.author span {
    color:rgba(255,255,255,0.8);
}

/* 接下来我们定义动画 */
@keyframes beating{
    0%,30%{
        height: var(--h);
        top: var(--t);
        background-color: var(--c);
        filter: blur(0);
    }
    60%,70%{
        height: 50%;
        top: 25%;
        background-color: plum;
        /* 模糊度 */
        filter: blur(5px);
    }
}
</style>

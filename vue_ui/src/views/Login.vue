<template>
  <div>
    <div class = title>
      <h2>登录</h2>
    </div>

    <div class=table-box>
      <el-input v-model="username" placeholder="用户名" />
      <el-input
          v-model="password"
          type="password"
          placeholder="密码"
          show-password
      />
      <el-button type="primary">登录</el-button>
    </div>



  </div>
</template>

<script setup>

  import {ref} from "vue";

  const username=ref();
  const password= ref()

</script>

<style scoped>
.table-box{
  width: 800px;
  margin: 200px auto;
}
.title{
  text-align: center;
}

</style>
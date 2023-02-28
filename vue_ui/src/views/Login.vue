<template>
  <div>
    <div class = title>
      <h2>登录</h2>
    </div>

    <div class=table-box>
      <el-input v-model="userForm.username" placeholder="用户名" />
      <el-input
          v-model="userForm.password"
          type="password"
          placeholder="密码"
          show-password
      />
      <el-button type="primary" @click="">登录</el-button>
    </div>



  </div>
</template>

<script setup>

  import {ref} from "vue";
  import {useUserStore} from "@/store/userStore.js";
  import {storeToRefs} from "pinia";
  import API from "@/plugin/axiosInstance.js";


  const user = useUserStore()

  const {userForm}= storeToRefs(user)


  function login(){
    API.get("http://localhost:8080/login",userForm).then(res=>{
        user.userForm = res.data;
    })
  }

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
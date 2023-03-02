<template>
  <div class="login">
    <div class = title>
      <h2>登录</h2>
    </div>

    <el-form
      label-width="80px"
      :model="user.userForm"
    >
      <el-form-item label="账号">
        <el-input v-model="user.userForm.username" placeholder="用户名" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input
            v-model="user.userForm.password"
            type="password"
            placeholder="密码"
            show-password
        />
      </el-form-item>

      <el-form-item>
        <el-button
            type="primary"
            @click="login"
            class="btn-sub"
            :disabled="!user.canSubmit"
        >登录</el-button>
      </el-form-item>


    </el-form>





  </div>
</template>

<script setup>

import {computed, ref} from "vue";
  import {useUserStore} from "@/store/userStore.js";
  import {storeToRefs} from "pinia";
  import API from "@/plugin/axiosInstance.js";


  const user = useUserStore()


  function login(){
    API.post("http://localhost:8080/user/login",user.userForm).then(res=>{
        user.userForm = res.data;
    })
  }

</script>

<style scoped>
.login{
  width:450px;
  margin: 180px auto;
  border: 1px solid ;
  padding: 20px;
  border-radius: 10px;
}
.title{
  text-align: center;
}

</style>
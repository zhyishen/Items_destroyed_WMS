<template>

  <el-row :span="24" class="tac">
    <el-col :span="3">
      <h5 class="mb-2">仓库管理系统</h5>
      <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon><location /></el-icon>
            <span>进库管理</span>
          </template>

          <el-menu-item index="1-1" @click="">电子设备入库</el-menu-item>
          <el-menu-item index="1-2" @click="">涉密文件入库</el-menu-item>
          <el-menu-item index="1-3" @click="">非涉密文件入库</el-menu-item>

        </el-sub-menu>

        <el-sub-menu index="2">
          <template #title>
            <el-icon><icon-menu /></el-icon>
            <span>仓库管理</span>
          </template>
          <el-menu-item index="2-1" @click="toPage('Electronics')">电子设备列表</el-menu-item>
          <el-menu-item index="2-2" @click="toPage('ConfidentialDocuments')">涉密文件列表</el-menu-item>
          <el-menu-item index="2-3" @click="toPage('NonConfidentialDocuments')">非涉密文件列表</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="3" >
          <el-icon><document /></el-icon>
          <span>基础管理</span>
        </el-menu-item>
        <el-menu-item index="4" >
          <el-icon><setting /></el-icon>
          <span>系统管理</span>
        </el-menu-item>
      </el-menu>
    </el-col>
    <el-col :span="21">
      <router-view></router-view>
    </el-col>
  </el-row>

</template>

<script setup>

import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

import {useRouter} from "vue-router";

const router = useRouter()
const toPage = (name)=>{
  router.push({
    name
  })
}

</script>

<style scoped>

</style>
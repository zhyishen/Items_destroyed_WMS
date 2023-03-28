<template>

  <div class="title">
    <h2>单位新增</h2>
  </div>
  <div class="input-window">
    <el-form :model="elty.tableForm">
      <el-form-item label="类型名称" :label-width="100">
        <el-input v-model="elty.tableForm.typeName" autocomplete="off" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="dialogConfirm">
          确认
        </el-button>

      </el-form-item>
    </el-form>
  </div>

</template>

<script setup>
import {onMounted} from "vue";

import {useElectronicTypeStore} from "@/store/electronicTypeStore.js";
const elty = useElectronicTypeStore()
const dialogConfirm = ()=>{

  // 拿到数据
  // 添加到table
  elty.addItem(elty.tableForm)
  elty.getItems()
}

onMounted(()=>{
  elty.tableForm={}
  elty.getItems()
})
</script>

<style scoped>
.title{
  text-align: center;
}
.input-window{
  width: 800px;
  margin: 200px auto;
}
</style>
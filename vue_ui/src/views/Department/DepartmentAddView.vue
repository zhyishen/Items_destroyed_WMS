<template>

  <div class="title">
    <h2>单位新增</h2>
  </div>
  <div class="input-window">
    <el-form :model="dep.tableForm">
      <el-form-item label="部门名称" :label-width="100">
        <el-input v-model="dep.tableForm.departmentName" autocomplete="off" />
      </el-form-item>
      <el-form-item label="联系人" :label-width="100">
        <el-input v-model="dep.tableForm.contact" autocomplete="off" />
      </el-form-item>
      <el-form-item label="单位类型" :label-width="100">
        <el-radio-group v-model="dep.tableForm.type" size="large">
          <el-radio-button label="移交单位" />
          <el-radio-button label="接收单位" />
        </el-radio-group>
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
import {useDepartmentStore} from "@/store/departmentStore.js";
const dep = useDepartmentStore()
const dialogConfirm = ()=>{

  // 拿到数据
  // 添加到table
  dep.addItem(dep.tableForm)
  dep.getItems()
}

onMounted(()=>{
  dep.tableForm={}
  dep.getItems()
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
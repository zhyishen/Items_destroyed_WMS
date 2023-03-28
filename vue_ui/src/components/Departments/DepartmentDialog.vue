<template>
  <el-dialog v-model="dep.dialogFormVisible" :title="'编辑条目' ">
    <el-form :model="dep.tableForm">
      <el-form-item label="单位名称" :label-width="100">
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
    </el-form>
    <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="dialogConfirm">
                    确认
                    </el-button>
                </span>
    </template>
  </el-dialog>
</template>

<script setup>

import {useDepartmentStore} from "@/store/departmentStore.js";

const dep = useDepartmentStore()

const dialogConfirm = ()=>{
  dep.dialogFormVisible = false
  // 判断
  const index = dep.tableData.findIndex(item => item.departmentId===dep.tableForm.departmentId)
  dep.tableData[index] = dep.tableForm
  dep.updateItem(dep.tableForm.departmentId,dep.tableForm)
}
</script>

<style scoped>

</style>
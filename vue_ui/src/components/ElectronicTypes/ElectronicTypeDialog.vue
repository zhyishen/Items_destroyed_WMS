<template>
  <el-dialog v-model="elty.dialogFormVisible" :title="'编辑条目' ">
  <el-form :model="elty.tableForm">
    <el-form-item label="类型名称" :label-width="100">
      <el-input v-model="elty.tableForm.typeName" autocomplete="off" />
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
import {useElectronicTypeStore} from "@/store/electronicTypeStore.js";

const elty = useElectronicTypeStore()
const dialogConfirm = ()=>{
  elty.dialogFormVisible = false
  // 判断
  const index = elty.tableData.findIndex(item => item.id===elty.tableForm.id)
  elty.tableData[index] = elty.tableForm
  elty.updateItem(elty.tableForm.id,elty.tableForm)
}
</script>

<style scoped>

</style>
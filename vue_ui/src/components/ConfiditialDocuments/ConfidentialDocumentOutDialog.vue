<template>
<div>
  <el-dialog v-model="cfso.dialogFormVisible" :title="'编辑条目' ">
    <el-form :model="cfso.tableForm">
      <el-form-item label="数量" :label-width="100">
        <el-input-number v-model="cfso.tableForm.quantity" :min="1" />
      </el-form-item>
      <el-form-item label="密级" :label-width="100">
        <el-radio-group v-model="cfso.tableForm.secretLevel" size="large">
          <el-radio-button label="绝密" />
          <el-radio-button label="机密" />
          <el-radio-button label="秘密" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="接收单位" :label-width="100">
        <el-select
            v-model="cfso.tableForm.receiveDepartment"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >
          <el-option
              v-for="item in dep.tableData"
              :key="item.departmentID"
              :label="item.departmentName"
              :value="item"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="移交人" :label-width="100">
        <el-select
            v-model="cfso.tableForm.transferor"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >
          <el-option
              v-for="item in cfso.transferors"
              :key="item.value"
              :label="item.label"
              :value="item.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="移交日期" :label-width="100">
        <el-config-provider :locale=zhCn>
          <el-date-picker
              v-model="cfso.tableForm.sendDate"
              type="date"
          />
        </el-config-provider>

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
</div>
</template>

<script setup>

import {useConfidentialDocumentOutsStore} from "@/store/confidentialDocumentOutStore.js";
import {zhCn} from "element-plus/lib/locale/index";
import {useDepartmentStore} from "@/store/departmentStore.js";
import {onMounted} from "vue";
const cfso = useConfidentialDocumentOutsStore()
const dep = useDepartmentStore()
const dialogConfirm = ()=>{
  cfso.dialogFormVisible = false
  // 判断
  let index = cfso.tableData.findIndex(item => item.id===cfso.tableForm.id)
  cfso.tableData[index] = cfso.tableForm
  cfso.updateItem(cfso.tableForm.id,cfso.tableForm)

}
onMounted(()=>{
  dep.getReceiveDepartments()
})
</script>

<style scoped>

</style>
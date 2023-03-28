<template>
  <div>
    <el-dialog v-model="nfso.dialogFormVisible" :title=" '编辑条目' ">
    <el-form :model="nfso.tableForm">
      <el-form-item label="接收单位" :label-width="100" prop="department">
        <el-select
            v-model="nfso.tableForm.receiveDepartment"
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
      <el-form-item label="数量" :label-width="100">
        <el-input-number v-model="nfso.tableForm.quantity" :min="1" />
      </el-form-item>
      <el-form-item label="移交人" :label-width="100">
        <el-select
            v-model="nfso.tableForm.transferor"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >

        </el-select>
      </el-form-item>
      <el-form-item label="移交日期" :label-width="100">
        <el-config-provider :locale=zhCn>
          <el-date-picker
              v-model="nfso.tableForm.sendDate"
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

import {useNonConfidentialDocumentOutsStore} from "@/store/nonConfidentialDocumentOutStore.js";
import {zhCn} from "element-plus/lib/locale/index";
import {useDepartmentStore} from "@/store/departmentStore.js";
import {onMounted} from "vue";
const nfso = useNonConfidentialDocumentOutsStore()
const dep = useDepartmentStore()
const dialogConfirm = ()=>{
  nfso.dialogFormVisible = false
  // 判断
  let index = nfso.tableData.findIndex(item => item.id===nfso.tableForm.id)
  // console.log(index)
  nfso.tableData[index] = nfso.tableForm
  nfso.updateItem(nfso.tableForm.id,nfso.tableForm)
}

onMounted(()=>{
  dep.getReceiveDepartments()
})
</script>

<style scoped>

</style>
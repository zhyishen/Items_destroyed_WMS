<template>
  <div class="title">
    <h2>
      涉密文件出库
    </h2>
  </div>
  <div class = "input-window">
    <!-- input window -->
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
      <el-form-item>
        <el-button type="primary" @click="dialogConfirm">
          确认
        </el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script setup>

import {useConfidentialDocumentOutsStore} from "@/store/confidentialDocumentOutStore.js";
import {zhCn} from "element-plus/lib/locale/index";
import {onMounted} from "vue";
import {useDepartmentStore} from "@/store/departmentStore.js";

const cfso = useConfidentialDocumentOutsStore()
const dep = useDepartmentStore()
const dialogConfirm = ()=>{

  // 拿到数据
  // 添加到table
  cfso.addItem(cfso.tableForm)
  cfso.getItems()
  dep.getReceiveDepartments()
}

onMounted(()=>{
  cfso.tableForm = {}
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
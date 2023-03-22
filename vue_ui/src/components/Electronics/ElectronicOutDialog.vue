<template>
<div>
  <el-dialog v-model="elso.dialogFormVisible" :title="'编辑条目' ">
    <el-form :model="elso.tableForm">
      <el-form-item label="设备类型" :label-width="100">
        <el-select
            v-model="elso.tableForm.type"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >
        </el-select>
      </el-form-item>
      <el-form-item label="数量" :label-width="100">
        <el-input-number v-model="elso.tableForm.quantity" :min="1" />
      </el-form-item>
      <el-form-item label="密级" :label-width="100">
        <el-radio-group v-model="elso.tableForm.secretLevel" size="large">
          <el-radio-button label="绝密" />
          <el-radio-button label="机密" />
          <el-radio-button label="秘密" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="移交部门" :label-width="100">
        <el-select
            v-model="elso.tableForm.sendDepartment"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >

        </el-select>
      </el-form-item>
      <el-form-item label="接收人" :label-width="100">
        <el-select
            v-model="elso.tableForm.recipient"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >

        </el-select>
      </el-form-item>
      <el-form-item label="移交人" :label-width="100">
        <el-select
            v-model="elso.tableForm.transferor"
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
              v-model="elso.tableForm.sendDate"
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
import {useElectronicOutsStore} from "@/store/electronicOutStore.js";
import {zhCn} from "element-plus/lib/locale/index";
const elso = useElectronicOutsStore()
const dialogConfirm = ()=>{
  elso.dialogFormVisible = false
  // 判断
  let index = elso.tableData.findIndex(item => item.id===elso.tableForm.id)
  // console.log(index)
  elso.tableData[index] = elso.tableForm
  elso.updateItem(elso.tableForm.id, elso.tableForm)

}
</script>

<style scoped>

</style>
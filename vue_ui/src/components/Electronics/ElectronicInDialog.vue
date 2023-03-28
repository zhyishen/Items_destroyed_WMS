<template>

  <div>
    <!-- input window -->
    <el-dialog v-model="els.dialogFormVisible" :title="'编辑条目' ">
      <el-form :model="els.tableForm">
        <el-form-item label="设备名称" :label-width="100">
          <el-input v-model="els.tableForm.equipmentName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="设备类型" :label-width="100">
          <el-select
              v-model="els.tableForm.type"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in elty.tableData"
                :key="item.id"
                :label="item.typeName"
                :value="item"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="数量" :label-width="100">
          <el-input-number v-model="els.tableForm.quantity" :min="1" />
        </el-form-item>
        <el-form-item label="密级" :label-width="100">
          <el-radio-group v-model="els.tableForm.secretLevel" size="large">
            <el-radio-button label="绝密" />
            <el-radio-button label="机密" />
            <el-radio-button label="秘密" />
          </el-radio-group>
        </el-form-item>
        <el-form-item label="移交单位" :label-width="100">
          <el-select
              v-model="els.tableForm.sendDepartment"
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
        <el-form-item label="使用人员" :label-width="100">
          <el-select
              v-model="els.tableForm.personOfUse"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in els.personOfUses"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="接收人" :label-width="100">
          <el-select
              v-model="els.tableForm.recipient"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in els.recipients"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="接收日期" :label-width="100">
          <el-config-provider :locale=zhCn>
            <el-date-picker
                v-model="els.tableForm.receiveDate"
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

import {onMounted, ref} from "vue";

  import {useElectronicStore} from "@/store/electronicInStore.js";
  import {zhCn} from "element-plus/lib/locale/index";
import {useDepartmentStore} from "@/store/departmentStore.js";
import {useElectronicTypeStore} from "@/store/electronicTypeStore.js";

  const els = useElectronicStore()
  const dep = useDepartmentStore()
  const elty = useElectronicTypeStore()
  const dialogConfirm = ()=>{
    els.dialogFormVisible = false
    // 判断
    let index = els.tableData.findIndex(item => item.id===els.tableForm.id)
    // console.log(index)
    els.tableData[index] = els.tableForm
    els.updateItem(els.tableForm.id, els.tableForm)

  }

  onMounted(()=>{
    els.getPersonOfUses()
    els.getRecipients()
    dep.getSendDepartments()
    elty.getItems()
  })

</script>

<style scoped>

</style>
<template>

  <div>
    <!-- input window -->
    <el-dialog v-model="els.dialogFormVisible" :title="els.dialogType=== 'add'? '新增条目' : '编辑条目' ">
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
                v-for="item in els.typeStrings"
                :key="item.value"
                :label="item.label"
                :value="item.value"
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
        <el-form-item label="移交部门" :label-width="100">
          <el-select
              v-model="els.tableForm.sendDepartment"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in els.sendDepartments"
                :key="item.value"
                :label="item.label"
                :value="item.value"
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
        <el-form-item label="移交人" :label-width="100">
          <el-select
              v-model="els.tableForm.transferor"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in els.transferors"
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

  import {useElectronicStore} from "@/store/electronicStore.js";
  import {zhCn} from "element-plus/lib/locale/index";

  const els = useElectronicStore()

  const dialogConfirm = ()=>{
    els.dialogFormVisible = false
    // 判断
    if(els.dialogType==='add'){
      // 拿到数据
      // 添加到table
      els.tableData.push({
        ...els.tableForm
      })
      els.addItem(els.tableForm)
    }else if(els.dialogType ==='edit'){
      let index = els.tableData.findIndex(item => item.id===els.tableForm.id)
      // console.log(index)
      els.tableData[index] = els.tableForm
      els.updateItem(els.tableForm.id, els.tableForm)
    }

  }

  onMounted(()=>{
    els.getTypes()
    els.getTransferors()
    els.getPersonOfUses()
    els.getRecipients()
    els.getSendDepartments()
  })

</script>

<style scoped>

</style>
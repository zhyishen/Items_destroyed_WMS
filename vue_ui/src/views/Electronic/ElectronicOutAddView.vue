<template>
  <div class="input-window">
    <div class="title">
      <h2>
        电子设备入库
      </h2>
    </div>
    <div>
      <!-- input window -->
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
            <el-option
                v-for="item in elso.recipients"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
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
        <el-form-item label="接收日期" :label-width="100">
          <el-config-provider :locale=zhCn>
            <el-date-picker
                v-model="elso.tableForm.sendDate"
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
  </div>

</template>

<script setup>
import {useElectronicOutsStore} from "@/store/electronicOutStore.js";
import {zhCn} from "element-plus/lib/locale/index";
import {onMounted} from "vue";
const elso = useElectronicOutsStore()
const dialogConfirm = ()=>{
  // 拿到数据
  // 添加到table
  elso.tableData.push({
    ...elso.tableForm
  })
  elso.addItem(elso.tableForm)
}
onMounted(()=>{
  elso.tableForm = []
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
<template>
  <div class="title">
    <h2>
      涉密文件入库
    </h2>
  </div>
  <div class = "input-window">
    <!-- input window -->
    <el-form :model="cfs.tableForm">
      <el-form-item label="文件编号" :label-width="100">
        <el-input v-model="cfs.tableForm.documentID" autocomplete="off" />
      </el-form-item>
      <el-form-item label="标题" :label-width="100">
        <el-input v-model="cfs.tableForm.title" autocomplete="off" />
      </el-form-item>
      <el-form-item label="数量" :label-width="100">
        <el-input-number v-model="cfs.tableForm.quantity" :min="1" />
      </el-form-item>
      <el-form-item label="密级" :label-width="100">
        <el-radio-group v-model="cfs.tableForm.secretLevel" size="large">
          <el-radio-button label="绝密" />
          <el-radio-button label="机密" />
          <el-radio-button label="秘密" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="移交单位" :label-width="100">
        <el-select
            v-model="cfs.tableForm.sendDepartment"
            filterable
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
      <el-form-item label="接收人" :label-width="100">
        <el-select
            v-model="cfs.tableForm.recipient"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="Choose tags for your article"
        >
          <el-option
              v-for="item in cfs.recipients"
              :key="item.value"
              :label="item.label"
              :value="item.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="接收日期" :label-width="100">
        <el-config-provider :locale=zhCn>
          <el-date-picker
              v-model="cfs.tableForm.receiveDate"
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
import {useConfidentialDocumentsStore} from "@/store/confidentialDocumentInStore.js";
import {zhCn} from "element-plus/lib/locale/index";
import {onMounted} from "vue";
import {useDepartmentStore} from "@/store/departmentStore.js";

const cfs = useConfidentialDocumentsStore()
const dep = useDepartmentStore()

const dialogConfirm = ()=>{

  // 拿到数据
  // 添加到table
  cfs.addItem(cfs.tableForm)
  cfs.getItems()
}

onMounted(()=>{
  cfs.tableForm={}
  cfs.getRecipients()
  dep.getSendDepartments()
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
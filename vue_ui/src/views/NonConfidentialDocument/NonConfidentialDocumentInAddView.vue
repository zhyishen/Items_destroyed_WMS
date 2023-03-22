<template>
  <div class="title">
    <h2>
      非涉密文件入库
    </h2>
  </div>
  <div class = "input-window">
    <!-- input window -->

      <el-form :model="nfs.tableForm">
        <el-form-item label="移交单位" :label-width="100" prop="department">
          <el-select
              v-model="nfs.tableForm.department"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in nfs.departments"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="内容" :label-width="100">
          <el-input v-model="nfs.tableForm.detail" autocomplete="off" />
        </el-form-item>
        <el-form-item label="数量" :label-width="100">
          <el-input-number v-model="nfs.tableForm.quantity" :min="1" />
        </el-form-item>
        <el-form-item label="移交人" :label-width="100">
          <el-select
              v-model="nfs.tableForm.transferor"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in nfs.transferors"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="接收人" :label-width="100">
          <el-select
              v-model="nfs.tableForm.recipient"
              filterable
              allow-create
              default-first-option
              :reserve-keyword="false"
              placeholder="Choose tags for your article"
          >
            <el-option
                v-for="item in nfs.recipients"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="接收日期" :label-width="100">
          <el-config-provider :locale=zhCn>
            <el-date-picker
                v-model="nfs.tableForm.receiveDate"
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
import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentInStore.js'
import {zhCn} from "element-plus/lib/locale/index";
import {onMounted} from "vue";
const nfs = useNonConfidentialDocumentsStore()

const rules= {

}

const dialogConfirm = ()=>{
    // 拿到数据
    // 添加到table
    nfs.tableData.push({
      ...nfs.tableForm
    })
    nfs.addItem(nfs.tableForm)
}

onMounted(()=>{
  nfs.tableForm={}
  nfs.getDepartments()
  nfs.getRecipients()
  nfs.getTransferors()
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
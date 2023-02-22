<template>

  <div>
    <!-- input window -->
    <el-dialog v-model="cfs.dialogFormVisible" :title="cfs.dialogType=== 'add'? '新增条目' : '编辑条目' ">
      <el-form :model="cfs.tableForm">
        <el-form-item label="文件编号" :label-width="100">
          <el-input v-model="cfs.tableForm.documentID" autocomplete="off" />
        </el-form-item>
        <el-form-item label="标题" :label-width="100">
          <el-input v-model="cfs.tableForm.title" autocomplete="off" />
        </el-form-item>
        <el-form-item label="数量" :label-width="100">
          <el-input v-model="cfs.tableForm.quantity" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密级" :label-width="100">
          <el-input v-model="cfs.tableForm.secretLevel" autocomplete="off" />
        </el-form-item>
        <el-form-item label="移交部门" :label-width="100">
          <el-input v-model="cfs.tableForm.sendDepartment" autocomplete="off" />
        </el-form-item>
        <el-form-item label="接收部门" :label-width="100">
          <el-input v-model="cfs.tableForm.receiveDepartment" autocomplete="off" />
        </el-form-item>
        <el-form-item label="接收人" :label-width="100">
          <el-input v-model="cfs.tableForm.recipient" autocomplete="off" />
        </el-form-item>
        <el-form-item label="移交人" :label-width="100">
          <el-input v-model="cfs.tableForm.transferor" autocomplete="off" />
        </el-form-item>
        <el-form-item label="接收日期" :label-width="100">
          <el-input v-model="cfs.tableForm.receiveDate" autocomplete="off" />
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

  import {useConfidentialDocumentsStore} from "@/store/confidentialDocumentStore.js";
  import axios from "axios";

  const cfs = useConfidentialDocumentsStore()

  const dialogConfirm = ()=>{
    cfs.dialogFormVisible = false
    // 判断
    if(cfs.dialogType==='add'){
      // 拿到数据
      // 添加到table
      cfs.tableData.push({
        ...cfs.tableForm
      })
      axios({
        url:"http://localhost:8080/ConfidentialDocuments",
        method:"post",
        data:cfs.tableForm
      }).then(res =>{
        console.log(res)
      })
    }else if(cfs.dialogType ==='edit'){
      let index = cfs.tableData.findIndex(item => item.id===cfs.tableForm.id)
      // console.log(index)
      cfs.tableData[index] = cfs.tableForm
    }


  }

</script>

<style scoped>

</style>
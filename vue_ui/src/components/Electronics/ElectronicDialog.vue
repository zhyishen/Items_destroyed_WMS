<template>

  <div>
    <!-- input window -->
    <el-dialog v-model="els.dialogFormVisible" :title="els.dialogType=== 'add'? '新增条目' : '编辑条目' ">
      <el-form :model="els.tableForm">
        <el-form-item label="设备名称" :label-width="100">
          <el-input v-model="els.tableForm.equipmentName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="设备类型" :label-width="100">
          <el-input v-model="els.tableForm.type" autocomplete="off" />
        </el-form-item>
        <el-form-item label="数量" :label-width="100">
          <el-input v-model="els.tableForm.quantity" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密级" :label-width="100">
          <el-input v-model="els.tableForm.secretLevel" autocomplete="off" />
        </el-form-item>
        <el-form-item label="移交部门" :label-width="100">
          <el-input v-model="els.tableForm.sendDepartment" autocomplete="off" />
        </el-form-item>
        <el-form-item label="使用人员" :label-width="100">
          <el-input v-model="els.tableForm.personOfUse" autocomplete="off" />
        </el-form-item>
        <el-form-item label="接收人" :label-width="100">
          <el-input v-model="els.tableForm.recipient" autocomplete="off" />
        </el-form-item>
        <el-form-item label="移交人" :label-width="100">
          <el-input v-model="els.tableForm.transferor" autocomplete="off" />
        </el-form-item>
        <el-form-item label="接收日期" :label-width="100">
          <el-input v-model="els.tableForm.receiveDate" autocomplete="off" />
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

  import {ref} from "vue";

  import {useElectronicStore} from "@/store/electronicStore.js";

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
    }else if(els.dialogType ==='edit'){
      let index = els.tableData.findIndex(item => item.id===els.tableForm.id)
      // console.log(index)
      els.tableData[index] = els.tableForm
    }


  }

</script>

<style scoped>

</style>
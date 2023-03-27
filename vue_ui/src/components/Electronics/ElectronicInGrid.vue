<template>

  <div class="table">
    <el-table
        ref="multipleTableRef"
        :data="els.tableData"
        style="width: 100%"
        border
        stripe
        @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="序号" width="150" />
      <el-table-column prop="equipmentName" label="设备名称" width="120" />
      <el-table-column prop="type" label="设备类型" width="120" />
      <el-table-column prop="quantity" label="数量" width="120" />
      <el-table-column prop="secretLevel" label="密级" width="120" />
      <el-table-column prop="sendDepartment.departmentName" label="移交单位" width="120" />
      <el-table-column prop="personOfUse" label="使用人" width="120" />
      <el-table-column prop="recipient" label="接收人" width="120" />
      <el-table-column prop="sendDepartment.contact" label="移交人" width="120" />
      <el-table-column prop="receiveDate" label="接收日期" width="120" />
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button link type="primary" size="small" @click="handleRowDel(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script setup>

  import {useElectronicStore} from "@/store/electronicInStore.js";
  import {storeToRefs} from "pinia";
  import {onMounted} from "vue";

  const els = useElectronicStore()

  const {tableData} = storeToRefs(els)
  const handleSelectionChange = (val) => {
    // multipleSelection = val
    // console.log(val);
    els.multipleSelection = []
    val.forEach(item=>{
      els.multipleSelection.push(item.id)
    })
    console.log(els.multipleSelection)
  }

  const handleEdit=(row)=>{
    els.dialogFormVisible = true;
    els.tableForm = {...row}

  }

  // 删除一条
  const handleRowDel = ({id}) =>{
    console.log(id)
    let index = els.tableData.findIndex(item =>item.id===id)
    console.log(index)
    els.tableData.splice(index,1)
    els.deleteItem(id)
  }

  onMounted(()=>{
    els.getItems()
  })
  

</script>

<style scoped>

</style>
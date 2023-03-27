<template>
  <div class="table">
    <el-table
        ref="multipleTableRef"
        :data="elso.tableData"
        style="width: 100%"
        border
        stripe
        @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="序号" width="150" />
      <el-table-column prop="type" label="设备类型" width="120" />
      <el-table-column prop="quantity" label="数量" width="120" />
      <el-table-column prop="secretLevel" label="密级" width="120" />
      <el-table-column prop="receiveDepartment.departmentName" label="接收单位" width="120" />
      <el-table-column prop="receiveDepartment.contact" label="接收人" width="120" />
      <el-table-column prop="transferor" label="移交人" width="120" />
      <el-table-column prop="sendDate" label="移交日期" width="120" />
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
import {useElectronicOutsStore} from "@/store/electronicOutStore.js";
import {storeToRefs} from "pinia";
import {onMounted} from "vue";

const elso = useElectronicOutsStore()
const {tableData} = storeToRefs(elso)
const handleSelectionChange = (val) => {
  elso.multipleSelection = []
  val.forEach(item=>{
    elso.multipleSelection.push(item.id)
  })
  console.log(elso.multipleSelection)
}

const handleEdit=(row)=>{
  elso.dialogFormVisible = true;
  elso.tableForm = {...row}

}

// 删除一条
const handleRowDel = ({id}) =>{
  console.log(id)
  let index = elso.tableData.findIndex(item =>item.id===id)
  console.log(index)
  elso.tableData.splice(index,1)
  elso.deleteItem(id)
}

onMounted(()=>{
  elso.getItems()
})
</script>

<style scoped>

</style>
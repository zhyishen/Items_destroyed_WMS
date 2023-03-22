<template>
  <div class="table">
    <el-table
        ref="multipleTableRef"
        :data="tableData"
        style="width: 100%"
        border
        stripe
        @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="序号" width="150" />
      <el-table-column prop="documentID" label="文件编号" width="120" />
      <el-table-column prop="quantity" label="数量（份）" width="120" />
      <el-table-column prop="secretLevel" label="密级" width="120" />
      <el-table-column prop="sendDepartment" label="移交单位" width="120" />
      <el-table-column prop="receiveDepartment" label="接收单位" width="120" />
      <el-table-column prop="recipient" label="接收人" width="120" />
      <el-table-column prop="transferor" label="移交人" width="120" />
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
import {useConfidentialDocumentOutsStore} from "@/store/confidentialDocumentOutStore.js";
import {storeToRefs} from "pinia";
import {onMounted} from "vue";

const cfso = useConfidentialDocumentOutsStore()
const {tableData} = storeToRefs(cfso)

const handleSelectionChange = (val) => {
  // multipleSelection = val
  // console.log(val);

  cfso.multipleSelection = []
  val.forEach(item=>{
    cfso.multipleSelection.push(item.id)
  })
  console.log(cfso.multipleSelection)
}

const handleEdit=(row)=>{
  cfso.dialogFormVisible = true;
  cfso.tableForm = {...row}

}

// 删除一条
const handleRowDel = ({id}) =>{

  cfso.deleteItem(id)
  console.log(id)
  let index = cfso.tableData.findIndex(item =>item.id===id)
  console.log(index)
  cfso.tableData.splice(index,1)
}

onMounted(()=>{
  cfso.getItems()
})
</script>

<style scoped>

</style>
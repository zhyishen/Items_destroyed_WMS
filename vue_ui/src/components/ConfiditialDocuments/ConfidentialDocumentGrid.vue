<template>

  <div class="table">
    <el-table
        ref="multipleTableRef"
        :data="cfs.tableData"
        style="width: 100%"
        border
        stripe
        @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="序号" width="150" />
      <el-table-column prop="documentID" label="文件编号" width="120" />
      <el-table-column prop="title" label="标题" width="120" />
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

  import {useConfidentialDocumentsStore} from "@/store/confidentialDocumentStore.js";

  const cfs = useConfidentialDocumentsStore()

  const handleSelectionChange = (val) => {
    // multipleSelection = val
    // console.log(val);
    cfs.multipleSelection = []
    val.forEach(item=>{
      cfs.multipleSelection.push(item.id)
    })
    console.log(cfs.multipleSelection)
  }

  const handleEdit=(row)=>{
    cfs.dialogFormVisible = true;
    cfs.dialogType = 'edit'
    cfs.tableForm = {...row}

  }

  // 删除一条
  const handleRowDel = ({id}) =>{
    console.log(id)
    let index = cfs.tableData.findIndex(item =>item.id===id)
    console.log(index)
    cfs.tableData.splice(index,1)
  }

</script>

<style scoped>

</style>
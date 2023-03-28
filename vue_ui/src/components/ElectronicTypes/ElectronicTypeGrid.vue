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
      <el-table-column prop="typeName" label="类型名称" width="120" />
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
import {onMounted} from "vue";
import {storeToRefs} from "pinia";
import {useElectronicTypeStore} from "@/store/electronicTypeStore.js";

const elty = useElectronicTypeStore()

const {tableData} = storeToRefs(elty)
const handleSelectionChange = (val) => {
  elty.multipleSelection = []
  val.forEach(item=>{
    elty.multipleSelection.push(item.id)
  })
  console.log(elty.multipleSelection)
}

const handleEdit=(row)=>{
  elty.dialogFormVisible = true;
  elty.tableForm = {...row}

}

// 删除一条
const handleRowDel = ({id}) =>{

  elty.deleteItem(id)
  console.log(id)
  let index = elty.tableData.findIndex(item =>item.id===id)
  console.log(index)
  elty.tableData.splice(index,1)
}

onMounted(()=>{
  elty.getItems()
})


</script>

<style scoped>

</style>
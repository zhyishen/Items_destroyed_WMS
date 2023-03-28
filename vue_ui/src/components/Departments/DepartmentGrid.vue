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
      <el-table-column prop="departmentId" label="序号" width="150" />
      <el-table-column prop="departmentName" label="部门名称" width="120" />
      <el-table-column prop="contact" label="联系人" width="120" />
      <el-table-column prop="type" label="部门类型" width="120" />
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
import {useDepartmentStore} from "@/store/departmentStore.js";
import {storeToRefs} from "pinia";

const dep = useDepartmentStore()

const {tableData} = storeToRefs(dep)
const handleSelectionChange = (val) => {
  // multipleSelection = val
  // console.log(val);

  dep.multipleSelection = []
  val.forEach(item=>{
    dep.multipleSelection.push(item.id)
  })
  console.log(dep.multipleSelection)
}

const handleEdit=(row)=>{
  dep.dialogFormVisible = true;
  dep.tableForm = {...row}

}

// 删除一条
const handleRowDel = ({id}) =>{

  dep.deleteItem(id)
  console.log(id)
  let index = dep.tableData.findIndex(item =>item.id===id)
  console.log(index)
  dep.tableData.splice(index,1)
}

onMounted(()=>{
  dep.getItems()
})


</script>

<style scoped>

</style>
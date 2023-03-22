<template>
  <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
  <div class="btn-list">
    <el-button type="danger" @click="handleDelList" v-if="elso.multipleSelection.length>0">批量删除</el-button>
  </div>
</template>

<script setup>
import {useElectronicOutsStore} from "@/store/electronicOutStore.js";

const elso = useElectronicOutsStore()
let queryInput = $ref("")
const handleDelList = () =>{
  elso.multipleSelection.forEach(id =>{
    handleRowDel({id})
  })
  elso.multipleSelection = []
}

const handleRowDel = ({id}) =>{
  console.log(id)
  let index = elso.tableData.findIndex(item =>item.id===id)
  console.log(index)
  elso.tableData.splice(index,1)
}

</script>

<style scoped>
.query-input{
  width:200px;
}

.el-input{
  width: 200px;
}
</style>
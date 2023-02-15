<template>

  <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
  <div class="btn-list">
    <el-button type="primary" @click="handleAdd">增加</el-button>
    <el-button type="danger" @click="handleDelList" v-if="els.multipleSelection.length>0">批量删除</el-button>
  </div>

</template>

<script setup>

  import {ref} from "vue";
  import {useElectronicStore} from "@/store/electronicStore.js";

  const els = useElectronicStore()

  let queryInput = $ref("")


  // 多选
  const handleDelList = () =>{
    els.multipleSelection.forEach(id =>{
      handleRowDel({id})
    })
    els.multipleSelection = []
  }

  // 新增
  const handleAdd = () =>{
    els.dialogFormVisible = true
    els.tableForm = {}
  }

  const handleRowDel = ({id}) =>{
    console.log(id)
    let index = els.tableData.findIndex(item =>item.id===id)
    console.log(index)
    els.tableData.splice(index,1)
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
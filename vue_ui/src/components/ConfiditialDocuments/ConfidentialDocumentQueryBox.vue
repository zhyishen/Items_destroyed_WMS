<template>

  <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
  <div class="btn-list">
    <el-button type="primary" @click="handleAdd">增加</el-button>
    <el-button type="danger" @click="handleDelList" v-if="cfs.multipleSelection.length>0">批量删除</el-button>
  </div>

</template>

<script setup>

  import {ref} from "vue";
  import {useConfidentialDocumentsStore} from "@/store/confidentialDocumentStore.js";

  const cfs = useConfidentialDocumentsStore()

  let queryInput = $ref("")


  // 多选
  const handleDelList = () =>{
    cfs.multipleSelection.forEach(id =>{
      handleRowDel({id})
    })
    cfs.multipleSelection = []
  }

  // 新增
  const handleAdd = () =>{
    cfs.dialogFormVisible = true
    cfs.tableForm = {}
  }

  const handleRowDel = ({id}) =>{
    console.log(id)
    let index = cfs.tableData.findIndex(item =>item.id===id)
    console.log(index)
    cfs.tableData.splice(index,1)
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
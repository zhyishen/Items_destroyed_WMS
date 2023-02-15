<template>
  <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
  <div class="btn-list">
    <el-button type="primary" @click="handleAdd">增加</el-button>
    <el-button type="danger" @click="handleDelList" v-if="nfs.multipleSelection.length>0">批量删除</el-button>
  </div>
</template>

<script setup>

  import {ref} from "vue";
  import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentStore.js'
  const nfs = useNonConfidentialDocumentsStore()

  // 数据   $无法监听
  let queryInput = $ref("")


  // 多选
  const handleDelList = () =>{
    nfs.multipleSelection.forEach(id =>{
      handleRowDel({id})
    })
    nfs.multipleSelection = []
  }

  // 新增
  const handleAdd = () =>{
    nfs.dialogFormVisible = true
    nfs.tableForm = {}
  }

  const handleRowDel = ({id}) =>{
    console.log(id)
    let index = nfs.tableData.findIndex(item =>item.id===id)
    console.log(index)
    nfs.tableData.splice(index,1)
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
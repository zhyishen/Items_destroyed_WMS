<template>
  <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
  <div class="btn-list">
    <el-button type="danger" @click="handleDelList" v-if="nfso.multipleSelection.length>0">批量删除</el-button>
  </div>
</template>

<script setup>
import {useNonConfidentialDocumentOutsStore} from "@/store/nonConfidentialDocumentOutStore.js";

const nfso = useNonConfidentialDocumentOutsStore()
let queryInput = $ref("")

const handleDelList = () =>{
  nfso.multipleSelection.forEach(id =>{
    handleRowDel({id})
  })
  nfso.multipleSelection = []
}



const handleRowDel = ({id}) =>{
  console.log(id)
  let index = nfso.tableData.findIndex(item =>item.id===id)
  console.log(index)
  nfso.tableData.splice(index,1)
}
</script>

<style scoped>

</style>
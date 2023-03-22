<template>
  <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
  <div class="btn-list">
    <el-button type="danger" @click="handleDelList" v-if="cfso.multipleSelection.length>0">批量删除</el-button>
  </div>
</template>

<script setup>
import {useConfidentialDocumentOutsStore} from "@/store/confidentialDocumentOutStore.js";
import {ref} from "vue";

const cfso = useConfidentialDocumentOutsStore()

const queryInput = ref("")

const handleDelList = () =>{
  cfso.multipleSelection.forEach(id =>{
    handleRowDel({id})
  })
  cfso.multipleSelection = []
}

const handleRowDel = ({id}) =>{
  console.log(id)
  let index = cfso.tableData.findIndex(item =>item.id===id)
  console.log(index)
  cfso.tableData.splice(index,1)
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
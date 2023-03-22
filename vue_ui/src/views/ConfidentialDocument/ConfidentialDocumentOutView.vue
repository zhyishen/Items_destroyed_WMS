<template>
  <div class="table-box">

    <div class="title">
      <h2>涉密文件</h2>
    </div>

    <div class="query-box">
      <ConfidentialDocumentOutQueryBox></ConfidentialDocumentOutQueryBox>

    </div>


    <div class="table">
      <ConfidentialDocumentOutGrid></ConfidentialDocumentOutGrid>


    </div>

    <div class="dialog">
      <ConfidentialDocumentOutDialog></ConfidentialDocumentOutDialog>

    </div>
  </div>
</template>

<script setup>

import ConfidentialDocumentOutQueryBox from "@/components/ConfiditialDocuments/ConfidentialDocumentOutQueryBox.vue";
import ConfidentialDocumentOutGrid from "@/components/ConfiditialDocuments/ConfidentialDocumentOutGrid.vue";
import ConfidentialDocumentOutDialog from "@/components/ConfiditialDocuments/ConfidentialDocumentOutDialog.vue";
</script>

<style scoped>
.table-box{
  width: 800px;
  margin: 200px auto;
}
.title{
  text-align: center;
}
.query-box{
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}
</style>
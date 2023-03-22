<template>
  <div class="table-box">
    <div class="title">
      <h2>非涉密文件</h2>
    </div>
    <!-- query -->
    <div class="query-box">

      <NonConfidentialDocumentOutQueryBox></NonConfidentialDocumentOutQueryBox>

    </div>


    <div class="table">

      <NonConfidentialDocumentOutGrid></NonConfidentialDocumentOutGrid>

    </div>

    <div class="dialog">

      <NonConfidentialDocumentOutDialog></NonConfidentialDocumentOutDialog>

    </div>



  </div>
</template>

<script setup>

import NonConfidentialDocumentOutQueryBox
  from "@/components/NonConfiditialDocuments/NonConfidentialDocumentOutQueryBox.vue";
import NonConfidentialDocumentOutGrid from "@/components/NonConfiditialDocuments/NonConfidentialDocumentOutGrid.vue";
import NonConfidentialDocumentOutDialog
  from "@/components/NonConfiditialDocuments/NonConfidentialDocumentOutDialog.vue";
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
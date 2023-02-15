<template>

  <div class="table-box">

    <div class="title">
      <h2>涉密文件</h2>
    </div>

    <div class="query-box">
      <ConfidentialDocumentQueryBox></ConfidentialDocumentQueryBox>

    </div>


    <div class="table">
      <ConfidentialDocumentGrid></ConfidentialDocumentGrid>


    </div>

    <div class="dialog">
      <ConfidentialDocumentDialog></ConfidentialDocumentDialog>

    </div>






  </div>


</template>

<script setup>

import ConfidentialDocumentDialog from "@/components/ConfiditialDocuments/ConfidentialDocumentDialog.vue";
import ConfidentialDocumentGrid from "@/components/ConfiditialDocuments/ConfidentialDocumentGrid.vue";
import ConfidentialDocumentQueryBox from "@/components/ConfiditialDocuments/ConfidentialDocumentQueryBox.vue";
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
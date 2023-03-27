<script setup>

import {ref} from "vue";
import NonConfidentialDocumentGrid from "@/components/NonConfiditialDocuments/NonConfidentialDocumentInGrid.vue";
import NonConfidentialDocumentDialog from "@/components/NonConfiditialDocuments/NonConfidentialDocumentInDialog.vue";
import NonConfidentialDocumentQueryBox from "@/components/NonConfiditialDocuments/NonConfidentialDocumentInQueryBox.vue";

// 方法

</script>

<template>
  <div class="table-box">
    <div class="title">
      <h2>非涉密文件</h2>
    </div>
    <!-- query -->
    <div class="query-box">

      <NonConfidentialDocumentQueryBox></NonConfidentialDocumentQueryBox>

    </div>


    <div class="table">

      <NonConfidentialDocumentGrid></NonConfidentialDocumentGrid>

    </div>

    <div class="dialog">

      <NonConfidentialDocumentDialog></NonConfidentialDocumentDialog>

    </div>



  </div>

</template>


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
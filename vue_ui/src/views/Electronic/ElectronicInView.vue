<template>

  <div class="table-box">

    <div class="title">
      <h2>电子设备</h2>
    </div>

    <div class="query-box">

      <ElectronicQueryBox></ElectronicQueryBox>

    </div>

    <div class="table">
      <ElectronicGrid></ElectronicGrid>

    </div>

    <div class="dialog">
      <ElectronicDialog></ElectronicDialog>

    </div>


  </div>

</template>

<script setup>

import ElectronicQueryBox from "@/components/Electronics/ElectronicInQueryBox.vue";
import ElectronicGrid from "@/components/Electronics/ElectronicInGrid.vue";
import ElectronicDialog from "@/components/Electronics/ElectronicInDialog.vue";
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
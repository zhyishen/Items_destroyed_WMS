<template>
  <div class="table-box">

    <div class="title">
      <h2>电子设备出库单</h2>
    </div>

    <div class="query-box">
      <ElectronicOutQueryBox></ElectronicOutQueryBox>
    </div>
    <div class="table">
      <ElectronicOutGrid></ElectronicOutGrid>
    </div>
    <div class="dialog">
      <ElectronicOutDialog></ElectronicOutDialog>
    </div>
  </div>
</template>

<script setup>

import ElectronicOutQueryBox from "@/components/Electronics/ElectronicOutQueryBox.vue";
import ElectronicOutGrid from "@/components/Electronics/ElectronicOutGrid.vue";
import ElectronicOutDialog from "@/components/Electronics/ElectronicOutDialog.vue";
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
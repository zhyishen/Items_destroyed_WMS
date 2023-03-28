<template>
  <div class="table-box">
    <div class="title">
      <h2>类型列表</h2>
    </div>

    <div class="query-box">

    </div>

    <div class="table-box">
      <ElectronicTypeGrid></ElectronicTypeGrid>

    </div>

    <div class = "el-dialog">
      <ElectronicTypeDialog></ElectronicTypeDialog>
    </div>

  </div>
</template>

<script setup>

import ElectronicTypeGrid from "@/components/ElectronicTypes/ElectronicTypeGrid.vue";
import ElectronicTypeDialog from "@/components/ElectronicTypes/ElectronicTypeDialog.vue";
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
<template>
  <div class="table-box">
    <div class="title">
      <h2>单位列表</h2>
    </div>

    <div class="query-box">

    </div>

    <div class="table-box">
      <DepartmentGrid></DepartmentGrid>

    </div>

    <div class = "el-dialog">
      <DepartmentDialog></DepartmentDialog>
    </div>

  </div>
</template>

<script setup>

import DepartmentDialog from "@/components/Departments/DepartmentDialog.vue";
import DepartmentGrid from "@/components/Departments/DepartmentGrid.vue";
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
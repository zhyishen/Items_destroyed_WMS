<script setup>

    import NonConfidentialDocumentView from "@/views/NonConfidentialDocumentView.vue";
    import ConfidentialDocumentView from "@/views/ConfidentialDocumentView.vue";
    import ElectronicView from "@/views/ElectronicView.vue";


    


    // 方法




</script>

<template>

  <div class="link">
    <router-link to="/getElectronics">电子设备</router-link>
    <router-link to="/getConfidentialDocuments">涉密文件</router-link>
    <router-link to="/getNonConfidentialDocuments">非涉密文件</router-link>
  </div>
  <router-view></router-view>
</template>


<style scoped>

</style>
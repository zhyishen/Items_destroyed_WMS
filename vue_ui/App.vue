<script setup>

    import {ref} from "vue";
    import NonConfiditialDocumentGrid from "@/components/NonConfiditialDocuments/NonConfidentialDocumentGrid.vue";
    import NonConfiditialDocumentDialog from "@/components/NonConfiditialDocuments/NonConfidentialDocumentDialog.vue";
    import NonConfiditialDocumentQueryBox from "@/components/NonConfiditialDocuments/NonConfidentialDocumentQueryBox.vue";

    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentStore'
    
    const nfs = useNonConfidentialDocumentsStore()


    


    // 方法




</script>

<template>
    <div class="table-box">
        <div class="title">
            <h2>非涉密文件</h2>
        </div>
        <!-- query -->
        <div class="query-box">

          <NonConfiditialDocumentQueryBox></NonConfiditialDocumentQueryBox>
            
        </div>


        <div class="table">

          <NonConfiditialDocumentGrid></NonConfiditialDocumentGrid>

        </div>

        <div class="dialog">

          <NonConfiditialDocumentDialog></NonConfiditialDocumentDialog>

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
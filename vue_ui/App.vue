<script setup>

    import {ref} from "vue";
    import NonConfiditialDocumentGrid from "@/components/NonConfiditialDocumentGrid.vue";
    import NonConfiditialDocumentDialog from "@/components/NonConfiditialDocumentDialog.vue";

    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentStore'
    
    const nfs = useNonConfidentialDocumentsStore()


    
    // 数据   $无法监听
    let queryInput = $ref("")

    // 方法

    


    // 多选  
    const handleDelList = () =>{
        nfs.multipleSelection.forEach(id =>{
            handleRowDel({id})
        })
        nfs.multipleSelection = []
    }

    // 新增
    const handleAdd = () =>{
        nfs.dialogFormVisible = true
        nfs.tableForm = {}
    }


</script>

<template>
    <div class="table-box">
        <div class="title">
            <h2>非涉密文件</h2>
        </div>
        <!-- query -->
        <div class="query-box">
            <el-input class="query-input" v-model="queryInput" placeholder="Please input" />
            <div class="btn-list">
                <el-button type="primary" @click="handleAdd">增加</el-button>
            <el-button type="danger" @click="handleDelList" v-if="nfs.multipleSelection.length>0">批量删除</el-button>
            </div>
            
        </div>

        <NonConfiditialDocumentGrid></NonConfiditialDocumentGrid>
        
        <NonConfiditialDocumentDialog></NonConfiditialDocumentDialog>
        
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
.el-input{
    width: 200px;
}
.query-input{
    width:200px;
}
</style>
<script setup>
    import {ref} from "vue";
    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentStore.js'
    const nfs = useNonConfidentialDocumentsStore()


    const dialogConfirm = ()=>{
        nfs.dialogFormVisible = false
        // 判断
        if(nfs.dialogType==='add'){
            // 拿到数据
            // 添加到table
            nfs.tableData.push({
            ...nfs.tableForm
            })
        }else if(nfs.dialogType ==='edit'){
            let index = nfs.tableData.findIndex(item => item.id===nfs.tableForm.id)
            // console.log(index)
            nfs.tableData[index] = nfs.tableForm
        }

        
    }



</script>

<template>
    <div>
            <!-- input window -->
            <el-dialog v-model="nfs.dialogFormVisible" :title="nfs.dialogType=== 'add'? '新增条目' : '编辑条目' ">
                <el-form :model="nfs.tableForm">
                    <el-form-item label="移交单位" :label-width="100">
                        <el-input v-model="nfs.tableForm.department" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="内容" :label-width="100">
                        <el-input v-model="nfs.tableForm.detail" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="数量" :label-width="100">
                        <el-input v-model="nfs.tableForm.quantity" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="移交人" :label-width="100">
                        <el-input v-model="nfs.tableForm.transferor" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="接收人" :label-width="100">
                        <el-input v-model="nfs.tableForm.recipient" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="接收日期" :label-width="100">
                        <el-input v-model="nfs.tableForm.receiveDate" autocomplete="off" />
                    </el-form-item>
                
                </el-form>
                <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="dialogConfirm">
                    确认
                    </el-button>
                </span>
                </template>
            </el-dialog>
        </div>

</template>


<style>



</style>
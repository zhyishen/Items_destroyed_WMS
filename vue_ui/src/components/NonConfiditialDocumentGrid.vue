<srcript setup>
    import {ref} from "vue";
    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocuments'  
    const nfs = useNonConfidentialDocumentsStore()
    defineEmits(['handleSelectionChange','handleEdit','handleRowDel'])

</srcript>

<template>

    <div class="table">
        <el-table 
            ref="multipleTableRef" 
            :data="nfs.tableData" 
            style="width: 100%" 
            border 
            stripe 
            @selection-change="$emit('handleSelectionChange')"
        >
            <el-table-column type="selection" width="55" />
            <el-table-column prop="id" label="序号" width="150" />
            <el-table-column prop="department" label="移交单位" width="120" />
            <el-table-column prop="detail" label="内容（明细）" width="120" />
            <el-table-column prop="quantity" label="数量（单位公斤）" width="120" />
            <el-table-column prop="transferor" label="移交人" width="120" />
            <el-table-column prop="recipient" label="接收人" width="120" />
            <el-table-column prop="receiveDate" label="接收日期" width="120" />
            <el-table-column fixed="right" label="操作" width="120">
                <template #default="scope">
                    <el-button link type="primary" size="small" @click="$emit('handleEdit',scope.row)">编辑</el-button>
                    <el-button link type="primary" size="small" @click="$emit('handleRowDel',scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>


</template>

<style>

</style>
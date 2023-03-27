<script setup>
import {onMounted, ref} from "vue";
    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentInStore.js'
    import {storeToRefs} from "pinia";
    const nfs = useNonConfidentialDocumentsStore()

    const {tableData} = storeToRefs(nfs)

    const handleSelectionChange = (val) => {
        // multipleSelection = val
        // console.log(val);
        nfs.multipleSelection = []
        val.forEach(item=>{
            nfs.multipleSelection.push(item.id)
        })
        console.log(nfs.multipleSelection)
    }

    const handleEdit=(row)=>{
        nfs.dialogFormVisible = true;
        nfs.tableForm = {...row}

    }

    // 删除一条
    const handleRowDel = ({id}) =>{
        console.log(id)
        let index = nfs.tableData.findIndex(item =>item.id===id)
        console.log(index)
        nfs.tableData.splice(index,1)
        nfs.deleteItem(id)
    }

    onMounted(()=>{
      nfs.getItems()
    })



</script>

<template>

    <div class="table">
        <el-table 
            ref="multipleTableRef" 
            :data="nfs.tableData" 
            style="width: 100%" 
            border 
            stripe 
            @selection-change="handleSelectionChange"
        >
            <el-table-column type="selection" width="55" />
            <el-table-column prop="id" label="序号" width="150" />
            <el-table-column prop="sendDepartment.departmentName" label="移交单位" width="120" />
            <el-table-column prop="detail" label="内容（明细）" width="120" />
            <el-table-column prop="quantity" label="数量（单位公斤）" width="120" />
            <el-table-column prop="sendDepartment.contact" label="移交人" width="120" />
            <el-table-column prop="recipient" label="接收人" width="120" />
            <el-table-column prop="receiveDate" label="接收日期" width="120" />
            <el-table-column fixed="right" label="操作" width="120">
                <template #default="scope">
                    <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
                    <el-button link type="primary" size="small" @click="handleRowDel(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>


</template>

<style>

</style>
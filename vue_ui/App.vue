<script setup>

    import {ref} from "vue";
    // import NonConfiditialDocumentGrid from './components/NonConfiditialDocumentGrid.vue'

    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocuments'
    
    const nfs = useNonConfidentialDocumentsStore()


    
    // 数据   $无法监听
    let queryInput = $ref("")
    let multipleSelection = $ref([])
    
    let dialogFormVisible = $ref(false)
    let tableForm = $ref({
        id:'',
        department:'',
        detail:'',
        quantity:'',
        transferor:'',
        recipient:'',
        receiveDate:''
    })
    let dialogType = $ref('add')

    // 方法

    // 删除一条
    const handleRowDel = ({id}) =>{
        console.log(id)
        let index = nfs.tableData.findIndex(item =>item.id===id)
        console.log(index)
        nfs.tableData.splice(index,1)
    }


    // 多选
    const handleSelectionChange = (val) => {
        // multipleSelection = val
        // console.log(val);
        multipleSelection = []
        val.forEach(item=>{
            multipleSelection.push(item.id)
        })
        console.log(multipleSelection)
    }
    
    const handleDelList = () =>{
        multipleSelection.forEach(id =>{
            handleRowDel({id})
        })
        multipleSelection = []
    }

    // 新增
    const handleAdd = () =>{
        dialogFormVisible = true
        tableForm = {}
    }

    // 确认
    const dialogConfirm = ()=>{
        dialogFormVisible = false
        // 判断
        if(dialogType==='add'){
            // 拿到数据
            // 添加到table
            nfs.tableData.push({
            ...tableForm
            })
        }else if(dialogType ==='edit'){
            let index = nfs.tableData.findIndex(item => item.id===tableForm.id)
            // console.log(index)
            nfs.tableData[index] = tableForm
        }

        
    }

    // 编辑
    const handleEdit=(row)=>{
        dialogFormVisible = true;
        dialogType = 'edit'
        tableForm = {...row}

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
            <el-button type="danger" @click="handleDelList" v-if="multipleSelection.length>0">批量删除</el-button>
            </div>
            
        </div>
        <!-- table -->
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
                <el-table-column prop="department" label="移交单位" width="120" />
                <el-table-column prop="detail" label="内容（明细）" width="120" />
                <el-table-column prop="quantity" label="数量（单位公斤）" width="120" />
                <el-table-column prop="transferor" label="移交人" width="120" />
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
        <div>
            <!-- input window -->
            <el-dialog v-model="dialogFormVisible" :title="dialogType=== 'add'? '新增条目' : '编辑条目' ">
                <el-form :model="tableForm">
                    <el-form-item label="移交单位" :label-width="100">
                        <el-input v-model="tableForm.department" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="内容" :label-width="100">
                        <el-input v-model="tableForm.detail" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="数量" :label-width="100">
                        <el-input v-model="tableForm.quantity" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="移交人" :label-width="100">
                        <el-input v-model="tableForm.transferor" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="接收人" :label-width="100">
                        <el-input v-model="tableForm.recipient" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="接收日期" :label-width="100">
                        <el-input v-model="tableForm.receiveDate" autocomplete="off" />
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
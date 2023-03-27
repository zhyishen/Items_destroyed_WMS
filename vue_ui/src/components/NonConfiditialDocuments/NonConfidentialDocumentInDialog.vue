<script setup>
    import {onMounted, ref} from "vue";
    import {useNonConfidentialDocumentsStore} from '@/store/nonConfidentialDocumentInStore.js'
    import {zhCn} from "element-plus/lib/locale/index";
    import {useDepartmentStore} from "@/store/departmentStore.js";


    const nfs = useNonConfidentialDocumentsStore()
    const dep = useDepartmentStore()
    const rules= {

    }

    const dialogConfirm = ()=>{
        nfs.dialogFormVisible = false
        // 判断
        let index = nfs.tableData.findIndex(item => item.id===nfs.tableForm.id)
        // console.log(index)
        nfs.tableData[index] = nfs.tableForm
        nfs.updateItem(nfs.tableForm.id,nfs.tableForm)
    }

    onMounted(()=>{
      nfs.getRecipients()
    })



</script>

<template>
    <div>
            <!-- input window -->
            <el-dialog v-model="nfs.dialogFormVisible" :title="'编辑条目' ">
                <el-form :model="nfs.tableForm">
                    <el-form-item label="移交单位" :label-width="100" prop="department">
                        <el-select
                            v-model="nfs.tableForm.department"
                            filterable
                            allow-create
                            default-first-option
                            :reserve-keyword="false"
                            placeholder="Choose tags for your article"
                        >
                            <el-option
                                v-for="item in dep.tableData"
                                :key="item.departmentID"
                                :label="item.departmentName"
                                :value="item"
                            />
                        </el-select>
                    </el-form-item>
                    <el-form-item label="内容" :label-width="100">
                        <el-input v-model="nfs.tableForm.detail" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="数量" :label-width="100">
                      <el-input-number v-model="nfs.tableForm.quantity" :min="1" />
                    </el-form-item>
                    <el-form-item label="接收人" :label-width="100">
                      <el-select
                          v-model="nfs.tableForm.recipient"
                          filterable
                          allow-create
                          default-first-option
                          :reserve-keyword="false"
                          placeholder="Choose tags for your article"
                      >
                        <el-option
                            v-for="item in nfs.recipients"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                    <el-form-item label="接收日期" :label-width="100">
                      <el-config-provider :locale=zhCn>
                        <el-date-picker
                            v-model="nfs.tableForm.receiveDate"
                            type="date"
                        />
                      </el-config-provider>
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
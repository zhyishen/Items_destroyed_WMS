import {defineStore} from 'pinia'
import { ref } from 'vue'
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";

export const useNonConfidentialDocumentsStore = defineStore('nonConfidentialDocuments',()=>{

    let dialogFormVisible = ref(false)


    let multipleSelection = ref([])

    let tableForm = ref({
        id:'',
        department:'',
        detail:'',
        quantity:'',
        transferor:'',
        recipient:'',
        receiveDate:''
    })

    let tableData = ref([])

    const departments = ref([])

    const recipients = ref([])

    const transferors = ref([])

    function getItems(){
        API.get("http://localhost:8080/NonConfidentialDocumentIns").then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
                this.tableData = data
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function addItem(data){
        API.post("http://localhost:8080/NonConfidentialDocumentIns", data).then(res =>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function deleteItem(id){
        API.delete("http://localhost:8080/NonConfidentialDocumentIns/"+id).then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function updateItem(id,data){
        API.put("http://localhost:8080/NonConfidentialDocumentIns/"+id,data).then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function getDepartments(){
        API.get("http://localhost:8080/NonConfidentialDocumentIns/departments").then(res=>{
            this.departments = res.data
        })
    }

    function getRecipients(){
        API.get("http://localhost:8080/NonConfidentialDocumentIns/recipients").then(res=>{
            this.recipients = res.data
        })
    }

    function getTransferors(){
        API.get("http://localhost:8080/NonConfidentialDocumentIns/transferors").then(res=>{
            this.transferors = res.data
        })
    }

    return {tableData ,
        dialogFormVisible,
        tableForm,
        multipleSelection,
        transferors,
        departments,
        recipients,
        getItems,
        addItem,
        updateItem,
        deleteItem,
        getTransferors,
        getRecipients,
        getDepartments,
    }
})
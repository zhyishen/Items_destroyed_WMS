import {defineStore} from 'pinia'
import { ref } from 'vue'
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";

export const useConfidentialDocumentsStore = defineStore('confidentialDocuments',()=>{

    let dialogFormVisible = ref(false)


    let multipleSelection = ref([])

    let tableForm = ref({
        id: '',
        documentID: '',
        title: '',
        quantity: '',
        secretLevel: '',
        sendDepartment: '',
        receiveDepartment: '',
        recipient: '',
        transferor: '',
        receiveDate: ''
    })

    let tableData = ref([])

    const sendDepartments = ref([])

    const receiveDepartments = ref([])

    const recipients = ref([])

    const transferors = ref([])

    function getItems(){
        API.get("http://localhost:8080/ConfidentialDocumentIns").then(res=>{
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
        API.post("http://localhost:8080/ConfidentialDocumentIns", data).then(res =>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function deleteItem(id){
        API.delete("http://localhost:8080/ConfidentialDocumentIns/"+id).then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function updateItem(id,data){
        API.put("http://localhost:8080/ConfidentialDocumentIns/"+id,data).then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function getTransferors(){
        API.get("http://localhost:8080/ConfidentialDocumentIns/transferors").then(res=>{
            this.transferors = res.data
        })
    }

    function getRecipients(){
        API.get("http://localhost:8080/ConfidentialDocumentIns/recipients").then(res=>{
            this.recipients = res.data
        })
    }

    function getSendDepartments(){
        API.get("http://localhost:8080/ConfidentialDocumentIns/sendDepartments").then(res=>{
            this.sendDepartments = res.data
        })
    }

    function getReceiveDepartments(){
        API.get("http://localhost:8080/ConfidentialDocumentIns/receiveDepartments").then(res=>{
            this.receiveDepartments = res.data
        })
    }

    return {tableData ,
        dialogFormVisible,
        dialogType,
        tableForm,
        multipleSelection,
        transferors,
        recipients,
        sendDepartments,
        receiveDepartments,
        getItems,
        addItem,
        deleteItem,
        updateItem,
        getRecipients,
        getTransferors,
        getReceiveDepartments,
        getSendDepartments
    }
})
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
        sendDepartment:{
            departmentID:'',
            departmentName:'',
            contact:'',
            type:''
        },
        recipient: '',
        receiveDate: ''
    })

    let tableData = ref([])

    const recipients = ref([])


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


    function getRecipients(){
        API.get("http://localhost:8080/ConfidentialDocumentIns/recipients").then(res=>{
            this.recipients = res.data
        })
    }


    return {tableData ,
        dialogFormVisible,
        tableForm,
        multipleSelection,
        recipients,
        getItems,
        addItem,
        deleteItem,
        updateItem,
        getRecipients,
    }
})
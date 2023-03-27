import {defineStore} from 'pinia'
import { ref } from 'vue'
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";

export const useNonConfidentialDocumentsStore = defineStore('nonConfidentialDocuments',{
    
    state:()=>({
        dialogFormVisible : false,

        multipleSelection : [],

        tableForm : {
            id:'',
            sendDepartment:{
                departmentID:'',
                departmentName:'',
                contact:'',
                type:''
            },
            detail:'',
            quantity:'',
            recipient:'',
            receiveDate:''
        },

        tableData : [],

        recipients : [],

    }),

    actions:{
        getItems(){
            API.get("http://localhost:8080/NonConfidentialDocumentIns").then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                    this.tableData = data
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        addItem(data){
            API.post("http://localhost:8080/NonConfidentialDocumentIns", data).then(res =>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        deleteItem(id){
            API.delete("http://localhost:8080/NonConfidentialDocumentIns/"+id).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        updateItem(id,data){
            API.put("http://localhost:8080/NonConfidentialDocumentIns/"+id,data).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        getRecipients(){
            API.get("http://localhost:8080/NonConfidentialDocumentIns/recipients").then(res=>{
                this.recipients = res.data
            })
        }
    }

})
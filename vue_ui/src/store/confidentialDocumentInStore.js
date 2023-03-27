import {defineStore} from 'pinia'
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";

export const useConfidentialDocumentsStore = defineStore('confidentialDocuments',{
    state:()=>({
        dialogFormVisible :false,


        multipleSelection :[],

        tableForm : {
            id: '',
            documentID: '',
            title: '',
            quantity: '',
            secretLevel: '',
            sendDepartment: {
                departmentID: '',
                departmentName: '',
                contact: '',
                type: ''
            },
            recipient: '',
            receiveDate: ''
        },

        tableData : [],

        recipients : [],
    }),

    actions:{
        getItems(){
            API.get("http://localhost:8080/ConfidentialDocumentIns").then(res=>{
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
            API.post("http://localhost:8080/ConfidentialDocumentIns", data).then(res =>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        deleteItem(id){
            API.delete("http://localhost:8080/ConfidentialDocumentIns/"+id).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        updateItem(id,data){
            API.put("http://localhost:8080/ConfidentialDocumentIns/"+id,data).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        getRecipients(){
            API.get("http://localhost:8080/ConfidentialDocumentIns/recipients").then(res=>{
                this.recipients = res.data
            })
        }
    }

})
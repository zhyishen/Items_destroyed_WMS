import {defineStore} from 'pinia'
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";

export const useConfidentialDocumentOutsStore = defineStore('confidentialDocumentOuts',{
    state:()=>({
        dialogFormVisible : false,
        multipleSelection :[],
        tableForm : {
            id:'',
            quantity: '',
            secretLevel: '',
            sendDepartment: '',
            receiveDepartment: '',
            recipient: '',
            transferor: '',
            sendDate: ''
        },
        tableData:[]
    }),

    actions:{
        getItems(){
            API.get("http://localhost:8080/ConfidentialDocumentOuts").then(res=>{
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
            API.post("http://localhost:8080/ConfidentialDocumentOuts", data).then(res =>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        deleteItem(id){
            API.delete("http://localhost:8080/ConfidentialDocumentOuts/"+id).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        updateItem(id,data){
            API.put("http://localhost:8080/ConfidentialDocumentOuts/"+id,data).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        }
    }
})
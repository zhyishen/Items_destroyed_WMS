import {defineStore} from "pinia";
import {ref} from "vue";
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";


export const useElectronicStore = defineStore('electronic',{
    
    state:()=>({
        dialogFormVisible : false,

        multipleSelection : [],

        tableForm : {
            id:'',
            equipmentName:'',
            type:'',
            quantity:'',
            recipient:'',
            receiveDate:'',
            secretLevel:'',
            sendDepartment:{
                departmentID:'',
                departmentName:'',
                contact:'',
                type:''
            },
            personOfUse:''
        },


        recipients : [],

        personOfUses : [],

        typeStrings : [],

        tableData : [],
    }),

    actions:{
        getItems(){
            API.get("http://localhost:8080/ElectronicIns").then(res=>{
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
            API.post("http://localhost:8080/ElectronicIns", data).then(res =>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        deleteItem(id){
            API.delete("http://localhost:8080/ElectronicIns/"+id).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        updateItem(id,data){
            API.put("http://localhost:8080/ElectronicIns/"+id,data).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        getTypes(){
            API.get("http://localhost:8080/ElectronicIns/types").then(res=>{
                this.typeStrings = res.data
            })
        },

        getRecipients(){
            API.get("http://localhost:8080/ElectronicIns/recipients").then(res=>{
                this.recipients = res.data
            })
        },

        getPersonOfUses(){
            API.get("http://localhost:8080/ElectronicIns/personOfUses").then(res=>{
                this.personOfUses = res.data
            })
        },
    }

})
import {defineStore} from "pinia";
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";

export const useElectronicTypeStore = defineStore('electronicType',{
    state:()=>({
        dialogFormVisible : false,
        multipleSelection :[],
        tableForm:{
            typeName:'',
        },
        tableData:[]
    }),
    actions:{
        getItems(){
            API.get("http://localhost:8080/ElectronicTypes").then(res=>{
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
            API.post("http://localhost:8080/ElectronicTypes", data).then(res =>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        deleteItem(id){
            API.delete("http://localhost:8080/ElectronicTypes/"+id).then(res=>{
                const {code, msg, data} = res.data
                if(code === 200){
                    ElMessage.success(msg)
                }else{
                    ElMessage.error(msg)
                }
            })
        },

        updateItem(id,data){
            API.put("http://localhost:8080/ElectronicTypes/"+id,data).then(res=>{
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


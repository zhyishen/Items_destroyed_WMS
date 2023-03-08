import {defineStore} from 'pinia'
import { ref } from 'vue'
import API from "@/plugin/axiosInstance.js";

export const useNonConfidentialDocumentsStore = defineStore('nonConfidentialDocuments',()=>{

    let dialogFormVisible = ref(false)

    let dialogType = ref('add')

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
        API.get("http://localhost:8080/NonConfidentialDocuments").then(res=>{
            this.tableData = res.data
        })
    }

    function addItem(data){
        API.post("http://localhost:8080/NonConfidentialDocuments", data).then(r =>{
            console.log(r)
        })
    }

    function deleteItem(id){
        API.delete("http://localhost:8080/NonConfidentialDocuments/"+id).then(res=>{
            console.log(res)
        })
    }

    function updateItem(id,data){
        API.put("http://localhost:8080/NonConfidentialDocuments/"+id,data).then(res=>{
            console.log(res)
        })
    }

    function getDepartments(){
        API.get("http://localhost:8080/NonConfidentialDocuments/departments").then(res=>{
            this.departments = res.data
        })
    }

    function getRecipients(){
        API.get("http://localhost:8080/NonConfidentialDocuments/recipients").then(res=>{
            this.recipients = res.data
        })
    }

    function getTransferors(){
        API.get("http://localhost:8080/NonConfidentialDocuments/transferors").then(res=>{
            this.transferors = res.data
        })
    }

    return {tableData ,
        dialogFormVisible,
        dialogType,
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
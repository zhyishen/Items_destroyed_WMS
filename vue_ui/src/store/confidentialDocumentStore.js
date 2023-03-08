import {defineStore} from 'pinia'
import { ref } from 'vue'
import API from "@/plugin/axiosInstance.js";

export const useConfidentialDocumentsStore = defineStore('confidentialDocuments',()=>{

    let dialogFormVisible = ref(false)

    let dialogType = ref('add')

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
        API.get("http://localhost:8080/ConfidentialDocuments").then(res=>{
            this.tableData = res.data
        })
    }

    function addItem(data){
        API.post("http://localhost:8080/ConfidentialDocuments", data).then(r =>{
            console.log(r)
        })
    }

    function deleteItem(id){
        API.delete("http://localhost:8080/ConfidentialDocuments/"+id).then(res=>{
            console.log(res)
        })
    }

    function updateItem(id,data){
        API.put("http://localhost:8080/ConfidentialDocuments/"+id,data).then(res=>{
            console.log(res)
        })
    }

    function getTransferors(){
        API.get("http://localhost:8080/ConfidentialDocuments/transferors").then(res=>{
            this.transferors = res.data
        })
    }

    function getRecipients(){
        API.get("http://localhost:8080/ConfidentialDocuments/recipients").then(res=>{
            this.recipients = res.data
        })
    }

    function getSendDepartments(){
        API.get("http://localhost:8080/ConfidentialDocuments/sendDepartments").then(res=>{
            this.sendDepartments = res.data
        })
    }

    function getReceiveDepartments(){
        API.get("http://localhost:8080/ConfidentialDocuments/receiveDepartments").then(res=>{
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
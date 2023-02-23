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
        API.delete("/ConfidentialDocuments/"+id).then(res=>{
            console.log(res)
        })
    }

    function updateItem(id,data){
        API.put("/ConfidentialDocuments/"+id,data).then(res=>{
            console.log(res)
        })
    }

    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, getItems, addItem, deleteItem, updateItem}
})
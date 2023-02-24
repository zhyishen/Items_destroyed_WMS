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
    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, getItems, addItem, updateItem, deleteItem}
})
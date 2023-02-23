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
        tableData = API.get("http://localhost:8080/ConfidentialDocuments")
    }

    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, getItems}
})
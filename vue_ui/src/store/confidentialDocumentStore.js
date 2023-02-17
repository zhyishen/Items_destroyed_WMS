import {defineStore} from 'pinia'
import {computed, ref} from 'vue'
import axios from "axios";
import {confidentialDocumentRequest} from "@/utils/confidentialDocumentRequest.js";


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

    let getTableData = computed(()=> tableData)

    async function fetchConfidentialDocumentsStore(){
        try{
            const data = await axios.get("http://localhost:8080/ConfidentialDocuments")
            console.log(data)
            this.tableData = data.data;
        }catch (error){
            alert(error)
            console.log(error)
        }
    }

    return {tableData , getTableData ,dialogFormVisible, dialogType, tableForm, multipleSelection, }
})
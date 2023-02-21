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


    async function fetchConfidentialDocumentsStore(){
        try{
            const data = await axios.get("http://localhost:8080/ConfidentialDocuments")
            this.tableData = data.data;
        }catch (error){
            alert(error)
            console.log(error)
        }
    }

    function deleteItem({id}){

    }

    function addItem(){

    }

    function editItem(){

    }

    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, }
})
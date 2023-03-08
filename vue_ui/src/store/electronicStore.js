import {defineStore} from "pinia";
import {ref} from "vue";
import API from "@/plugin/axiosInstance.js";


export const useElectronicStore = defineStore('electronic',()=>{

    let dialogFormVisible = ref(false)

    let dialogType = ref('add')

    let multipleSelection = ref([])

    let tableForm = ref({
        id:'',
        equipmentName:'',
        type:'',
        quantity:'',
        transferor:'',
        recipient:'',
        receiveDate:'',
        secretLevel:'',
        sendDepartment:'',
        personOfUse:''


    })

    const sendDepartments = ref([])

    const recipients = ref([])

    const transferors = ref([])

    const personOfUses = ref([])

    const typeStrings = ref([])

    let tableData = ref([])

    function getItems(){
        API.get("http://localhost:8080/Electronics").then(res=>{
            this.tableData = res.data
        })
    }

    function addItem(data){
        API.post("http://localhost:8080/Electronics", data).then(r =>{
            console.log(r)
        })
    }

    function deleteItem(id){
        API.delete("http://localhost:8080/Electronics/"+id).then(res=>{
            console.log(res)
        })
    }

    function updateItem(id,data){
        API.put("http://localhost:8080/Electronics/"+id,data).then(res=>{
            console.log(res)
        })
    }

    function getTypes(){
        API.get("http://localhost:8080/Electronics/types").then(res=>{
            this.typeStrings = res.data
        })
    }

    function getRecipients(){
        API.get("http://localhost:8080/Electronics/recipients").then(res=>{
            this.recipients = res.data
        })
    }

    function getTransferors(){
        API.get("http://localhost:8080/Electronics/transferors").then(res=>{
            this.transferors = res.data
        })
    }

    function getSendDepartments(){
        API.get("http://localhost:8080/Electronics/sendDepartments").then(res=>{
            this.sendDepartments = res.data
        })
    }

    function getPersonOfUses(){
        API.get("http://localhost:8080/Electronics/personOfUses").then(res=>{
            this.personOfUses = res.data
        })
    }


    return {tableData ,
        dialogFormVisible,
        dialogType,
        tableForm,
        multipleSelection,
        sendDepartments,
        recipients,
        transferors ,
        personOfUses,
        typeStrings,
        getItems,
        addItem,
        updateItem,
        deleteItem,
        getTypes,
        getTransferors,
        getSendDepartments,
        getRecipients,
        getPersonOfUses
    }
})
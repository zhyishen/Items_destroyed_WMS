import {defineStore} from "pinia";
import {ref} from "vue";
import API from "@/plugin/axiosInstance.js";
import {ElMessage} from "element-plus";


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
        API.get("http://localhost:8080/ElectronicIns").then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
                this.tableData = data
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function addItem(data){
        API.post("http://localhost:8080/ElectronicIns", data).then(res =>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function deleteItem(id){
        API.delete("http://localhost:8080/ElectronicIns/"+id).then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function updateItem(id,data){
        API.put("http://localhost:8080/ElectronicIns/"+id,data).then(res=>{
            const {code, msg, data} = res.data
            if(code === 200){
                ElMessage.success(msg)
            }else{
                ElMessage.error(msg)
            }
        })
    }

    function getTypes(){
        API.get("http://localhost:8080/ElectronicIns/types").then(res=>{
            this.typeStrings = res.data
        })
    }

    function getRecipients(){
        API.get("http://localhost:8080/ElectronicIns/recipients").then(res=>{
            this.recipients = res.data
        })
    }

    function getTransferors(){
        API.get("http://localhost:8080/ElectronicIns/transferors").then(res=>{
            this.transferors = res.data
        })
    }

    function getSendDepartments(){
        API.get("http://localhost:8080/ElectronicIns/sendDepartments").then(res=>{
            this.sendDepartments = res.data
        })
    }

    function getPersonOfUses(){
        API.get("http://localhost:8080/ElectronicIns/personOfUses").then(res=>{
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
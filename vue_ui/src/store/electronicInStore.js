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
        recipient:'',
        receiveDate:'',
        secretLevel:'',
        sendDepartment:{
            departmentID:'',
            departmentName:'',
            contact:'',
            type:''
        },
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
        personOfUses,
        typeStrings,
        getItems,
        addItem,
        updateItem,
        deleteItem,
        getTypes,
        getRecipients,
        getPersonOfUses
    }
})
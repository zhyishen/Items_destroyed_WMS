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

    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, getItems, addItem, updateItem, deleteItem}
})
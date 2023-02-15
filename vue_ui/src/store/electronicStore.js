import {defineStore} from "pinia";
import {ref} from "vue";


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

    let tableData = ref([{
        id: '2016-05-03',
        equipmentName: 'Tom',
        type: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Home',
        secretLevel:'aaa',
        sendDepartment:'aaa',
        personOfUse:'aaa'
    },
    {
        id: '2016-05-02',
        equipmentName: 'Tom',
        type: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Office',
        secretLevel:'aaa',
        sendDepartment:'aaa',
        personOfUse:'aaa'

    },
    {
        id: '2016-05-04',
        equipmentName: 'Tom',
        type: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Home',
        secretLevel:'111',
        sendDepartment:'aaa',
        personOfUse:'bbb'

    },
    {
        id: '2016-05-01',
        equipmentName: 'Tom',
        type: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Office',
        secretLevel:'222',
        sendDepartment:'ccc',
        personOfUse:'ddd'

    },])

    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, }
})
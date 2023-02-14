import {defineStore} from 'pinia'
import { ref } from 'vue'

export const useNonConfidentialDocumentsStore = defineStore('nonConfidentialDocuments',()=>{
    let tableData = ref([{
        id: '2016-05-03',
        department: 'Tom',
        detail: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Home',
    },
    {
        id: '2016-05-02',
        department: 'Tom',
        detail: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Office',
    },
    {
        id: '2016-05-04',
        department: 'Tom',
        detail: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Home',
    },
    {
        id: '2016-05-01',
        department: 'Tom',
        detail: 'California',
        quantity: 'Los Angeles',
        transferor: 'No. 189, Grove St, Los Angeles',
        recipient: 'CA 90036',
        receiveDate: 'Office',
    },])

    return {tableData}
})
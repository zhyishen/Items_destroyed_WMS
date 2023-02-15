import {defineStore} from 'pinia'
import { ref } from 'vue'

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

    let tableData = ref([{
            id: '2016-05-03',
            documentID: 'Tom',
            title: 'California',
            quantity: 'Los Angeles',
            secretLevel: 'No. 189, Grove St, Los Angeles',
            sendDepartment: 'CA 90036',
            receiveDepartment: 'Home',
            recipient: 'aaa',
            transferor: 'aa',
            receiveDate: 'aaa'
        },
        {
            id: '2016-05-02',
            documentID: 'Tom',
            title: 'California',
            quantity: 'Los Angeles',
            secretLevel: 'No. 189, Grove St, Los Angeles',
            sendDepartment: 'CA 90036',
            receiveDepartment: 'Home',
            recipient: 'aaa',
            transferor: 'aa',
            receiveDate: 'aaa'
        },
        ])

    return {tableData , dialogFormVisible, dialogType, tableForm, multipleSelection, }
})
import {defineStore} from "pinia";
import {ref} from "vue";

export const useUserStore = defineStore('user',()=>{
    const username = ref()

    const password = ref()

    const token = ref()

    const userForm = ref({
        uid:'',
        username:'',
        password:'',
        token:''
    })
})
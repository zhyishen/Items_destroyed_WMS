import {defineStore} from "pinia";
import {computed, ref} from "vue";

export const useUserStore = defineStore('user',{

    state:()=>({
        userForm: {
            uid: '',
            username: '',
            password: '',
            token: ''
        },
    }),

    getters:{
        canSubmit(state){
            return Boolean(state.userForm.username&&state.userForm.password)
        }


    },

    actions:{

    }
})
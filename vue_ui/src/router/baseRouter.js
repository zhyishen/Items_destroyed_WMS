import {createRouter, createWebHistory} from "vue-router";
import ConfidentialDocumentView from "@/views/ConfidentialDocumentView.vue";
import ElectronicView from "@/views/ElectronicView.vue";
import NonConfidentialDocumentView from "@/views/NonConfidentialDocumentView.vue";
import Login from "@/views/Login.vue";


const routes = [
    {
        path:"/",
        name:"Login",
        component: Login
    },
    {
        path:"/getConfidentialDocuments",
        name:"ConfidentialDocuments",
        component:ConfidentialDocumentView
    },
    {
        path:"/getElectronics",
        name:"Electronics",
        component:ElectronicView
    },
    {
        path:"/getNonConfidentialDocuments",
        name:"NonConfidentialDocuments",
        component:NonConfidentialDocumentView
    }
]




const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from, next)=>{
    const token = localStorage.getItem('token')
    if(to.name !== 'Login' && !token) next({name: 'Login'})
    else next()
})

export default router
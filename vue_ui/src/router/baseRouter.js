import {createRouter, createWebHistory} from "vue-router";
import ConfidentialDocumentView from "@/views/ConfidentialDocumentView.vue";
import ElectronicView from "@/views/ElectronicView.vue";
import NonConfidentialDocumentView from "@/views/NonConfidentialDocumentView.vue";
import Login from "@/views/Login.vue";
import RootView from "@/views/RootView.vue";
import ConfidentialInView from "@/views/ConfidentialDocumentInView.vue";
import NonConfidentialDocumentInView from "@/views/NonConfidentialDocumentInView.vue";
import ElectronicInView from "@/views/ElectronicInView.vue";


const routes = [
    {
        path:"/login",
        name:"Login",
        component: Login
    },
    {
        path:"/",
        name:"BottomLine",
        component: RootView,
        children:[
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
            },
            {
                path:"/inputConfidentialDocuments",
                name:"ConfidentialDocumentsIn",
                component: ConfidentialInView
            },
            {
                path: "/inputNonConfidentialDocuments",
                name: "NonConfidentialDocumentsIn",
                component: NonConfidentialDocumentInView
            },
            {
                path: "/inputElectronics",
                name: "ElectronicsIn",
                component: ElectronicInView
            }
        ],
    },

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
import {createRouter, createWebHistory} from "vue-router";
import ConfidentialDocumentView from "@/views/ConfidentialDocument/ConfidentialDocumentInView.vue";
import ElectronicView from "@/views/Electronic/ElectronicInView.vue";
import NonConfidentialDocumentView from "@/views/NonConfidentialDocument/NonConfidentialDocumentInView.vue";
import Login from "@/views/Login.vue";
import RootView from "@/views/RootView.vue";
import ConfidentialInView from "@/views/ConfidentialDocument/ConfidentialDocumentInAddView.vue";
import NonConfidentialDocumentInView from "@/views/NonConfidentialDocument/NonConfidentialDocumentInAddView.vue";
import ElectronicInView from "@/views/Electronic/ElectronicInAddView.vue";


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
import {createRouter, createWebHistory} from "vue-router";
import ConfidentialDocumentView from "@/views/ConfidentialDocumentView.vue";
import ElectronicView from "@/views/ElectronicView.vue";
import NonConfidentialDocumentView from "@/views/NonConfidentialDocumentView.vue";
import Login from "@/views/Login.vue";


const routes = [
    {
        path:"/",
        component: Login
    },
    {
        path:"/getConfidentialDocuments",
        component:ConfidentialDocumentView
    },
    {
        path:"/getElectronics",
        component:ElectronicView
    },
    {
        path:"/getNonConfidentialDocuments",
        component:NonConfidentialDocumentView
    }
]



const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
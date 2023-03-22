import {createRouter, createWebHistory} from "vue-router";
import ConfidentialDocumentView from "@/views/ConfidentialDocument/ConfidentialDocumentInView.vue";
import ElectronicView from "@/views/Electronic/ElectronicInView.vue";
import NonConfidentialDocumentView from "@/views/NonConfidentialDocument/NonConfidentialDocumentInView.vue";
import Login from "@/views/Login.vue";
import RootView from "@/views/RootView.vue";
import ConfidentialInView from "@/views/ConfidentialDocument/ConfidentialDocumentInAddView.vue";
import NonConfidentialDocumentInView from "@/views/NonConfidentialDocument/NonConfidentialDocumentInAddView.vue";
import ElectronicInView from "@/views/Electronic/ElectronicInAddView.vue";
import ElectronicOutView from "@/views/Electronic/ElectronicOutView.vue";
import ElectronicOutAddView from "@/views/Electronic/ElectronicOutAddView.vue";
import ConfidentialDocumentOutView from "@/views/ConfidentialDocument/ConfidentialDocumentOutView.vue";
import ConfidentialDocumentOutAddView from "@/views/ConfidentialDocument/ConfidentialDocumentOutAddView.vue";
import NonConfidentialDocumentOutView from "@/views/NonConfidentialDocument/NonConfidentialDocumentOutView.vue";
import NonConfidentialDocumentOutAddView from "@/views/NonConfidentialDocument/NonConfidentialDocumentOutAddView.vue";


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
                path:"/getConfidentialDocumentIns",
                name:"GetConfidentialDocumentIns",
                component:ConfidentialDocumentView
            },
            {
                path:"/getElectronicIns",
                name:"GetElectronicIns",
                component:ElectronicView
            },
            {
                path:"/getNonConfidentialDocumentIns",
                name:"GetNonConfidentialDocumentIns",
                component:NonConfidentialDocumentView
            },
            {
                path:"/addConfidentialDocumentIns",
                name:"AddConfidentialDocumentsIn",
                component: ConfidentialInView
            },
            {
                path: "/addNonConfidentialDocumentIns",
                name: "AddNonConfidentialDocumentsIn",
                component: NonConfidentialDocumentInView
            },
            {
                path: "/addElectronicIns",
                name: "AddElectronicsIn",
                component: ElectronicInView
            },
            {
                path: "/getElectronicOuts",
                name:"GetElectronicOuts",
                component: ElectronicOutView
            },
            {
                path:"/addElectronicOuts",
                name: "AddElectronicOuts",
                component: ElectronicOutAddView,
            },
            {
                path:"/getConfidentialDocumentOuts",
                name:"GetConfidentialDocumentOuts",
                component: ConfidentialDocumentOutView,
            },
            {
                path: "/addConfidentialDocumentOuts",
                name: "AddConfidentialDocumentOuts",
                component: ConfidentialDocumentOutAddView
            },
            {
                path: "/getNonConfidentialDocumentOuts",
                name: "GetNonConfidentialDocumentOuts",
                component: NonConfidentialDocumentOutView,
            },
            {
                path: "/addNonConfidentialDocumentOuts",
                name: "AddNonConfidentialDocumentOuts",
                component: NonConfidentialDocumentOutAddView,
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
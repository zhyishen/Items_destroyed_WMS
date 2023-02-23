import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import {createPinia} from 'pinia'
import axios from './src/plugin/axiosInstance.js'
import router from "@/router/baseRouter.js";
const app = createApp(App)

app.use(ElementPlus)
app.use(router)
app.use(createPinia())

app.mount('#app')
app.config.globalProperties.$axios=axios;  

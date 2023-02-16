import axios from "axios";
import {ElMessage} from "element-plus";

const service = axios.create({
    baseURL:"http://localhost:8080/ConfidentialDocuments",
    timeout:8000
})


service.interceptors.response.use(res=>{
    const {code, data, msg} = res.data

    if(code === 200){
        ElMessage.success(msg)
        return data
    }

    console.log(res)
})


function request(options){
    options.method = options.method || 'get'

    if(options.method.toLowerCase() === 'get')options.params = options.data

    return service(options)
}

['get','post','put','delete'].forEach(item =>{
    request[item] = (url,data) =>{
        return request({
            url,
            data,
            method:item
        })
    }
})
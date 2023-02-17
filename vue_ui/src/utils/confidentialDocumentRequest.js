import axios from "axios";
import {ElMessage} from "element-plus";

export function confidentialDocumentRequest(config){
    let newVar = axios.create({
        baseURL:"localhost:8080/ConfidentialDocuments",
        timeout:5000
    });
    return newVar(config);
}


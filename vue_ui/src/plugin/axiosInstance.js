
import axios from 'axios'
const API = axios.create({
	baseUrl:'http://localhost:8080',
	timeout: 2000                
})



export default API

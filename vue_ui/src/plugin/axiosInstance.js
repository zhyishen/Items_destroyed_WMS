
import axios from 'axios'
const API = axios.create({
	baseUrl:'https://localhost:8080',
	timeout: 2000                
})


export default API

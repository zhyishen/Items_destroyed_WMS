import { defineConfig } from "vite"
import vue from '@vitejs/plugin-vue'
import path from 'path';

export default defineConfig({
    plugins:[
        vue({
            /* 开启 $ref, vue3.2语法糖 */
            refTransform: true,
            reactivityTransform:true
        })
    ],

    server:{
        proxy:{
            target: "http://localhost:8080",

        }
    },


    resolve:{
        alias:{
            '@': path.resolve(__dirname, "src"),
        }
    }
})
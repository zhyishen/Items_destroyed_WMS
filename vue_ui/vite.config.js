import { defineConfig } from "vite";

import vue from '@vitejs/plugin-vue'

export default defineConfig({
    plugins:[
        vue({
            /* 开启 $ref, vue3.2语法糖 */
            refTransform: true,
            reactivityTransform:true
        })
    ],

    // server:{

    // },


    base:'./',
})
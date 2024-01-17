import '@/styles/index.scss'
import 'element-plus/dist/index.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import SvgIcon from '@/assets/icons'
// import 'virtual:svg-icons-register'

const app = createApp(App)
SvgIcon(app)

app.use(createPinia()).use(router)

app.mount('#app')

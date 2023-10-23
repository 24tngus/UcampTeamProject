import { createApp } from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Reserve from "@/pages/Reserve.vue";
import Store from "@/pages/Store.vue";

const routes = [
    {path:'/', component: Home},
    {path: '/login', component: Login},
    {path: '/store', component: Store},
    {path: '/reserve', component: Reserve}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App).use(router).mount('#app')

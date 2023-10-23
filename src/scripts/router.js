import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Reserve from "@/pages/Reserve.vue";
import Store from "@/pages/Store.vue";
import Mypage from "@/pages/Mypage.vue";
import {createRouter, createWebHistory} from 'vue-router'

const routes = [
    {path:'/', component: Home},
    {path: '/login', component: Login},
    {path: '/store', component: Store},
    {path: '/reserve', component: Reserve},
    {path: '/mypage', component: Mypage}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Reserve from "@/pages/Reserve.vue";
import Store from "@/pages/Store.vue";
import Mypage from "@/pages/Mypage.vue";
import Cart from "@/components/Cart.vue";

const routes = [
    {path:'/', component: Home},
    {path: '/login', component: Login},
    {path: '/store', component: Store},
    {path: '/reserve', component: Reserve},
    {path: '/mypage', component: Mypage},
    {path: '/cart', component: Cart}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
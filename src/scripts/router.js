import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Shop from "@/pages/Shop.vue";
import Reserve from "@/components/Reserve.vue";
import Mypage from "@/components/Mypage.vue";
import Cart from "@/components/Cart.vue";
import Menu from "@/components/Menu.vue";
import MypageInfo from "@/components/MypageInfo.vue";
import Join from "@/pages/Join.vue";
import MypageUpdate from "@/components/MypageUpdate.vue";

const routes = [
    {path:'/', component: Home},
    {path: '/login', component: Login},
    {path: '/join', component: Join},
    {path: '/shop', component: Shop},
    {path: '/reserve', component: Reserve},
    {path: '/mypage', component: Mypage},
    {path: '/mypageinfo', component: MypageInfo},
    {path: '/mypageupdate', component: MypageUpdate},
    {path: '/cart', component: Cart},
    {path: '/menu', component: Menu},
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Shop from "@/pages/Shop.vue";
import Store from "@/pages/Store.vue";
import Reserve from "@/components/reserve/Reserve.vue";
import Mypage from "@/components/mypage/Mypage.vue";
import Cart from "@/components/Cart.vue";
import Menu from "@/components/Menu.vue";
import MypageInfo from "@/components/mypage/MypageInfo.vue";
import Join from "@/pages/Join.vue";
import MypageUpdate from "@/components/mypage/MypageUpdate.vue";
import Vegan from "@/components/veganInfo/Vegan.vue";
import Faq from "@/components/Faq.vue";
import Vegan2 from "@/components/veganInfo/Vegan2.vue";
import ReserveInsert from "@/components/reserve/ReserveInsert.vue";
import ReserveUpdate from "@/components/reserve/ReserveUpdate.vue";
import ReserveUser from "@/components/reserve/ReserveUser.vue";
import Korean from "@/components/foodCategory/Korean.vue";
import Fusion from "@/components/foodCategory/Fusion.vue";
import Western from "@/components/foodCategory/Western.vue";
import User from "@/pages/User.vue";
import Login2 from "@/pages/Login2.vue";

const routes = [
    {path:'/', component: Home},
    {path: '/user', component: User},
    {path: '/login', component: Login},
    {path: '/login2', component: Login2},
    {path: '/join', component: Join},
    {path: '/shop', component: Shop},
    {path: '/store', component: Store},
    {path: '/reserve', component: Reserve},
    {path: '/reserve_insert', component: ReserveInsert},
    {path: '/reserve_update', component: ReserveUpdate},
    {path: '/reserve_user', component: ReserveUser},
    {path: '/mypage', component: Mypage},
    {path: '/mypage_info', component: MypageInfo},
    {path: '/mypage_update', component: MypageUpdate},
    {path: '/cart', component: Cart},
    {path: '/menu', component: Menu},
    {path: '/vegan', component: Vegan},
    {path: '/vegan2', component: Vegan2},
    {path: '/faq', component: Faq},
    {path: '/foodCategory/Korean', component: Korean},
    {path: '/foodCategory/Western', component: Western},
    {path: '/foodCategory/Fusion', component: Fusion}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
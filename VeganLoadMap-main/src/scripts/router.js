import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Home_Store from "@/pages/HomeStore.vue";
import Login from "@/components/user/Login.vue";
import Shop from "@/pages/Shop.vue";
import Store from "@/pages/HomeStore.vue";
import Reserve from "@/components/reserve/Reserve.vue";
import Mypage from "@/components/user/Mypage.vue";
import Cart from "@/components/user/Cart.vue";
import Menu from "@/components/Menu.vue";
import MypageInfo from "@/components/user/MypageInfo.vue";
import Join from "@/components/user/Join.vue";
import Join2 from "@/components/store/Join2.vue";
import MypageUpdate from "@/components/user/MypageUpdate.vue";
import Faq from "@/components/Faq.vue";
import ReserveInsert from "@/components/reserve/ReserveInsert.vue";
import ReserveUpdate from "@/components/reserve/ReserveUpdate.vue";
import ReserveUser from "@/components/reserve/ReserveUser.vue";
import Korean from "@/components/foodCategory/Korean.vue";
import Fusion from "@/components/foodCategory/Fusion.vue";
import Western from "@/components/foodCategory/Western.vue";
import User from "@/pages/User.vue";
import Login2 from "@/components/store/Login2.vue";
import ShopInsert from "@/components/shop/ShopInsert.vue";
import Mystore from "@/components/store/Mystore.vue";
import MystoreInfo from "@/components/store/MystoreInfo.vue";
import MystoreUpdate from "@/components/store/MystoreUpdate.vue";
import MyshopUpdate from "@/components/shop/MyshopUpdate.vue";
import MyshopInfo from "@/components/shop/MyshopInfo.vue";
import ReviewStore from "@/components/review/ReviewStore.vue";
import ErrorPage from "@/components/ErrorPage.vue";
import ReviewUpdate from "@/components/review/ReviewUpdate.vue";
import Review from "@/components/review/Review.vue";
import test from "@/pages/test.vue"
import Vegan1 from "@/components/veganInfo/Vegan1.vue";
import Vegan2 from "@/components/veganInfo/Vegan2.vue";
import Vegan3 from "@/components/veganInfo/Vegan3.vue";
import Vegan4 from "@/components/veganInfo/Vegan4.vue";
import ReviewInsert from "@/components/review/ReviewInsert.vue";
import MyReview from "@/components/review/MyReview.vue";
import ReserveStore from "@/components/reserve/ReserveStore.vue";
import ReserveStoreDetail from "@/components/reserve/ReserveStoreDetail.vue";
import ReserveUserCheck from "@/components/reserve/ReserveUserCheck.vue";

const routes = [
    {path:'/', component: Home},
    {path:'/home_store', component: Home_Store},
    {path: '/user', component: User},
    {path: '/login', component: Login},
    {path: '/login2', component: Login2},
    {path: '/join', component: Join},
    {path: '/join2', component: Join2},
    {path: '/shop', component: Shop},
    {path: '/shop_insert', component: ShopInsert},
    {path: '/store', component: Store},
    {path: '/mystore', component: Mystore},
    {path: '/mystore_info', component: MystoreInfo},
    {path: '/mystore_update', component: MystoreUpdate},
    {path: '/myshop_info', component: MyshopInfo},
    {path: '/myshop_update/:value', name: "myshop_update", component: MyshopUpdate},
    {path: '/reserve', component: Reserve},
    {path: '/reserve_insert', component: ReserveInsert},
    {path: '/reserve_update', component: ReserveUpdate},
    {path: '/reserve_store', component: ReserveStore},
    {path: '/reserve_storedetail/:value', name: "reserve_storedetail", component: ReserveStoreDetail},
    {path: '/reserve_user', component: ReserveUser},
    {path: '/reserve_usercheck', component: ReserveUserCheck},
    {path: '/mypage', component: Mypage},
    {path: '/mypage_info', component: MypageInfo},
    {path: '/mypage_update', component: MypageUpdate},
    {path: '/cart', component: Cart},
    {path: '/menu', name:"menu", component: Menu},
    {path: '/vegan1', component: Vegan1},
    {path: '/vegan2', component: Vegan2},
    {path: '/vegan3', component: Vegan3},
    {path: '/vegan4', component: Vegan4},
    {path: '/faq', component: Faq},
    {path: '/foodCategory/Korean', component: Korean},
    {path: '/foodCategory/Western', component: Western},
    {path: '/foodCategory/Fusion', component: Fusion},
    {path: '/review', component: Review},
    {path: '/myreview', component: MyReview},
    {path: '/review_insert/:value', name: "review_insert", component: ReviewInsert },
    {path: '/review_update/:value',name:"review_update", component: ReviewUpdate},
    {path: '/review_store', component: ReviewStore},
    {path: '/test', component: test},
    {path: '/error',component: ErrorPage},
    {path: '/:pathMatch(.*)*',redirect: '/error'},
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;
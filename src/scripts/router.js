import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Home_Store from "@/pages/HomeStore.vue";
import Login from "@/components/user/Login.vue";
import Shop from "@/pages/Shop.vue";
import Store from "@/pages/HomeStore.vue";
import Reserve from "@/components/user/Reserve.vue";
import Mypage from "@/components/user/Mypage.vue";
import Cart from "@/components/user/Cart.vue";
import Menu from "@/components/Menu.vue";
import MypageInfo from "@/components/user/MypageInfo.vue";
import Join from "@/components/user/Join.vue";
import Join2 from "@/components/store/Join2.vue";
import MypageUpdate from "@/components/user/MypageUpdate.vue";
import Faq from "@/components/Faq.vue";
import Vegan2 from "@/components/veganInfo/Vegan2.vue";
import ReserveInsert from "@/components/store/ReserveInsert.vue";
import ReserveUpdate from "@/components/store/ReserveUpdate.vue";
import ReserveUser from "@/components/user/ReserveUser.vue";
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
import ReviewStore from "@/components/store/ReviewStore.vue";
import ErrorPage from "@/components/ErrorPage.vue";
import ReviewUpdate from "@/components/user/ReviewUpdate.vue";
import Review from "@/components/shop/Review.vue";
import test from "@/pages/test.vue"
import Vegan3 from "@/components/veganInfo/Vegan3.vue";
import Vegan4 from "@/components/veganInfo/Vegan4.vue";
import MyReview from "@/components/user/MyReview.vue";
import ReviewInsert from "@/components/user/ReviewInsert.vue";
import ReserveUserCheck from "@/components/user/ReserveUserCheck.vue";
import ReserveStoreDetail from "@/components/store/ReserveStoreDetail.vue";
import ReserveStore from "@/components/store/ReserveStore.vue";
import Vegan1 from "@/components/veganInfo/Vegan1.vue";
import ShopInsert2 from "@/components/shop/ShopInsert2.vue";
import ReserveSetting from "@/components/store/ReserveSetting.vue";
import MenuInsert from "@/components/shop/MenuInsert.vue";
import MenuInsert2 from "@/components/shop/MenuInsert2.vue";

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
    {path: '/shop_insert2', component: ShopInsert2},
    {path: '/store', component: Store},
    {path: '/mystore', component: Mystore},
    {path: '/mystore_info', component: MystoreInfo},
    {path: '/mystore_update', component: MystoreUpdate},
    {path: '/myshop_info', component: MyshopInfo},
    {path: '/myshop_update/:value', name: "myshop_update", component: MyshopUpdate},
    {path: '/reserve', component: Reserve},
    {path: '/reserve_insert', component: ReserveInsert},
    {path: '/reserve_update', component: ReserveUpdate},
    {path: '/reserve_setting', component: ReserveSetting},
    {path: '/reserve_store', component: ReserveStore},
    {path: '/reserve_storedetail/:value', name: "reserve_storedetail", component: ReserveStoreDetail},
    {path: '/reserve_user', name: 'reserve_user',component: ReserveUser},
    {path: '/reserve_usercheck', component: ReserveUserCheck},
    {path: '/mypage', component: Mypage},
    {path: '/mypage_info', component: MypageInfo},
    {path: '/mypage_update', component: MypageUpdate},
    {path: '/cart', component: Cart},
    {path: '/menu', name:"menu", component: Menu},
    {path: '/menu_insert',component: MenuInsert},
    {path: '/menu_insert2/:value',name: "menu_insert", component: MenuInsert2},
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
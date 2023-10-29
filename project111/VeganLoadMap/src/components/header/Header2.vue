<template>
  <header data-bs-theme="dark">
    <div class="navbar navbar-dark bg-dark shadow-sm">
      <div class="container">
        <router-link to="/home_store" class="navbar-brand d-flex align-items-center">
          <i class="fa fa-pagelines" aria-hidden="true"></i>&nbsp;
          <strong>VeganRoadMap</strong>
        </router-link>
      </div>
      <div>
        <!-- 로그인 아이콘-->
        <router-link to="/user" class="text-white" v-if="!$store.state.account.id">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
        </router-link>
        <!-- 로그아웃 아이콘-->
        <a to="/login2" class="text-white" @click="logout()" v-else>
          <i class="fa fa-sign-out" aria-hidden="true"></i>
        </a>
        &nbsp;
        <!-- 마이페이지 아이콘-->
        <router-link to="/mystore" class="cart btn" v-if="$store.state.account.id">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
        </router-link>
      </div>
    </div>

    <ul class="nav justify-content-center" id="abc">
      <li class="nav-item">
        <router-link to="/vegan3" class="menu">비건로드맵 소개</router-link>
        <div class="btnbanner"></div>
        <router-link to="/shop_insert" class="menu">입점신청</router-link>
        <div class="btnbanner"></div>
        <router-link to="/reserve_update" class="menu">예약 관리</router-link>
        <div class="btnbanner"></div>
        <router-link to="/vegan4" class="menu">이용가이드</router-link>
      </li>
    </ul>
    <div class="wrapper"><br><br></div>

  </header>
</template>

<script>
import router from "@/scripts/router";
import store from "@/scripts/store";
import axios from "axios";

export default {
  name: 'Header2',
  setup() {
    const logout = () => {
      axios.post("/api/store/logout").then(()=>{
        store.commit('setAccount', 0);
        router.push({path: "/"});
      });
    }
    return {logout}
  }
}
</script>

<style scoped>
#abc{
  background: darkolivegreen;
  height : 70px;
}
.nav-item {
  margin-top: 20px;
  font-size : 20px;
  font-weight: 500;
  text-decoration: none;
}
.wrapper {
  background: #f1f1f1;
}
.menu{
  color : aliceblue;
  text-decoration-color: darkolivegreen;
}
.btnbanner{
  width: 4px;
  height: auto;
  margin-right : 100px;
  display: inline-block;
}
header ul li a {
  cursor: pointer;
}

header .navbar .cart {
  margin-left: auto;
  color: #fff;
}
</style>
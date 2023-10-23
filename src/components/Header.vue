<template>

<header data-bs-theme="dark">
  <div class="collapse text-bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-4 py-4">
          <ul class="list-unstyled">
            <li>
              <router-link to="/shop">식당</router-link> &nbsp;
              <router-link to="/mypage">마이페이지</router-link> &nbsp;
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <router-link to="/" class="navbar-brand d-flex align-items-center">
          <i class="fa fa-cutlery" aria-hidden="true"></i>&nbsp;
          <strong>Vegan</strong>
      </router-link>
      <router-link to="/login" class="cart" v-if="!$store.state.account.id">
        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
      </router-link>
      <a class="cart" to="/login" @click="logout()" v-else>
        <i class="fa fa-sign-out" aria-hidden="true"></i>
      </a>-->

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>
</template>

<script>
import router from "@/scripts/router";
import store from "@/scripts/store";
import axios from "axios";

export default {
  name: 'Header',
  setup() {
    const logout = () => {
      axios.post("/api/account/logout").then(()=>{
        store.commit('setAccount', 0);
        router.push({path: "/"});
      });
    }
    return {logout}
  }
}
</script>
<style scoped>
header ul li a {
  cursor: pointer;
}

header .navbar .cart {
  margin-left: auto;
  color: #fff;
}

</style>

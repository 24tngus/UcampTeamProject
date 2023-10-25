<template>
  <Header/>
  <div class="cart">
    <div class="container">
      <ul>
        <li v-for="(shop, idx) in state.items" :key="idx">
          <img :src="shop.image"/>
          <span class="name">{{ shop.storename }}</span>
          <span class="category">{{shop.category}}</span>
          <span class="category">예약금{{ lib.getNumberFormatted(10000) }}원</span>
          <i class="fa fa-trash" @click="remove(shop.seq)"></i>
        </li>
      </ul>
      <router-link to="/reserve" class="btn btn-primary">예약하기</router-link>
    </div>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import lib from "@/scripts/lib";
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  setup() {
    const state = reactive({
      items: []
    })

    const load = () => {
      axios.get("/api/cart/shop").then(({data}) => {
        state.items = data;
      })
    };

    const remove = (shopSeq) => {
      axios.delete(`/api/cart/shop/${shopSeq}`).then(() => {
        load();
      })
    }

    load();

    return {state, lib, remove}
  }
}
</script>

<style scoped>
.cart ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

.cart ul li {
  border: 1px solid #eee;
  margin-top: 25px;
  margin-bottom: 25px;
}

.cart ul li img {
  width: 150px;
  height: 150px;
}

.cart ul li .name {
  margin-left: 25px;
}

.cart ul li .category {
  margin-left: 25px;
}

.cart ul li i {
  float: right;
  font-size: 20px;
  margin-top: 65px;
  margin-right: 50px;
}

.cart .btn {
  width:300px;
  display:block;
  margin:0 auto;
  padding:30px 50px;
  font-size: 20px;
}
</style>
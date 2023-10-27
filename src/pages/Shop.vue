<template>
  <Header/>
  <div class="shop">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(shop, idx) in state.items" :key="idx">
            <div class="card shadow-sm">
<!--              <div :style="`background-image : url(${shop.image})`"></div>-->
              <img :src="shop.image"/>
              <div class="card-body">
                <p class="card-text">
                  <span> {{shop.storename}} </span> &nbsp;
                  <span> {{shop.rating}} </span>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <button class="btn btn-primary" @click="$router.push('/menu')"><!--메뉴 상세보기-->
                    <i class="fa fa-plus" aria-hidden="true"></i>
                  </button>
                  <button class="btn btn-primary" @click="$router.push('/reserve')">
                    <i class="fa fa-calendar-check-o" aria-hidden="true"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

</template>

<script>
import axios from "axios";
import {reactive} from "vue";
import Header from "@/components/header/Header.vue";

export default {
  name: "Shop",
  components: {Header},
  setup() {
    const state = reactive({
      items: []
    })
    axios.get("/api/shop").then(({data}) => {
      state.items = data;
    })

    const addToCart = (shopSeq) => {
      axios.post(`/api/cart/shop/${shopSeq}`).then(() => {
        console.log('success')
      })
    };

    return {state, addToCart};
  }
}
</script>

<style scoped>
.card .img{
  display: inline-block;
  width: 100%;
  hieght: 250px;
  background-size: cover;
  background-position: center;
}

.btn {
  width:80px;
  float: right;
}

.card .card-body .price{
  text-decoration: line-through;
}
</style>
<template>
  <div class="store">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(shop, idx) in state.items" :key="idx">
            <div class="card shadow-sm">
              <!--      <span class="img" style="{backgroundImage: url('${item.imagePath}')}" />-->
              <img :src="shop.fileupload"/>
              <div class="card-body">
                <p class="card-text">
                  <span> {{shop.storename}} </span> &nbsp;
                </p>
                <div class="d-flex justify-content-between align-items-center">
<!--                  <small class="price text-muted">-->
<!--                    {{lib.getNumberFormatted(menu.price)}}원-->
<!--                  </small>-->
<!--                  <small class="real text-danger">-->
<!--                    {{lib.getNumberFormatted(menu.price - (menu.price * menu.sale / 100)) }}원-->
<!--                  </small>-->
                  <button class="btn btn-primary" @click="$router.push('/menu')">
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

export default {
  name: "Shop",
  setup() {
    const state = reactive({
      items: []
    })
    axios.get("/api/shop").then(({data}) => {
      state.items = data;
    })

    return {state};
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
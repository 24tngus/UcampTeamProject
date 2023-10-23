<template>
  <div class="store">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(menu, idx) in state.menus" :key="idx">
            <div class="card shadow-sm">
              <!--      <span class="img" style="{backgroundImage: url('${item.imagePath}')}" />-->
              <img :src="menu.image"/>
              <div class="card-body">
                <p class="card-text">
                  <span> {{menu.menu}} </span> &nbsp;
                  <span class="discount badge bg-danger">{{menu.sale}}%</span>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <button class="btn btn-primary" @click="$router.push('/reserve')">예약하기</button>
                  <small class="price text-muted">
                    {{menu.price}}원
                  </small>
                  <small class="real text-danger">
                    {{menu.price - (menu.price * menu.sale / 100)}}원
                  </small>
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
  name: "Store",
  setup() {
    const state = reactive({
      menus: []
    })
    axios.get("/api/menu").then(({data}) => {
      state.menus = data;
    })
    return {state};
  },
  methods: {

  }

}
</script>

<style scoped>

</style>
<template>
  <Header />
  <div class="card shadow-sm" id="cat">
    <div class="card-body" >
      <div><h2 class="cattitle">Fusion Food</h2></div>
      <div class="list-group" id="catlist">
        <div v-for="(fusion, idx) in state.items" :key="idx">
          <a href="/storeInfo" class="list-group-item list-group-item-action">
            <div class="card shadow-sm">
              <div class="card-body">
                <p class="card-text">
                  <span><h3 class="shopTitle"> {{fusion.storename}} </h3></span><br>
                  <span class="shop1"> {{fusion.category}} </span><br>
                  <span class = "shop2"> {{fusion.location}} </span><br>
                  <span> {{fusion.rating}} </span><br>
                  <img :src="fusion.image" alt="이미지제발나와라뿅"/>
                </p>
              </div>
            </div>
          </a>
        </div> <!-- v-for-->
      </div>

    </div>
  </div>
</template>

<script>
import { reactive, onMounted } from "vue";
import axios from "axios";
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  setup() {
    const state = reactive({
      items: [],
    });

    onMounted(() => {
      axios.get("/api/shop/fusion").then((response) => {
        state.items = response.data;
      });
    });

    return { state };
  },
};

</script>

<style scoped>
.shop2{
  color : dimgray;
}

.shopTitle{
  border : 1px solid yellow;
  padding : 0;
}

.shop1{
  border : 1px solid pink;
  color : cadetblue;
}
#cat{
  border : 1px solid green;
  width : 70%;
  height : auto;
  margin : auto;
}

.cattitle{
  border : 1px solid red;
  padding : 20px;
  font-weight: 700;
}

#catlist{
  border : 1px solid blue;
}

</style>
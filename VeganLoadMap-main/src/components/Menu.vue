<template>
  <Header />

  <div class="store">

    <div class="album py-5 bg-body-tertiary">

      <!-- * * * Food-Menu Section * * * -->
      <section id="food-menu">
        <div class="top-container">
          <div class="top-element" style="margin-left: 18%; font-size: 2em; width: 150px; ">
            <i id="up_back" class="fa fa-chevron-left fa-3x" aria-hidden="true" @click="goBack"></i>
          </div>
          <div class="top-element" style="margin-left: 15%"><h2 class="cattitle">Fusion Food</h2></div>
        </div>

        <div class="food-menu-container container">
          <div class="food-menu-item" v-for="(menu, idx) in this.menus" :key="idx">
            <div class="food-img">
              <img :src="setImgUrl(menu.image)" class="cardImg"/>
            </div>
            <div class="food-description">
              <h2 class="food-titile">{{ menu.menu }}</h2>
              <p> {{ menu.info }} </p>
              <p class="food-price">Price: {{ menu.price}}</p>
            </div>
          </div>
        </div>
      </section>

      <!-- * * * Review Section * * *-->
      <section id="reviews">
        <h2 class="review-title">What Our Customers Say</h2>
        <!--        <div class="review-container container">-->
        <!--          <div class="review-box">-->
        <!--            <div class="customer-detail">-->
        <!--              <div class="customer-photo">-->
        <!--                <img src="https://i.postimg.cc/5Nrw360Y/male-photo1.jpg" alt="" />-->
        <!--                <p class="customer-name">Ross Lee</p>-->
        <!--              </div>-->
        <!--              &lt;!&ndash;              <div class="customer-photo">&ndash;&gt;-->
        <!--              &lt;!&ndash;                <img src="https://i.postimg.cc/5Nrw360Y/male-photo1.jpg" alt="" />&ndash;&gt;-->
        <!--              &lt;!&ndash;                <p class="customer-name">Ross Lee</p>&ndash;&gt;-->
        <!--              &lt;!&ndash;              </div>&ndash;&gt;-->
        <!--            </div>-->
        <!--            <div class="star-rating">-->
        <!--              <span class="fa fa-star checked"></span>-->
        <!--              <span class="fa fa-star checked"></span>-->
        <!--              <span class="fa fa-star checked"></span>-->
        <!--              <span class="fa fa-star checked"></span>-->
        <!--              <span class="fa fa-star checked"></span>-->
        <!--            </div>-->
        <!--            <p class="review-text">-->
        <!--              Lorem ipsum dolor sit amet consectetur, adipisicing elit. Impedit-->
        <!--              voluptas cupiditate aspernatur odit doloribus non.-->
        <!--            </p>-->
        <!--          </div>-->
        <!--        </div>-->
      </section>
    </div>
    <hr style="border: solid 5px #2ecc71;">
    <Review />
  </div>

  <div style="font-size: 2em; margin-right: 5%; float:right;">
    <i id="up_back" class="fa fa-chevron-up fa-3x" aria-hidden="true" @click="goUp"/>
  </div>
</template>

<script>
import axios from "axios";
// import router from "@/scripts/router";
import lib from "@/scripts/lib";
import Header from "@/components/header/Header.vue";
import Review from "@/components/review/Review.vue";
import {reactive} from "vue";

export default {
  name: "Store",
  components: {Header,
    Review
  },
  data() {
    return {
      seq: null,
      menus: []
    }
  },
  created() {
    // this.seq = router.currentRoute.value.params.value1;
    console.log("router seq 확인", this.seq);
    this.getMenu();
  },
  methods: {
    getMenu() {
      const seq = this.$route.query.seq;

      console.log("seq " + seq);
      axios.get(`/api/menu/${seq}`, {params: { seq: seq } }).then(({data}) => {
        this.menus = data;
        console.log("getMenu 호출");
        console.log("data 확인", data);
      });
    },

    goBack() {
      this.$router.go(-1)
    },
    goUp() {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    }
  },
  setup() {
    const setImgUrl = (imageName) => {
      return require(`../../public/${imageName}`);
    };

    const state = reactive({
      menus: []
    })
    axios.get("/api/menu").then(({data}) => {
      state.menus = data;
    })

    return { lib, setImgUrl, state };
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

.cattitle{
  padding : 20px;
  font-weight: 700;
  text-align: center;
}

.top-container {
  display: flex;
}

.top-element {
  margin: 10px
}


.container {
  width: 80%;
  margin : auto;
  text-align: center;

}

#up_back{
  cursor: pointer;
  font-size: 3em;
  color: #556B2F;
  opacity: 0.3;
}

/* .........../ Food Menu /............ */

.food-menu-heading {
  text-align: center;
  font-size: 3.4rem;
  font-weight: 400;
  color: #666;
}

.food-menu-container {
  display: flex;
  flex-wrap: wrap;
  padding: 50px 0px 30px 0px;
}

.food-menu-container img {
  display: block;
  width: 250px;
  height: 250px;
  border-radius: 50%;
  object-fit: cover;
  object-position: center;
}

.food-menu-item {
  display: flex;
  flex: 1 1 600px;
  justify-content: space-evenly;
  margin-bottom: 3rem;
}

.food-description {
  margin: auto 1.5rem;
}

.font-title {
  font-size: 1.8rem;
  font-weight: 400;
  color: #444;
}

.food-description p {
  font-size: 1.4rem;
  color: #555;
  font-weight: 500;
}

.food-description .food-price {
  color: #117964;
  font-weight: 700;
}

/* ........./ Review /.......... */

#reviews {
  padding: 5rem 0;
  background: rgba(243, 243, 243);
}

.review-title {
  text-align: center;
  font-size: 2.8rem;
  font-weight: 400;
  color: #555;
}

.review-container {
  display: flex;
  justify-content: space-between;
  font-size: 1.4rem;
  padding: 1rem;
}

.review-box .checked {
  color: #ff9529;
}

.review-box .review-text {
  margin: 1rem 0;
  color: #444;
}

.review-box {
  text-align: center;
  padding: 1rem;
}

.customer-photo img {
  display: block;
  width: 150px;
  height: 150px;
  object-fit: cover;
  object-position: center;
  border-radius: 50%;
  margin: auto;
}


</style>
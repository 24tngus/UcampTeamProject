<template>
  <Header />
  <div v-if="this.menus.length !== 0">
    <section class="showcase-area" id="showcase" v-if="this.menus.length !== 0">
      <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
      <div class="showcase-container">
        <h1 style="font-size: 80px; color: darkolivegreen" class="main-title" id="home">Menu</h1><br>
        <p style="font-size: 30px; color: darkgrey" class="p-title">Enjoy a variety of menu!</p>
      </div>
    </section>
    <div class="store">
      <div class="album py-5 bg-body-tertiary">

        <!-- * * * Food-Menu Section * * * -->
        <section id="food-menu">
          <div class="food-menu-container container">
            <div class="food-menu-item" v-for="(menu, idx) in this.menus" :key="idx">
              <div class="food-img">
                <img v-if="menu.image && menu.image > 0"  :src="`/api/images/download/${menu.image}`" menu.image/>
<!--                <img :src="setImgUrl(menu.image)" class="cardImg"/>-->
              </div>
              <div class="food-description">
                <h2 class="food-titile">{{ menu.info }}</h2>
                <p> {{ menu.menu }} </p>
                <p class="food-price">Price: {{ menu.price}}</p>
              </div>
            </div>
          </div>
          <div style="margin-left: 18%; font-size: 10em;">
            <img src="../../public/a_icon.png" @click="goBack" id="up_back" style="width: 10%">
          </div>
        </section>
      </div>
    </div>
  </div>


  <div>
    <div class="store">
      <!-- * * * Review Section * * *-->
      <section class="showcase-area2">
        <div class="background-image2" :style="'background-image: url(/aaa1.png)'"></div>
        <div class="showcase-container2">
          <h1 style="font-size: 80px; color: black" class="main-title2" id="home">Review</h1><br>
          <p style="font-size: 30px; color: darkslategrey" class="p-title2">You can see the reviews of the restaurant</p>
        </div>
      </section>
      <Review />
      <img src="../../public/a_icon.png" @click="goBack" id="up_back" style="width: 10%">
    </div>
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
import Review from "@/components/shop/Review.vue";
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
    this.getMenu();
  },
  methods: {
    getMenu() {
      const seq = this.$route.query.seq;

      axios.get(`/api/menu/${seq}`, {params: { seq: seq } }).then(({data}) => {
        this.menus = data;
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
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");
*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

body {
  font-family: "Poppins", sans-serif;
}
.showcase-area {
  height: 50vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/qvvztbtX/7.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  opacity: 0.7;
}
.showcase-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* 왼쪽 정렬로 변경 */
  justify-content: center;
  height: 100%;
  font-size: 1.6rem;
}
.main-title {
  font-size: 180%;
  color: #545d32;
  text-align: left;
  margin-left: 20%;
}
.p-title {
  font-size: 80%;
  color: #6e6a67;
  text-align: left; /* 왼쪽 정렬로 변경 */
  margin-left: 15%;
}
.showcase-area2 {
  height: 40vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/MpH2cTRH/8.jpg");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  opacity: 0.5;
}
.showcase-container2 {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  font-size: 1.6rem;
}
.main-title2 {
  font-size: 180%;
  color: #545d32;
}
.p-title2 {
  font-size: 80%;
  color: #6e6a67;
}
btn {
  display: inline-block;
  padding: 0.5em 1.5em;
  text-decoration: none;
  border-radius: 50px;
  cursor: pointer;
  outline: none;
  margin-top: 1em;
  text-transform: uppercase;
}
.btn-primary {
  color: #fff;
  background: darkolivegreen;
  width: 15%;
  opacity: 0.7; /* 투명도를 조정합니다. 0.0에서 1.0까지 가능합니다. */
  transition: opacity 0.3s ease-in-out;
}
.btn-primary:hover {
  background: darkolivegreen;
  transition: background 0.3s ease-in-out;
  opacity: 1.0;
}

.cattitle{
  padding : 20px;
  font-weight: 700;

}


.container {
  width: 80%;
  margin : auto;
  text-align: center;

}

#up_back{
  cursor: pointer;
  font-size: 10em;
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
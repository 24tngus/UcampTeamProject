<template>
  <Header />

  <div class="store">
    <div class="album py-5 bg-body-tertiary">
      <!-- * * * Food-Menu Section * * * -->
      <section id="food-menu">
        <h2 class="food-menu-heading">Food Menu</h2>
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
        <div class="review-container container">
          <div class="review-box">
            <div class="customer-detail">
              <div class="customer-photo">
                <img src="https://i.postimg.cc/5Nrw360Y/male-photo1.jpg" alt="" />
                <p class="customer-name">Ross Lee</p>
              </div>
              <!--              <div class="customer-photo">-->
              <!--                <img src="https://i.postimg.cc/5Nrw360Y/male-photo1.jpg" alt="" />-->
              <!--                <p class="customer-name">Ross Lee</p>-->
              <!--              </div>-->
            </div>
            <div class="star-rating">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
            </div>
            <p class="review-text">
              Lorem ipsum dolor sit amet consectetur, adipisicing elit. Impedit
              voluptas cupiditate aspernatur odit doloribus non.
            </p>
          </div>
        </div>
      </section>
    </div>

  </div>

</template>

<script>
import axios from "axios";
import router from "@/scripts/router";
import lib from "@/scripts/lib";
import Header from "@/components/header/Header.vue";

export default {
  name: "Store",
  components: {Header},
  data() {
    return {
      seq: null,
      menus: []
    }
  },
  created() {
    this.seq = router.currentRoute.value.params.value;
    this.getMenu();
  },
  methods: {
    getMenu() {
      axios.get(`/api/menu/${this.seq}`).then(({data}) => {
        this.menus = data;
      })
    }
  },
  setup() {
    const setImgUrl = (imageName) => {
      return require(`../../public/${imageName}`);
    };

    return { lib, setImgUrl };
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');



.container {
  width: 80%;
  margin : auto;
  text-align: center;

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
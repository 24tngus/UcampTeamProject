<template>
  <Header/>
  <section class="showcase-area" id="showcase">
    <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
    <div class="showcase-container">
      <h1 class="main-title" id="home">Recommendation</h1><br>
      <p>Choose what you want!</p>
    </div>
  </section>
  <div class="card shadow-sm" id="cat">
    <div class="card-body" ><br>
      <div><h2 class="cattitle">Restaurant</h2></div>
      <div class="list-group" id="catlist">
        <div class="card-body">
          <!-- shop_register -->
          <div class="col" v-for="(shop, idx) in state.items2" :key="idx">
            <div class="card shadow-sm" id="cardshop">
              <div class="container">
                <div class="image-content">
                  <div class="image-column">
                    <img :src="require(`@/assets/${shop.image2}`)" class="shopimage1">
                    <!--                    <img :src="'../../public/' + shop.image2" class="shopimage1">-->
                  </div>
                  <div class="image-column">
                    <img :src="require(`@/assets/${shop.image1}`)" class="shopimage1">
                    <!--                    <img :src="'../../public/' + shop.image1" class="shopimage1">-->
                  </div>
                  <div class="image-column">
                    <img :src="require(`@/assets/${shop.image3}`)" class="shopimage1">
                    <!--                    <img :src="'../../public/' + shop.image3" class="shopimage1">-->
                  </div>
                </div>
              </div>
              <div class="text-content">
                <div class="title-and-cart">
                  <span><h3 class="shopTitle"> {{shop.storename}}</h3></span>
                  <span class="cartbtn">
                    <i @click="addToCart(shop.seq)" class="fa fa-heart fa-2x" aria-hidden="true"></i>
                    <!--                    <i v-else @click="cartFlag(shop)" class="fa fa-heart-o fa-2x" aria-hidden="true"></i>-->
                            </span>
                </div>
                <span class="shop1"> {{shop.category}} </span> &nbsp;
                <!--                shop_register에 rating 칼럼 추가 필요 (리뷰 합산에서 구현 필요)-->
                <span><i class="fa fa-star" aria-hidden="true" style="color: green"></i>4.5 </span><br>
                <span><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;{{shop.phonenumber}}</span><br>
                <span class="shop2"> <i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp;{{shop.location}} </span>
              </div>
              <div class="btn-style" id="mbtn">
                <!--                하단 코드로 작동도 가능-->
                <!--                <button class="mreserve" @click="$router.push({ path: '/menu', query: { storename: shop.storename, seq:shop.seq} })">대표메뉴</button>-->
                <button class="mreserve" @click="goToMenu(shop.storename, shop.seq)">대표메뉴</button>
                <button class="mreserve" @click="goToReserve(shop.storename)">예약하기</button>
              </div>
            </div> <br>
          </div>
        </div>


        <!-- shop -->
          <div class="card-body">
            <div class="col" v-for="(shop, idx) in state.items" :key="idx">
              <div class="card shadow-sm" id="cardshop">
                <div class="container">
                  <div class="image-content">
                    <div class="image-column">
                      <img :src="shop.image1" class="shopimage1" v-if="shop.image2 && !shop.image2.startsWith('AcJ')" />
                      <img :src="setImgUrl(shop.image2)"  class="shopimage1" v-else />
                    </div>
                    <div class="image-column">
                      <img :src="shop.image2" class="shopimage1" v-if="shop.image1 && !shop.image1.startsWith('AcJ')" />
                      <img :src="setImgUrl(shop.image1)"  class="shopimage1" v-else />
                    </div>
                    <div class="image-column">
                      <img :src="shop.image3" class="shopimage1" v-if="shop.image3 && !shop.image3.startsWith('AcJ')" />
                      <img :src="setImgUrl(shop.image3)"  class="shopimage1" v-else />
                    </div>
                  </div>
                </div>

                <div class="text-content">
                  <div class="title-and-cart">
                    <span><h3 class="shopTitle"> {{shop.storename}}</h3></span>
                  </div>
                  <span class="shop1"> {{shop.category}} </span> &nbsp;
                  <span><i class="fa fa-star" aria-hidden="true" style="color: green"></i>{{shop.rating}} </span><br>
                  <span><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;{{shop.phonenumber}}</span><br>
                  <span class="shop2"> <i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp;{{shop.location}} </span>
                </div>
                <div class="btn-style2" id="mbtn">
                  <!--                하단 코드로 작동도 가능-->
                  <!--                <button class="mreserve" @click="$router.push({ path: '/menu', query: { storename: shop.storename, seq:shop.seq} })">대표메뉴</button>-->
                  <button class="mreserve" @click="goToMenu(shop.storename, shop.seq)">대표메뉴</button>
                </div>
              </div> <br>
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
      items: [],
      items2: [],
      // flag: 0
    })

    const setImgUrl = (imageName) => {
      return `https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=${imageName}&key=AIzaSyB21eMRg-uMRk-i7r27DPDkntXbR5_kvnk`;
    };

    axios.get("/api/shop").then(({data}) => {
      // data.forEach(shop => {
      //   shop.flag = false;
      // });
      state.items = data;
    })

    axios.get("/api/shop/register").then(({data}) => {
      // data.forEach(shop => {
      //   shop.flag = false;
      // });
      state.items2 = data;
    })

    const addToCart = (shopSeq) => {
      axios.post(`/api/cart/insert/${shopSeq}`).then(() => {
        console.log('success')
      })
    };

    return {state, setImgUrl, addToCart};
  },
  data() {
    return {
      imgUrl: null,
      flag : 0
    }
  },
  methods: {
    goToMenu(storename, seq) {
      this.$router.push({ name: 'menu', query: { storename, seq } });
    },
    goToReserve(storename){
      this.$router.push({ name : 'reserve_user', query: {storename}});
    }
  },

}
</script>

<style scoped>

.title-and-cart {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

/* 아이콘들 간의 간격을 조절합니다. */
.cartbtn i {
  margin: 0 5px;
  color: red; /* 아이콘의 색을 빨간색으로 지정합니다. */
}

/* 아이콘 크기 설정 */
.fa-2x {
  font-size: 2em;
}

.shopimage1:hover{
  transform: scale(3);
  transition: transform 0.3s; /* 변환 효과에 0.3초 동안의 트랜지션 적용 */
}
.shopimage1 {
  width: 100%;
  height: 100%;
  object-fit: cover; /* Maintain the aspect ratio and cover the entire column */

}
.image-content {
  width : 100%;
  height: 100%; /* Set the height of the image container to 60% */
  display: flex;
}

.image-column {
  flex: 1;
  text-align: center;
  overflow: hidden;
}

.image-span img {
  max-width: 100%; /* Ensure the image doesn't exceed the column's width */
  max-height: 100%; /* Ensure the image doesn't exceed the container's height */
  display: block; /* Remove any extra space around the image */
  margin: 0 auto; /* Center the image horizontally */
}
.container {
  width: 100%; /* Set the width of your container */
  height: 215px; /* Set the height of your container */
  overflow: hidden; /* Hide any part of the image that exceeds the container */
}

.card-body {
  margin: auto;
  width: 100%;
}


.text-content {
  flex: 2;
  padding: 10px; /* Add padding for spacing */
  text-align: left;
  margin: 0 20px;
}

.btn-style {
  margin-left: 70%;
}

.btn-style2 {
  margin-left: 75%;
}

#mbtn {
  text-align: center;
  width: 200px;
  padding-bottom: 10px;
}
.mreserve{
  margin: 10% 0 0 7%;
  border : 2px solid darkolivegreen;
  padding : 5% 10% 5% 10%;
  background: darkolivegreen;
  border-radius: 7px;
  color : white;
  font-weight: 600;
  font-size: 12px;
}
.mreserve:hover{
  background: olive;
  border : 2px solid olive;
  padding : 8px 20px;
  border-radius: 7px;
  color : #f3f0d6;
  font-size: 12px;
}

#cat {
  width: 70%;
  height: auto;
  margin: auto;
}

.cattitle {
  padding: 20px;
  font-weight: 700;
}

#catlist {
  width: 80%;
  text-align: center;
  margin: auto;
}

.shopimage1 {
  max-width: 100%; /* Ensure the image doesn't exceed its container's width */
  max-height: 100%; /* Ensure the image doesn't exceed its container's height */
  display: inline-block; /* Display the images inline */
  margin: 0 10px; /* Add margin between the images for spacing */
}

.shopimage2 {
  max-width: 100%; /* Ensure the image doesn't exceed its container's width */
  max-height: 100%; /* Ensure the image doesn't exceed its container's height */
  display: inline-block; /* Display the images inline */
  margin: 0 10px; /* Add margin between the images for spacing */
  margin: 0 auto; /* Center the image horizontally */
}

.btn {
  width: 80px;
  float: right;
}

.shop2 {
  color: dimgray;
}

.shopTitle {
  padding: 10px;
}

.shop1 {
  color: cadetblue;
  font-weight: 600;
}

.showcase-area {
  height: 32vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/0Nzk6QzS/5.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.showcase-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  font-size: 1.6rem;
}
@media (orientation: landscape) and (max-height: 500px) {
  .showcase-area {
    height: 50vmax;
  }
}
.main-title {
  text-transform: uppercase;
  margin-top: 0.5em;
  font-size: 200%;
  color: #695a5a;
}
p {
  color: #bd8282;
}
</style>
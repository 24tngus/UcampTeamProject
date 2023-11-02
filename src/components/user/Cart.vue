<template>
  <Header/>
  <div id="wrapper">
    <div id="container">
      <div class="tab">
        <router-link to="/mypage"><h1>마이페이지</h1></router-link>
        <div class="buttontab">
          <router-link to="/mypage_info"><button class="tablink">회원 정보</button></router-link>
          <router-link to="/cart"><button class="tablink">찜 목록</button></router-link>
          <router-link to="/reserve_usercheck"><button class="tablink">예약 목록</button></router-link>
          <router-link to="/myreview"><button class="tablink">리뷰 확인</button></router-link>
        </div>
      </div>

      <div v-if="state.items.length === 0">
        <div class="online small" id="online">
          <br>
          <h1>{{state.item.name}}님의 찜 목록</h1>
          <br><br>
          <div class="member">
            <div class="field">
              <br><br><br><br><br><br><br><br><br><br><br><br>
              <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;찜하신 가게 정보가 없습니다.</b>
              <br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
          </div>
        </div>
      </div>
      <!-- 본문  -->
      <div class="online small" id="online" v-else>
        <br>
        <h1>{{state.item.name}}님의 찜 목록</h1>
        <br><br>
      </div>
      <div class="contain" >
        <figure class="snip1423" v-for="(shop, idx) in state.items" :key="idx">
<!--          <img :src="shop.image"/>-->
          <img v-if="imageURL !== 0"  :src="`/api/images/download/${shop.image}`" style="width: 100%"/>
          <figcaption>
            <h3>{{ shop.storename }}</h3>
            <p>{{shop.location}}</p>
            <img src="../../../public/a_reserve.png"  class="res" @click="goToReserve(shop.seq)">
            <img src="../../../public/a_trash.png"  class="del"  @click="remove(shop.seq)">
          </figcaption>
        </figure>

      </div>
      <!-- 페이지 처리 -->
      <div id="num">
        <span><a href="#"> &lt; </a></span>
        <span><a href="">1</a></span>
        <span><a href="#"> > </a></span>
      </div>
      <br><br><br>

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
  data() {
    return {
      storename: "",
    }
  },
  methods: {
    goToReserve(seq){
      axios.get(`/api/shop/register/info/${seq}`).then(({ data }) => {
        this.storname = data.storname;
        this.goReserve(this.storename, seq);
      });
    },
    goReserve(storename, seq) {
      this.$router.push({ name : 'reserve_user', query: {storename, seq}});
    }
  },
  setup() {
    const state = reactive({
      items: [],
      item: Object
    })

    const loadmy = () => {
      axios.get("/api/user/mypage").then(({ data }) => {
        state.item = data;
        load();
      });
    };

    const load = () => {
      axios.get(`/api/cart/shop`).then(({ data }) => {
        state.items = data;
      });
    };

    loadmy();

    const remove = (shopSeq) => {
      axios.delete(`/api/cart/delete/${shopSeq}`).then(() => {
        load();
        window.alert("찜 목록에서 삭제 되었습니다");
      })
    }

    load();

    return {state, lib, remove}
  }
}
</script>

<style scoped>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Oswald:300,400);
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

.online.small h1{
  font-size: 25px;
  margin-bottom: 40px;
  margin-left: 40px;
}
.online ul{
  min-width: 100%;
  max-width: 100%
}
.online .thumbox .textbox h3{
  font-weight: 900;
  font-size: 14px;
  margin-bottom: 10px;
}
.online .thumbox .textbox p{
  color: #6e6a67;
  font-size: 11px;
}
.online .thumbox .textbox p:first-of-type{
  margin-bottom: 10px;
}
.online .filter{
  width: 100%;
  background: #f1f1f1;
  height: 70px;
  line-height: 70px;
  padding: 0 20px;
  margin-bottom: 30px;
}
.online .filter button{
  border: 1px solid #d4d4d4;
  background: #fff;
  width: 100px;
  padding: 5px;
  margin-right: 10px;
  color: #6e6a67
}
.online .filter span{
  float: right;
  font-size: 11px;
  color: #6e6a67
}
.online .filter span b{
  color: #fa2424;
}
.online ul{
  text-align: center;
  padding: 0 5%;
  max-width: 100%;
  min-width: 600px;
}
.online .thumbox .img a{
  display: inline-block;
  width: 100%;
  height: 100%;
}
.online .thumbox .textbox{
  /*    float: left;*/
  height: 100px;
  width: 100%;
  padding:15px 25px;

}
.online .thumbox .textbox h3{
  font-weight: 900;
  font-size: 14px;
  margin-bottom: 10px;
}
.online .thumbox .textbox p{
  color: #6e6a67;
  font-size: 11px;
}
.online .thumbox .textbox p:first-of-type{
  margin-bottom: 10px;
}
.contain {
  display: flex;
  flex-wrap: wrap; /* 자동 줄 바꿈을 위해 설정 */
  justify-content: space-between; /* figure 요소들을 가로로 균등하게 배치 */

}

.snip1423 {
  font-family: 'Oswald', Arial, sans-serif;
  position: static;
  margin: 5%;
  max-width: 40%;
  max-height: 70%;
  width: 100%;
  background: #ffffff;
  text-align: center;
  color: #000000;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  font-size: 16px;
  padding:4%;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.2s ease-out;
  transition: all 0.2s ease-out;
}
.snip1423 * {
  -webkit-box-sizing: padding-box;
  -webkit-transition: all 0.2s ease-out;
  transition: all 0.2s ease-out;
}
.snip1423 img {
  max-width: 100%;
  vertical-align: top;
  position: relative;
  width: 100%; /* 이미지 너비를 100%로 설정하여 부모 요소에 맞춥니다 */
  height: 60%; /* 이미지 높이를 100%로 설정하여 부모 요소에 맞춥니다 */
  object-fit: cover;
}
.snip1423 figcaption {
  padding: 20px 15px;
}
.snip1423 h3,
.snip1423 p {
  margin: 0;
}
.snip1423 h3 {
  font-size: 1.3em;
  font-weight: 400;
  margin-bottom: 5px;
  text-transform: uppercase;
}
.snip1423 p {
  font-size: 0.9em;
  letter-spacing: 1px;
  font-weight: 300;
}
.snip1423 .price {
  font-weight: 500;
  font-size: 1.4em;
  line-height: 48px;
  letter-spacing: 1px;
}
.snip1423 .price s {
  margin-right: 5px;
  opacity: 0.5;
  font-size: 0.9em;
}

.snip1423 .res {
  position: relative;
  margin-bottom: 10%;
  left: -20%;
  -webkit-transform: translate(-50%, 50%);
  transform: translate(-50%, 50%);
  width: 22%;
  line-height: 56px;
  text-align: center;
  opacity: 0.7;
  color: #ffffff;
  font-size: 1.6em;
  border: 4px solid #ffffff;
}

.snip1423 .del {
  position: relative;
  left: 45%;
  margin-bottom: 10%;
  -webkit-transform: translate(-50%, 50%);
  transform: translate(-50%, 50%);
  width: 20%;
  line-height: 56px;
  text-align: center;
  opacity: 0.7;
  color: #ffffff;
  font-size: 1.6em;
  border: 4px solid #ffffff;
}

.snip1423 a {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 1;
}
.snip1423:hover,
.snip1423.hover {
  -webkit-transform: translateY(-5px);
  transform: translateY(-5px);
}









*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

#wrapper{
  width: 100%;
}

#num{
  text-align: center;
  margin: 30px 0;
  padding: 40px 0;
  position: relative;
  z-index: 2
}
#num:before{
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  top:0px;
  left: 0;
  border-top: 1px solid #d4d4d4;
  z-index: -1
}
#num span{
  display: inline-block;
  border: 1px solid #d4d4d4;
  margin: 0 2px;
  padding: 5px 10px;
  vertical-align: middle;
  cursor: pointer
}
#num span a{
  font-size: 10px;
}
.currentNum{
  background: #32312f!important;
}
.currentNum a{
  color: #fff
}
#num span:hover{
  background: #d4d4d4;
}
#num span:hover a,#num span:hover i{
  color: #fff
}
#wrapper{
  background: #f1f1f1
}
#wrapper header {
  position: relative !important;
  background: #fff!important
}
#wrapper .headerwrap a, #wrapper .user i{
  color: #333
}
#container{
  position: relative;
  max-width: 70%;
  min-width:  880px;
  margin: 0 0 0 10%;
  background: #fff;
}
#container:after{
  content:'';
  display: block;
  clear: both
}
#container > div:not(:first-of-type){
  background: #fff;
  padding: 3% 10% 0 25%;

}
.tab{
  position: absolute;
  left: 0;
  width: 200px;
  height: 100%;
  /*    float: left;*/
  /*    background: pink;*/
  height: 100%;
  /*    position: relative;*/
  padding: 200px 20px 0 20px;
}
.tab:after{
  content: '';
  display: block;
  clear:both
}
button{
  border: none;
  background: none;
  outline: none;
  cursor: pointer;
  width: 100px;
  height: 70px;
}
button.on{
  color: #fa2828;
  font-weight: 900
}
.tab h1{
  position: absolute;
  top: 0;
  left: 0;
  /*    float: left;*/
  height: 150px;
  width: 100%;
  background: darkolivegreen;
  color: #fff;
  font-size: 18px;
  text-align: left;
  padding: 25px
}
.tab button{
  width: 100%;
  text-align: left;
  height: 80px;
  font-size: 14px;
  font-weight: 800;
  position: relative;
  cursor: pointer;
  padding-left: 10px
}
.tab button:hover{
  color: #fa2828;
}
.tab button:after{
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  border-bottom: 1px solid #d4d4d4;
}

</style>
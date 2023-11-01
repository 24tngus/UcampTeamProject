<template>
  <Header />
  <div id="wrapper">
    <div id="container">
      <div class="tab">
        <router-link to="/mypage"><h1>마이페이지</h1></router-link>
        <div class="buttontab">
          <router-link to="/mypage_info"><button class="tablink">회원 정보</button></router-link>
          <router-link to="/cart"><button class="tablink">찜 목록</button></router-link>
          <router-link to="/reserve_usercheck"><button class="tablink">예약 확인</button></router-link>
          <router-link to="/myreview"><button class="tablink">리뷰 확인</button></router-link>
        </div>
      </div>
      <div v-if="reviews.length === 0">
        <div class="online small" id="online">
          <br>
          <h1>{{item.name}}님의 리뷰 목록</h1>
          <br><br>
          <div class="member">
            <div class="field">
              <br><br><br><br><br><br><br><br><br><br><br><br>
              <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성하신 리뷰가 없습니다.</b>
              <br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
          </div>
        </div>
      </div>
      <div class="online small" id="online" v-else>
        <br>
        <h1>{{item.name}}님의 리뷰 목록</h1>
        <br><br>
        <div class='app'>
          <main class='project'>
            <div class='project-tasks'>
              <div class='project-column review' v-for="review in reviews" :key="review.seq">
                <input type="hidden" v-model="review.seq"/>
                <input type="hidden" v-model="review.storeid"/>
                <div class='task' draggable='true'>
                  <img src="../../../public/a_review2.png" style="width: 15%"/>
                  &nbsp;&nbsp;&nbsp;&nbsp;<span class='task__tag task__tag--copyright' style="font-size: 20px">{{review.storename}}</span>
                  <br><br>
                  <span v-if="review.star === 1">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; margin-left: 1%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; ">
                  </span>
                  <span v-if="review.star === 2">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; margin-left: 1%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; ">
                  </span>
                  <span v-if="review.star === 3">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; margin-left: 1%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; ">
                  </span>
                  <span v-if="review.star === 4">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_blank.png" style="width: 5%; margin-left: 1%; ">
                  </span>
                  <span v-if="review.star === 5">
                    <img src="../../../public/a_star.png" style="width: 5%; margin-left: 1%; ">
                    <img src="../../../public/a_star.png" style="width: 5%;">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                    <img src="../../../public/a_star.png" style="width: 5%; ">
                  </span>
                  <div class='task__tags'>
                    <button class='task__options'></button>
                    <p style="font-size: 16px">{{ review.content }}</p><br><br>
                    <img class="shopimage1" v-if="review.image && review.image.length > 0" :src="`/api/images/download/${review.image}`" style="width: 100%;"/>
                  </div>
                  <div class="button-container">
                    <router-link :to="{ name: 'review_update', params: { value: review.seq } }"><button type="button" class="bbtn">수정</button></router-link>
                    <button type="button" class="bbtn" @click="deleteReview(review)">삭제</button>
                  </div>
                </div>

              </div>

            </div>
          </main>
        </div>

        <!-- 페이지 처리 -->
        <div id="num">
          <span><a href="#"> &lt; </a></span>
          <span><a href="">1</a></span>
          <span><a href="#"> > </a></span>
        </div>
        <br><br><br><br><br><br><br><br><br><br>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  data() {
    return {
      item: Object,
      reviews: [],
      nickname: '',
    };
  },
  created() {
    this.load();
    this.fetchReview();
  },
  methods: {
    load() {
      axios.get("/api/user/mypage").then(({ data }) => {
        this.item = data;
      });
    },
    fetchReview() {
      axios
          .get("/api/myreview")
          .then((response) => {
            this.reviews = response.data;
          })
          .catch((error) => {
            console.error("Error fetching reviews", error);
          });
    },
    deleteReview(review) {
      axios
          .delete(`/api/review/delete/${review.seq}`) // Assuming seq is the identifier for the review
          .then(() => {
            this.fetchReview();
          })
          .catch((error) => {
            console.error("Error delete review", error);
          });
    },
  },
};
</script>
<style scoped>
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Oswald:300,400);
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

.button-container {
  display: flex;
  justify-content: space-between; /* 두 버튼을 왼쪽과 오른쪽으로 배치합니다. */
  align-items: center; /* 버튼을 세로 중앙 정렬합니다. */
}
.bbtn {
  margin: 10% 0 0 2%;
  border : 2px solid darkolivegreen;
  border-radius: 57px;
  color : darkolivegreen;
  font-weight: 600;
  font-size: 12px;
}
.bbtn:hover{
  background: darkolivegreen;
  border : 2px solid olive;
  border-radius: 57px;
  color : #f3f0d6;
  font-size: 12px;
  opacity: 0.3;
}
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

.project {
  padding: 2rem;
  max-width: 75%;
  width: 100%;
  display:inline-block;
}

.task {
  cursor: move;
  background-color:white;
  padding: 1rem;
  border-radius: 8px;
  width: 100%;
  box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px;
  margin-bottom: 1rem;
  border: 3px dashed transparent;

  &:hover {
    box-shadow: rgba(99, 99, 99, 0.3) 0px 2px 8px 0px;
    border-color: green !important;
  }

  p {
    font-size: 15px;
    margin: 1.2rem 0;
  }
}
</style>
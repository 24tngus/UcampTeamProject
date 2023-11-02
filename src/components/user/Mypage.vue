<template>
  <Header />
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

      <!-- 본문 작성 -->
      <div class="online small" id="online">
        <h1>{{state.items.name}}님 My Page</h1>
        <div class="status">
          <div class="item">
            <div>
              <router-link to="/cart">
                <div class="green number"><img src="../../../public/a_cart2.png" style="width: 40px"/></div><br>
              </router-link>
              <div class="item_text">찜 목록</div>
            </div>
            <div class="item_icon"> > </div>
          </div>
          <div class="item">
            <div>
              <router-link to="/reserve_usercheck">
              <div class="number"><img src="../../../public/a_cart3.jpeg" style="width: 55px" /> </div>
              </router-link>
              <div class="item_text">예약 목록</div>
            </div>
            <div class="item_icon"> > </div>
          </div>
          <div class="item">
            <div>
              <router-link to="/reserve_usercheck">
              <div class="green number"><img src="../../../public/a_reserve6.png" style="width: 35px" /></div><br>
              </router-link>
              <div class="item_text">이용 완료</div>
            </div>
            <div class="item_icon"> > </div>
          </div>
          <div class="item">
            <div>
              <router-link to="/myreview">
              <div class="green number"><img src="../../../public/a_review4.png" style="width: 55px" /></div>
              </router-link>
              <div class="item_text">가게 후기</div>
            </div>
          </div>
        </div>

        <ul>
          <li class="thumbox">
            <router-link to="/mypage_info">
              <div class="textbox">
                <img src="../../../public/a_user.png" class="image-size" />
                <br><br>
                <h3>회원 정보</h3>
                <p>#전화번호 변경 #이름 변경</p>
              </div>
            </router-link>
          </li>
          <li class="thumbox">
            <router-link to="/cart">
              <div class="textbox">
                <img src="../../../public/a_shop.png" class="image-size" />
                <br><br>
                <h3>찜 목록</h3>
                <p>#예약 대기 #예약 하러가기</p>
              </div>
            </router-link>
          </li>
          <li class="thumbox">
            <router-link to="/reserve_usercheck">
              <div class="textbox">
                <img src="../../../public/a_reserve.png" class="image-size" />
                <br><br>
                <h3>예약 목록</h3>
                <p>#예약 일정 관리 #예약 취소</p>
              </div>
            </router-link>
          </li>
          <li class="thumbox">
            <router-link to="/myreview">
              <div class="textbox">
                <img src="../../../public/a_review.png" class="image-size" />
                <br><br>
                <h3>리뷰 확인</h3>
                <p>#후기 관리 #가게 피드백</p>
              </div>
            </router-link>
          </li>
        </ul>

        <!-- 페이지 처리 -->
        <div id="num">
          <span><a href="#"> &lt; </a></span>
          <span><a href="">1</a></span>
          <span><a href="#"> > </a></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {reactive} from "vue";
import axios from "axios";
import Header from "@/components/header/Header.vue";

export default {
  name: "Mypage",
  components: {Header},
  setup() {
    const state = reactive({
      items: Object
    })

    const load = () => {
      axios.get("/api/user/mypage").then(({data}) => {
        state.items = data;
      })
    };

    load();
    return {state};
  }
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

.image-size {
  width: 50%;
}

a{color: #333;
  text-decoration:none;
}

ul li{
  list-style: none;
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

.status{
  display: flex;
  justify-content: space-between;
  margin-bottom: 21px;
}
.item{
  display: flex;
}
.number{
  font-size: 25px;
  font-weight: 500;
  text-align: center;
}
.item_text{
  font-size: 11px;
  font-weight: normal;
  color: #c2c2c2;
  text-align: center;
}
.item_icon{
  display: flex;
  align-items: center;
  padding: 20px;
  width: 16px;
  height: 16px;
}

#notice:after{
  content: '';
  display: block;
  clear: both;
}
#notice ul{
  display: inline-block;
  height:25px;
  line-height: 25px;
  width: 70%;
  text-align: left;
  padding-left: 15%;
  float: left;
  overflow: hidden;
  position: relative;
  background-size: 20px;
}
#notice ul:after{
  content: '';
  position: absolute;
  width: 20px;
  height: 25px;
  line-height: 25px;
  background-size: 20px;
  z-index: 2000;
  top:4px;
  left: 16%;
  z-index: 120;
}

#noticewrap a, #noticewrap i{
  color: #fff;
}
#noticewrap ul a{
  font-size: 0.7em;
}

#noticewrap p{
  display: inline-block;
  line-height: 25px;
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
  padding: 3% 10% 0 30%;

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

.online.small h1{
  font-size: 25px;
  margin-bottom: 40px;
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
.online .thumbox{
  /*    padding-left: 120px;*/
  position: relative;
  margin-bottom: 25px;
  /*    margin-right: 10px;*/
  width:250px;
  display: inline-block;
  padding: 70px 0 0 0;
  text-align: center
}
.online .thumbox .img{
  background-size: contain;
  width: 120px;
  height: 100px;
  display: table-cell;
  vertical-align: middle;
  position: absolute;
  top: 0;
  left: 50%;

  transform: translateX(-50%);
  text-align: center;
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

.member{
  width: 400px;
  /* border: 1px solid #000; */
  margin-left: 7px;
  padding: 0 20px;
  margin-bottom: 20px;
}

.member .logo{
  /*로고는 이미지라 인라인 블록이니까 마진 오토 안됨 블록요소만 됨 */
  display: block;
  margin :50px auto;
}

.member .field{
  margin :5px 0; /*상하로 좀 띄워주기*/
}

.member b{
  /* border: 1px solid #000; */
  display: block; /*수직 정렬하기 */
  margin-bottom: 5px;
}

.block {
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
}

.field.birth div{ /*field 이면서 birth*/
  display: flex;
  gap:10px; /*간격 벌려줌*/
}

.field.tel-number div {
  display: flex;
}

.field.tel-number div input:nth-child(1){
  flex:2;
}

.field.tel-number div input:nth-child(2){
  flex:1;
}

.field.gender div{
  border: 1px solid #dadada;
  padding: 15px 5px;
  background-color: #fff;
}

.btn {
  background-color: darkolivegreen;
  color: #ffffff;
  width : 20%;
  height : 90%;
}

</style>
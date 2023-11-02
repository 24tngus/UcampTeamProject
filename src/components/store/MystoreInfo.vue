<template>
  <Header2 />
<div id="wrapper">

  <div id="container">
    <div class="tab">
      <router-link to="/mystore"><h1>마이페이지</h1></router-link>
      <div class="buttontab">
        <router-link to="/mystore_info"><button class="tablink">회원 정보</button></router-link>
        <router-link to="/myshop_info"><button class="tablink">가게 정보</button></router-link>
        <router-link to="/reserve_update"><button class="tablink">예약 관리</button></router-link>
        <router-link to="/reserve_store"><button class="tablink">예약 목록</button></router-link>
        <router-link to="/review_store"><button class="tablink">리뷰 확인</button></router-link>
      </div>
    </div>


    <!-- 본문 작성 -->
    <div class="online small" id="online">
      <h1>{{state.items.name}}님 회원 정보</h1>
      <br><br><br>
      <div class="member">
        <div class="field">
          <b>아이디</b>
          <span class="placehold-text">
        <div class="block">{{state.items.id}}</div>
      </span>
        </div>
        <div class="field">
          <b>비밀번호</b>
          <div class="block">***********</div>
        </div>
        <div class="field">
          <b>이름</b>
          <div class="block">{{state.items.name}}</div>
        </div>
        <div class="field">
          <b>이메일</b>
          <div class="block">{{state.items.email}}</div>
        </div>
        <div class="field tel-number">
          <b>휴대전화</b>
          <div>
            <div class="block">{{state.items.tel}}</div>
          </div>
        </div>
        <div class="field">
          <b>사업자 등록 번호</b>
          <div class="block">{{state.items.storenumber}}</div>
        </div>
        <div class="field">
          <b>사업자 등록증</b>
          <div><img v-if="state.items.storefile && state.items.storefile.length > 0"  :src="`/api/images/download/${state.items.storefile}`" style="width: 100%"/></div>
        </div><br>
        <button class="btn" @click="$router.push('/mystore_update')">수정</button>&nbsp;
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

import {reactive} from "vue";
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";

export default {
  name: "MystoreInfo",
  components: {Header2},
  setup() {
    const state = reactive({
      items: Object
    })

    const load = () => {
      axios.get("/api/store/mypage").then(({data}) => {
        state.items = data;
        // this.imageURL =`/api/images/download/${state.items.storefile}`;
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
  font-size: 15px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

img{border: none}

a{color: #333;
  text-decoration:none;
}

ul li{
  list-style: none;
}

#wrapper{
  width: 100%;
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
  min-width: 60%;
  margin: 0 0 0 20%;
  background: #fff;
}
#container:after{
  content:'';
  display: block;
  clear: both
}
#container > div:not(:first-of-type){
  background: #fff;
  padding: 40px 20px 0 250px;

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
footer{
  background: #fff;
  position: relative;
  z-index: 1
}
footer:before{
  content: '';
  position: absolute;
  top: 0;
  left: -50%;
  width: 300%;
  height: 100%;
  background: #fff;
  z-index: -1
}
@media (max-width:700px){
  #wrapper header {
    position: fixed !important;
    top: 0;
  }
  #container{
    position: relative;
    min-width: 100%;
    max-width: 100%;
    margin-top: 120px;
  }
  .tab{
    width: 100%;
    height:100px;
    padding:0  20px 0 0;
  }
  .tab > h1{
    position:static;
    float: left;
    height: 100%;
    width: 30%;
  }
  .tab .buttontab{
    float: left;
    width: 70%;
    height:100%;
    padding-left: 20px;
  }
  .tab button{
    height: 50%;
  }

  #container > div:not(:first-of-type){
    padding:120px 0 0 0;
    width: 100%;
  }
  .online ul{
    min-width: 100%;
    max-width: 100%
  }
  .online ul .thumbox{
    padding: 0 0 0 120px ;
  }
  #online h1{
    display: none;
  }

  .online .thumbox{
    margin-bottom: 25px;
    width:100%;
  }
  .online .thumbox .textbox{
    text-align: left;
  }

  .online .thumbox .img{
    left:0;
    transform: translate(0);
  }
  #num{
    display: none
  }
}
/*member sign in*/
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

.member .member select{
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
}

.member input[type=button],
.member input[type=submit]{
  background-color:green;
  color:#fff
}

.member input:focus, .member select:focus{
  border: 1px solid #2db400;
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

.placehold-text{
  display: block; /*span 으로 감싸서 크기영역을 블록요소로 만들어ㅜ저야한다*/
  position:relative;
  /* border: 1px solid #000; */
}

.placehold-text:before{
  position:absolute; /*before은 inline 요소이기 때문에 span으로 감싸줌 */
  right : 20px;
  top:13px;
  pointer-events: none; /*자체가 가지고 있는 pointer event 를 없애준다 */
}

.member-footer {
  text-align: center;
  font-size: 12px;
  margin-top: 20px;
}

.member-footer div a:hover{
  text-decoration: underline;
  color:#2db400
}

.member-footer div a:after{
  content:'|';
  font-size: 10px;
  color:#bbb;
  margin-right: 5px;
  margin-left: 7px;
  display: inline-block;
  transform: translateY(-1px);
}

.member-footer div a:last-child:after{
  display: none;
}

.btn {
  background-color: darkolivegreen;
  color: #ffffff;
  width : 20%;
  height : 90%;
}

@media (max-width:768px) {
  .member{
    width: 100%;
  }
}
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
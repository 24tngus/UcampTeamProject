<template>
  <Header />
  <div class="wrap">
    <div class="greenContainer">
      <div class="name">회원 정보</div>
    </div>
    <div class="shippingStatusContainer">
      <div class="title">
        회원 정보
      </div>
    </div>
  </div>
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
      <b>닉네임</b>
      <div class="block">{{state.items.nickname}}</div>
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
    <button class="btn" @click="$router.push('/mypage_update')">수정</button>&nbsp;
    <button class="btn" @click="$router.push('/mypage')">확인</button>
  </div>

</template>

<script>

import {reactive} from "vue";
import axios from "axios";
import Header from "@/components/header/Header.vue";

export default {
  name: "MypageInfo",
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
*{
  box-sizing: border-box; /*전체에 박스사이징*/
  outline: none; /*focus 했을때 테두리 나오게 */
}

body{
  font-family: 'Noto Sans KR', sans-serif;
  font-size:14px;
  background-color: #f5f6f7;
  line-height: 1.5em;
  color : #222;
  margin: 0;
}

a{
  text-decoration: none;
  color: #222;
}

.btn {
  background-color: #24855b;
  color: #ffffff;
}

.wrap{
  background-color: #F8F8F8;
}

.greenContainer{
  height: 132px;
  background-color: #24855b;

  display: flex;
  align-items: flex-end;
  padding: 16px;
  margin-left: auto;
}

.greenContainer .name{
  font-size: 20px;
  font-weight: bold;
  color: #ffffff;
}

.shippingStatusContainer{
  padding: 21px 16px;
  background-color: white;
  margin-bottom: 10px;
}

/* 주문/배송조회 타이틀 */
.shippingStatusContainer .title{
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 15px;
}

/* 장바구니 결제완료 배송중 구매확정 [로우] */
.shippingStatusContainer .status{
  display: flex;
  justify-content: space-between;
  margin-bottom: 21px;
}
/* 장바구니 결제완료 배송중 구매확정 [아이템]  */
.shippingStatusContainer .item{
  display: flex;
}

.shippingStatusContainer .number{
  font-size: 31px;
  font-weight: 500;
  text-align: center;
}
.shippingStatusContainer .text{
  font-size: 12px;
  font-weight: normal;
  color: #c2c2c2;
  text-align: center;
}
.shippingStatusContainer .icon{
  display: flex;
  align-items: center;
  padding: 20px;
  width: 16px;
  height: 16px;
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

.userpw{
  background:url(../../../public/icon01.png) no-repeat center right 15px;
  background-size: 30px;
  background-color: #fff;
}

.userpw-confirm{
  background:url(../../../public/icon02.png) no-repeat center right 15px;
  background-size: 30px;
  background-color: #fff;
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

@media (max-width:768px) {
  .member{
    width: 100%;
  }
}
</style>
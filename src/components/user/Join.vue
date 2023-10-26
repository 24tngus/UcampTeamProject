<template>
  <Header/>

  <div class="card shadow-sm">
    <div class="card-body">
      <div class="joinform">

  <!--
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Naver SignUp</title>
    -->
  <!-- Google Material Icons -->
  <!--
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  -->
  <!-- Archivo Black Font -->
  <!--
  <link href="https://fonts.googleapis.com/css?family=Archivo+Black" rel="stylesheet">
  <link rel="stylesheet" href="style.css" />
</head>
<body>
-->
  <header class="header">
    <!--
      AS-IS
      - code
        <h1 class="blind">네이버 회원가입</h1>
        <span class="logo">
          <a href="#">회원가입</a>
        </span>
      - comment
        h1을 블라인드 처리하지 말고 logo랑 하나로 묶는 게 좋을 거 같네요.

      TO-BE
      - 아래와 같이 변경 함.
      - Anchor내에 회원가입을 넣은 이유: VoiceOver와 같은 접근성 툴이용시 이 문서가 네이버 회원가입임을 알게하기 위함.
    -->
    <h1>
      <a href="#" class="logo">
        VeganRoadMap
        <span class="blind">회원가입</span>
      </a>
    </h1>
  </header>

        <legend>Sign Up</legend>

        <ul class="container">
          <li class="row">
            <div class="input-area">
              <label for="id" class="blind">아이디</label>
              <input type="text" placeholder="아이디" id="id"  required/>
            </div>
          </li>
          <li class="row">
            <div class="input-area">
              <label for="password" class="blind">비밀번호</label>
              <input type="password" placeholder="비밀번호" id="password"  required/>
            </div>
          </li>
          <li class="row">
            <div class="input-area">
              <label for="password-recheck" class="blind">비밀번호 재확인</label>
              <input type="password" placeholder="비밀번호 재확인" id="password-recheck"  required/>
            </div>
          </li>
        </ul>

        <ul class="container">
          <li class="row name-area">
            <label for="name" class="blind">이름</label>
            <input type="text" placeholder="이름" id="name"  required/>
          </li>
          <!--
            - input + label trick: https://css-tricks.com/almanac/selectors/c/checked/
          -->
          <li class="row">
            <div class="btn-group">
              <div class="btn-item">
                <input type="radio" name="sex" value="male" id="male" class="blind" required/>
                <label for="male">남자</label>
              </div>
              <div class="btn-item">
                <input type="radio" name="sex" value="female" id="female" class="blind" />
                <label for="female">여자</label>
              </div>
            </div>
          </li>
          <li class="row email-area">
            <label for="email" class="blind">본인확인 이메일(선택)</label>
            <input type="email" placeholder="본인확인 이메일(선택)" id="email"  />
          </li>
        </ul>

        <ul class="container">
          <li class="row tel-area">
            <div class="input-area">
              <select>
                <option value="" selected disabled>국가번호</option>
                <option value="82">+82</option>
              </select>
            </div>
            <div class="input-area">
              <label for="tel-number" class="blind">휴대전화번호</label>
              <input type="tel" placeholder="휴대전화번호" id="tel-number" required/>
            </div>


          </li>
        </ul>

        <button text="button" class="btn btn-submit">
          <span class="submit-text">가입하기</span>
        </button>
        <br><br><br>

      </div>
    </div>
  </div>

  <!--
    </body>
  </html>
  -->

  <!--  <div class="wrap">-->
<!--    <div class="greenContainer">-->
<!--      <div class="name">회원 정보</div>-->
<!--    </div>-->
<!--    <div class="shippingStatusContainer">-->
<!--      <div class="title">-->
<!--        회원 정보-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--  <div class="member">-->
<!--    <div class="field">-->
<!--      <b>아이디</b>-->
<!--      <span class="placehold-text"><input type="text" v-model="state.form.id"></span>-->
<!--    </div>-->
<!--    <div class="field">-->
<!--      <b>비밀번호</b>-->
<!--      <input class="userpw" type="password" v-model="state.form.password">-->
<!--    </div>-->
<!--&lt;!&ndash;    <div class="field">&ndash;&gt;-->
<!--&lt;!&ndash;      <b>비밀번호 재확인</b>&ndash;&gt;-->
<!--&lt;!&ndash;      <input class="userpw-confirm" type="password">&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->
<!--    <div class="field">-->
<!--      <b>이름</b>-->
<!--      <input type="text" v-model="state.form.name">-->
<!--    </div>-->
<!--    <div class="field">-->
<!--      <b>닉네임</b>-->
<!--      <input type="text" v-model="state.form.nickname">-->
<!--    </div>-->
<!--    <div class="field">-->
<!--      <b>이메일</b>-->
<!--      <input type="email" placeholder="example@naver.com" v-model="state.form.email">-->
<!--&lt;!&ndash;      <select>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="">직접입력</option>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="aver.com">naver.com</option>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="gmail.com">gmail.com</option>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="nate.com">nate.com</option>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="hanmail.net">hanmail.net</option>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="yahoo.com">yahoo.com</option>&ndash;&gt;-->
<!--&lt;!&ndash;        <option value="yahoo.com">outlook.com</option>&ndash;&gt;-->
<!--&lt;!&ndash;      </select>&ndash;&gt;-->
<!--    </div>-->
<!--    <div class="field tel-number">-->
<!--      <b>휴대전화</b>-->
<!--      <select>-->
<!--        <option value="">대한민국 +82</option>-->
<!--      </select>-->
<!--      <div>-->
<!--        <input type="tel" placeholder="전화번호 입력 (- 없이 입력)" v-model="state.form.tel">-->
<!--      </div>-->
<!--    </div>-->

<!--    <button class="btn" @click="join()">회원가입</button>-->
<!--  </div>-->
</template>

<script>

import {reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";
import Header from "@/components/header/Header.vue";

export default {
  name: "Join",
  components: {Header},
  setup() {
    const state = reactive({
      form :{
        id: "",
        password: "",
        name: "",
        nickname: "",
        email: "",
        tel: ""
      }
    })
    const join = () => {
      axios.post("/api/user/join", state.form).then(()=> {
        window.alert("회원가입 되었습니다");
        router.push({path: "/login"});
      })
    }

    return {state, join}
  }
}

</script>

<style scoped>
.joinform {
  width: 30%;
  margin: auto;
  text-align: center;
}

body {
  margin: 0;
  background: rgb(242, 244, 245);
  font-family: 'Apple SD Gothic Neo', 'Noto Sans KR', sans-serif;
  color: #a1a1a1;
  font-size: 14px;
}
a {
  text-decoration: none;
  color: inherit;
}
ul {
  margin: 0;
  padding: 0;
}
li {
  list-style: none;
}
select {
  display: inline-block;
  width: 100%;
  height: 30px;
  border: 0;
  background: inherit;
  font-size: inherit;
}
input {
  display: inline-block;
  width: 100%;
  height: 30px;
  border: 0;
  font: inherit;
  font-weight: 300;
  box-sizing: border-box;
  /* iOS에서 input 영역 shadow 제거 */
  -webkit-appearance: none;
}
fieldset {
  margin: 0;
  padding: 0;
  border: 0;
}
fieldset legend {
  display: none;
}

.blind {
  position: absolute;
  left: -9999px;
}

/* Button Group */
.btn-group {
  display: flex;
  width: 100%;
  text-align: center;
}
.btn-group .btn-item {
  width: 50%;
  height: inherit;
}
.btn-group .btn-item:first-child {
  display: flex;
}
.btn-group .btn-item:first-child::after {
  content: '';
  width: 1px;
  background: #e1e1e1;
}
.btn-group .btn-item > label {
  display: inline-block;
  width: 100%;
  height: 38px;
  line-height: 38px;
  box-sizing: border-box;
}
.btn-group .btn-item input[type="radio"] + label {
  border: 1px solid #e1e1e1;
}
.btn-group .btn-item:first-child input[type="radio"] + label {
  border-right-color: transparent;
}
.btn-group .btn-item:nth-child(2) input[type="radio"] + label {
  border-left-color: transparent;
}
.btn-group .btn-item input[type="radio"]:checked + label {
  border: 1px solid rgb(35, 172, 0);
  color: rgb(35, 172, 0);
}

/* Button */
.btn {
  margin: 0;
  padding: 0;
  border: 0;
  background: #fff;
}
/* Button - default */
.btn.btn-default {
  display: inline-block;
  width: 58px;
  height: 38px;
  border: 1px solid #e1e1e1;
  background: #fff;
}
/* Button - submit */
.btn.btn-submit {
  display: block;
  width: 100%;
  height: 55px;
  margin-top: 50px;
  border: 0;
  font-size: 18px;
  color: white;
  font-weight: 300;
  background: darkolivegreen;

}
.btn.btn-submit .submit-text {
  position: relative;
  top: -4px;
}

/* Container */
.container {
  margin-bottom: 15px;
  border: 1px solid #c1c1c1;
  background: #fff;
}

/* Row */
.row {
  height: 55px;
  padding: 11.5px 17px;
  border-bottom: 1px solid #eee;
  box-sizing: border-box;
}
.row {
  display: flex;
  align-items: center;
}
.row .input-area {
  flex: 1;
}
.row button {
  margin-left: 10px;
}

.row .icon-area {
  width: 80px;
  margin-left: 10px;
  text-align: right;
}

.row.birth-area {
  display: flex;
  padding: 0;
}
.row.birth-area .input-area {
  display: flex;
  align-items: center;
  flex: 1;
}
.row.birth-area .input-area > div {
  width: 33.333333%;
  margin: 0 10px;
  box-sizing: border-box;
}
.row.birth-area .input-area > div:nth-child::after {
  display: block;
  content: '';
  border-right: 1px solid red;
}
.row.birth-area .input-area > div {
  display: flex;
}
.row.birth-area .input-area > div:first-child::after,
.row.birth-area .input-area > div:nth-child(2)::after {
  position: relative;
  left: 10px;
  width: 1px;
  content: '';
  background: #eee;
}
.row.birth-area .title-area {
  width: 64px;
  border-right: 1px solid #eee;
  background: rgb(245, 245, 245);
  text-align: center;
  padding: 19px 0;
  box-sizing: border-box;
}
.row.tel-area .input-area:first-child {
  display: flex;
  flex: initial;
  margin-right: 10px;
  width: 80px;
}
.row.tel-area .input-area:first-child::after {
  position: relative;
  left: 10px;
  width: 1px;
  content: '';
  background: #eee;
}
.row.tel-area .input-area:nth-child(2) {
  margin-left: 10px;
}


/* Header */
.header .logo {
  display: block;
  margin-top: 55px;
  margin-bottom: 25px;
  text-align: center;
  color : darkslategrey;
  font-family: 'Archivo Black', sans-serif;
  font-weight: 700;
  font-size: 40px;
}

/* Main */
.main .form {
  margin: 0 15px;
}

/* Footer */
.footer {
  text-align: center;
  font-size: 12px;
}
</style>
<template>
  <Header/>

  <div class="card shadow-sm">
    <div class="card-body">
      <div class="joinform">
  <header class="header">
    <h1>
      <a href="#" class="logo">
        VeganRoadMap
      </a>
    </h1>
  </header>

        <legend>회원가입</legend>

        <ul class="container">
          <li class="row">
            <div class="input-area">
              <label for="id" class="blind">아이디</label>
              <input type="text" placeholder="아이디" id="id" v-model="state.form.id" required/>
            </div>
          </li>
          <li class="row">
            <div class="input-area">
              <input type="password" placeholder="비밀번호" id="password" v-model="state.form.password" required/>
            </div>
          </li>
        </ul>

        <ul class="container">
          <li class="row name-area">
            <input type="text" placeholder="이름" id="name" v-model="state.form.name" required/>
          </li>
          <li class="row name-area">
            <input type="text" placeholder="닉네임" id="nickname" v-model="state.form.nickname" required/>
          </li>
          <li class="row email-area">
            <input type="email" placeholder="이메일" id="email" v-model="state.form.email" />
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
              <input type="tel" placeholder="휴대전화번호 (- 없이 입력)" id="tel-number" v-model="state.form.tel" required/>
            </div>
          </li>
        </ul>
        <button text="button" class="btn btn-submit" @click="join()">회원가입</button>
        <br><br><br>
      </div>
    </div>
  </div>
</template>

<script>

import {reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";
import Header from "@/components/header/Header.vue";
import store from "@/scripts/store";

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
      axios.post("/api/user/join", state.form).then((res)=> {
        store.commit("setAccount", res.data);
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
<template>
  <Header/>
  <div class="form-signin w-100 m-auto">
      <h1 class="h3 mb-3 fw-normal">사용자 로그인</h1>

      <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput"
               placeholder="name@example.com" v-model="state.form.email">
        <label for="floatingInput">이메일 입력</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword"
               placeholder="Password" v-model="state.form.password">
        <label for="floatingPassword">비밀번호 입력</label>
      </div>
      <button class="btn" @click="submit()">로그인</button> &nbsp;
      <button class="btn" @click="$router.push('/join2')">회원가입</button>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  setup() {
    const state = reactive({
      form :{
        email: "",
        password: ""
      }
    })
    const submit = () => {
        axios.post("/api/account/login", state.form).then((res)=> {
          store.commit("setAccount", res.data); // store 저장
          if (res.data == 0) {
            if (state.form.email == "") {
              window.alert("이메일을 입력해주세요");
            } else if (state.form.password == "") {
              window.alert("비밀번호를 입력해주세요");
            } else {
              window.alert("이메일이나 비밀번호가 틀립니다");
              router.push({path: "/login"});
            }
          }else {
            // console.log(res.data);
            window.alert("로그인 하였습니다");
            router.push({path: "/"});
          }
        })
    }
    return {state, submit}
  }
}
</script>

<style scoped>
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.btn {
  background-color: #24855b;
  color: #ffffff;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
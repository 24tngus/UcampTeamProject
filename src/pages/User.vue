<template>
  <Header/>
  <div class="form-signin w-100 m-auto">
    <button class="btn" @click="$router.push('/login')">사용자 로그인</button> &nbsp;
    <button class="btn" @click="$router.push('/login2')">판매자 로그인</button>
    <!-- 구글 로그인 -->
    <section class="googole">
      <button class="btn test" @click="googleLoginBtn">구글 로그인</button>
      <div id="my-signin2" style="display: none"></div>
    </section>
    <!-- 네이버 로그인 -->
    <div id="naver_id_login"></div>
  </div>
</template>

<script>
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},

  mounted(){
    const naver_id_login = new window.naver_id_login("a4TEdRYQwTEos4Ljj4RU", "http://localhost:3000");
    const state = naver_id_login.getUniqState();
    naver_id_login.setButton("white", 2,40); // 버튼 설정
    naver_id_login.setState(state);
    naver_id_login.init_naver_id_login();
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

</style>
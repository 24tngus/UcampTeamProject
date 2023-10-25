<template>
  <Header/>
  <div class="form-signin w-100 m-auto">
      <button class="btn" @click="$router.push('/login')">사용자 로그인</button> &nbsp;
      <button class="btn" @click="$router.push('/login2')">판매자 로그인</button>
  </div>
</template>

<script>
import Header from "@/components/header/Header.vue";
export default {
  components: {Header},

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
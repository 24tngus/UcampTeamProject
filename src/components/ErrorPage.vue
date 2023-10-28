<template>
  <Header />
  <div id="cat">
    <div class="card-body" >
    <div id="container">
    <img src="veganerror.png" alt="에러 이미지" style="width: 100%; height: auto;"/>
    </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/header/Header.vue";

export default {
  name: 'ErrorPage',
  components: {Header}
}
</script>

<style scoped>
#cat{
  width : 70%;
  height : auto;
  margin : auto;
}
</style>
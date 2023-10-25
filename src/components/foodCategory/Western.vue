<template>
  <Header/>
  <div class="card shadow-sm">
<!--    <span class="img" :style="{backgroundImage: `url(${item.imgPath})`}"/>-->
    <div class="card-body">
      <!--      <p class="card-text">-->
      <!--        <span>{{ item.name }} &nbsp;</span>-->
      <!--        <span class="discount badge bg-danger">-->
      <!--          {{ item.discountPer }}%-->
      <!--        </span>-->
      <!--      </p>-->
      <!--      <div class="d-flex justify-content-between align-items-center">-->
      <!--        <button class="btn btn-primary" @click="addToCart(item.id)">-->
      <!--          <i class="fa fa-shopping-cart" aria-hidden="true"></i>-->
      <!--        </button>-->
      <!--        <small class="price text-muted">-->
      <!--          {{ lib.getNumberFormatted(item.price) }}원-->
      <!--        </small>-->
      <!--        <small class="real text-danger">-->
      <!--          {{ lib.getNumberFormatted(item.price - (item.price * item.discountPer / 100)) }}%-->
      <!--        </small>-->
      <!--      </div>-->
    </div>
  </div>
</template>

<script>
import Header from "@/components/header/Header.vue";
export default {
  components: {Header},
}
</script>

<style scoped>

</style>
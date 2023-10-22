<template>
    <div class="card shadow-sm">
<!--      <span class="img" style="{backgroundImage: url('${item.imagePath}')}" />-->
      <img :src="item.imgPath"/>
      <div class="card-body">
        <p class="card-text">
          <span> {{item.name}} </span> &nbsp;
        <span class="discount badge bg-danger">
            {{item.discountPer}}%
          </span>
        </p>
        <div class="d-flex justify-content-between align-items-center">
          <button class="btn btn-primary">예약하기</button>
          <small class="price text-muted">
            {{lib.getNumberFormatted(item.price)}}원
          </small>
          <small class="real text-danger">
            {{item.price - (item.price * item.discountPer / 100)}}원
          </small>
        </div>
      </div>
    </div>
</template>

<script>
import lib from "@/scripts/lib";

export default {
  name: "Card",
  props: {
    item: Object
  },
  setup() {
    return {lib}
  }
}
</script>

<style scoped>

.card .img{
  display: inline-block;
  width: 100%;
  hieght: 250px;
  background-size: cover;
  background-position: center;
}

.card .card-body .price {
  text-decoration: line-through;
}
</style>

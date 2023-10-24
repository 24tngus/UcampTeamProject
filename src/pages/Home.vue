<template>
  <div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <svg class="bd-placeholder-img" width="100%" height="800px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption text-start">
            <h1>Excellent Vegan Restaurant</h1>
            <p class="opacity-75">VeganRoadMap이 선정한 우수 비건 식당을 만나보세요!</p>
            <br>
            <!--            <p><a class="btn btn-lg btn-primary" href="#">Sign up today</a></p>-->
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="800px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption">
            <h1>vegan & non-vegan</h1>
            <p>비건인들과 논비건인들이 함께할 수 있는 식사</p>
            <br>
            <!--            <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>-->
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="800px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption text-end">
            <h1>비건 식당 예약하기</h1>
            <p>비건 식당을 예약하고 대기 없이 간편하게 이용해보세요.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Reservation</a></p>
            <br>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>


  <br><br><br>
  <div class="container marketing">
    <h1 class="category">Categories</h1><br><br>
    <!-- Three columns of text below the carousel -->
    <div class="row">
      <div class="col-lg-4">
        <svg class="bd-placeholder-img rounded-circle" width="300px" height="300px" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <h2 class="fw-normal">Korean</h2>
        <p><a class="btn btn-secondary" href="#" id="btndetail">한식 예약 &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <svg class="bd-placeholder-img rounded-circle" width="300px" height="300px" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <h2 class="fw-normal">Chinese</h2>
        <p><a class="btn btn-secondary" href="#" id="btndetail">중식 예약 &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <svg class="bd-placeholder-img rounded-circle" width="300px" height="300px" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <h2 class="fw-normal">Western</h2>
        <p><a class="btn btn-secondary" href="#" id="btndetail">양식 예약 &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <!--      <div class="col-lg-4">-->
      <!--        <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="var(&#45;&#45;bs-secondary-color)"/></svg>-->
      <!--        <h2 class="fw-normal">디저트</h2>-->
      <!--        <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>-->
      <!--      </div>&lt;!&ndash; /.col-lg-4 &ndash;&gt;-->
    </div><!-- /.row -->
    <hr>
    <br>
  </div>
  <br>
  <div class="container">
    <br>
    <h1 class="map">View on the map</h1><br><br>
<!--    <Map/>-->
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
// import Map from "@/components/Map.vue";

export default {
  name: "Home",
  // components: {Map},
  setup() {
    const state = reactive({
      items: []
    })
    axios.get("/api/shop").then(({data}) => {
      state.items = data;
    })
    return {state};
  }
}
</script>

<style scoped>

.row {
  text-align: center;
}
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.b-example-divider {
  width: 100%;
  height: 3rem;
  background-color: rgba(0, 0, 0, .1);
  border: solid rgba(0, 0, 0, .15);
  border-width: 1px 0;
  box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
  flex-shrink: 0;
  width: 1.5rem;
  height: 100vh;
}

.bi {
  vertical-align: -.125em;
  fill: currentColor;
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
  --bd-violet-bg: #712cf9;
  --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

  --bs-btn-font-weight: 600;
  --bs-btn-bg: var(--bd-violet-bg);
  --bs-btn-border-color: var(--bd-violet-bg);
  --bs-btn-hover-bg: #6528e0;
  --bs-btn-hover-border-color: #6528e0;
  --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
  --bs-btn-active-bg: #5a23c8;
  --bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
  z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
  display: block !important;
}
</style>
<template>
  <Header2 />
  <div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">

      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="veganMain1.jpg" alt="Slide 1" width="100%" height="700px">
          <div class="carousel-caption">
            <h3>Excellent Vegan Restaurant</h3>
            <p>VeganRoadMap이 선정한 우수 비건 식당을 만나보세요!</p>
          </div>
        </div>

        <div class="carousel-item">
          <img src="veganMain2.jpg" alt="Slide 2" width="100%" height="700px">
          <div class="carousel-caption">
            <h3>vegan & non-vegan</h3>
            <p>비건인들과 논비건인들이 함께할 수 있는 식사</p>
          </div>
        </div>

        <div class="carousel-item">
          <img src="veganMain3.jpg" alt="Slide 3" width="100%" height="700px">
          <div class="carousel-caption">
            <h3>비건 식당 예약하기</h3>
            <p>비건 식당을 예약하고 대기 없이 간편하게 이용해보세요.</p>
          </div>
        </div>
      </div>

      <!-- 컨트롤 버튼 -->
      <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </a>
      <a class="carousel-control-next" href="#myCarousel" data-slide="next">
        <span class="carousel-control-next-icon"></span>
      </a>
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
        <svg class="bd-placeholder-img rounded-circle" width="300px" height="300px" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/>
          <image xlink:href="korean.jpg" x="-30" y="-90" width="500px" height="500px"/>
        </svg>
        <h2 class="fw-normal">Korean</h2>
        <p><router-link to="/foodCategory/Korean" class="btn btn-secondary" id="btndetail">한식 예약 &raquo;</router-link></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <svg class="bd-placeholder-img rounded-circle" width="300px" height="300px" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/>
          <image xlink:href="western.jpg" x="-90" y="-80" width="500px" height="500px"/>
        </svg>
        <h2 class="fw-normal">Western</h2>
        <p><router-link to="/foodCategory/Western" class="btn btn-secondary" id="btndetail">양식 예약 &raquo;</router-link></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <svg class="bd-placeholder-img rounded-circle" width="300px" height="300px" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/>
          <image xlink:href="fusion.jpg" x="0" y="-50" width="400px" height="400px"/>
        </svg>
        <h2 class="fw-normal">Fusion</h2>
        <p><router-link to="/foodCategory/Fusion" class="btn btn-secondary" id="btndetail">퓨전 예약 &raquo;</router-link></p>
      </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->
    <hr>
    <br>

  </div>
  <br>
  <div class="container">
    <br>
    <h1 class="map">View on the map</h1><br><br>
    <Map/>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import Map from "@/components/Map.vue";
import Header2 from "@/components/header/Header2.vue";

export default {
  name: "Home",
  components: {Header2, Map},
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
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

.image-size {
  width: 50%;
}

a{color: #333;
  text-decoration:none;
}

ul li{
  list-style: none;
}
#container{
  position: relative;
  max-width: 70%;
  min-width: 60%;
  margin: 0 0 0 20%;
  background: #fff;
}

#wrapper{
  background: #f1f1f1;

}
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
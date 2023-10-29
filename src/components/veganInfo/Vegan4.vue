<template>
  <Header2 />
  <section class="showcase-area" id="showcase">
    <div class="showcase-container">
      <h1 class="main-title" id="home">채식 식당 예약 서비스 : VeganLoadMap</h1><br><br>
      <p>비건식을 시작하기로 한 사람들에게 맞춤 식당을 추천</p>
      <p>예약 편의성과 신규 고객 유치까지</p>
      <a href="/shop_insert" class="btn btn-primary">시작하기</a>
    </div>
  </section>
  <br><br>
  <div class="stepcont">
    <img src="../../../public/aaa20.png" class="step" />
  </div>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-text">
        <p class="small">One Click</p>
        <h2>인기 맛집도 클릭 한번으로 <br> 손쉽게 예약</h2><br>
        <p>사용자는 예약에 필요한 간단한 정보를 입력하는 것만으로 인기 있는 맛집을 간편하게 예약할 수 있습니다.<br>
          고객은 카테고리 검색을 통해 식당을 추천 받고 실시간 예약을 진행할 수 있습니다.</p>
      </div>
    </div>
  </section>

  <!--          <img src="https://ceo-cdn.baemin.com/optimize?src=https%3A%2F%2Fceo-cdn.baemin.com%2Fcdn%2Fceo-square%2Fproduction%2Fstatic%2Fsrc%2Fimages%2Fbusiness%2FbaeminAd%2Fdocument.png%3Fver%3D195fd70ab9d6788fc7f2407c0e415185" width="30" alt="" class="styled__Img-sc-ggbpcc-0 kxFTju">-->
<!--          <img src="https://ceo-cdn.baemin.com/optimize?src=https%3A%2F%2Fceo-cdn.baemin.com%2Fcdn%2Fceo-square%2Fproduction%2Fstatic%2Fsrc%2Fimages%2Fbusiness%2FbaeminAd%2Fhouse.png%3Fver%3Da21980e2438e11b6f7fd516dfd71ec7d" width="30" alt="" class="styled__Img-sc-ggbpcc-0 kxFTju">-->
<!--          <img src="https://ceo-cdn.baemin.com/optimize?src=https%3A%2F%2Fceo-cdn.baemin.com%2Fcdn%2Fceo-square%2Fproduction%2Fstatic%2Fsrc%2Fimages%2Fbusiness%2FbaeminAd%2Fcheck.png%3Fver%3D2a7c84d1c937aa09226d3ba80b1a3c84" width="30" alt="" class="styled__Img-sc-ggbpcc-0 kxFTju">-->


  <section id="food">
    <h2>기능 미리보기</h2>
    <div class="food-container container">
      <div class="food-type fruite">
        <div class="img-container">
          <img src="../../../public/aaa13.png" alt="error" />
          <div class="img-content">
            <h3>식당 추천</h3>
            <a href="/foodCategory/Korean" class="btn btn-primary" target="blank">보러가기</a>
          </div>
        </div>
      </div>
      <div class="food-type vegetable">
        <div class="img-container">
          <img src="../../../public/aaa11.png" alt="error" />
          <div class="img-content">
            <h3>예약 관리</h3>
            <a href="이미지 파일 경로" onclick="window.open('static/aaa11.png', '미리보기', 'width=400, height=400'); return false;" class="btn btn-primary">미리보기</a>
          </div>
        </div>
      </div>
      <div class="food-type grin">
        <div class="img-container">
          <img src="../../../public/aaa9.png" alt="error" />
          <div class="img-content">
            <h3>리뷰 관리</h3>
            <a href="이미지 파일 경로" onclick="window.open('static/aaa9.png', '미리보기', 'width=400, height=400'); return false;" class="btn btn-primary">미리보기</a>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import Header2 from "@/components/header/Header2.vue";
export default {
  name: "Vegan4",
  components: {Header2},
}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

*,
*::after,
*::before {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

body {
  font-family: "Poppins", sans-serif;
}

.container {
  max-width: 1200px;
  width: 90%;
  margin: auto;
}

.step {
  width: 80%;
  height: 20%;
}
.stepcont {
  display: flex;
  justify-content: center;
  align-items: center;
}
.round-button {
  width: 50px; /* 버튼의 너비 조절 */
  height: 50px; /* 버튼의 높이 조절 */
  background-color: #007bff; /* 원하는 배경 색상 지정 */
  border-radius: 50%; /* 원 모양으로 만들기 */
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center; /* 수직 가운데 정렬 */
  color: white; /* 텍스트 색상 */
  cursor: pointer;
}

#home {
  font-size: 200%;
}

.btn {
  display: inline-block;
  padding: 0.5em 1.5em;
  text-decoration: none;
  border-radius: 50px;
  cursor: pointer;
  outline: none;
  margin-top: 1em;
  text-transform: uppercase;
}

.btn-primary {
  color: #fff;
  background: #16a083;
}

.btn-primary:hover {
  background: #117964;
  transition: background 0.3s ease-in-out;
}

.navbar input[type="checkbox"],
.navbar .hamburger-lines {
  display: none;
}

.menu-items li {
  list-style: none;
  margin-left: 1.5rem;
  margin-bottom: 0.5rem;
  font-size: 1.2rem;
}

.menu-items a {
  text-decoration: none;
  color: #444;
  font-weight: 500;
  transition: color 0.3s ease-in-out;
}

.menu-items a:hover {
  color: #117964;
  transition: color 0.3s ease-in-out;
}

.showcase-area {
  height: 50vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/wT3TQS3V/header-image2.jpg");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.showcase-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  font-size: 1.6rem;
}

.main-title {
  text-transform: uppercase;
  margin-top: 1.5em;
}

#about {
  padding: 50px 0;
  background: #f5f5f7;
}

.about-wrapper {
  display: flex;
  flex-wrap: wrap;
}

#about h2 {
  font-size: 2.3rem;
}

#about p {
  font-size: 1.2rem;
  color: #555;
}

#about .small {
  font-size: 1.2rem;
  color: #666;
  font-weight: 600;
}

.about-img {
  flex: 1 1 400px;
  padding: 30px;
  transform: translateX(150%);
  animation: about-img-animation 1s ease-in-out forwards;
}

@keyframes about-img-animation {
  100% {
    transform: translate(0);
  }
}

.about-text {
  flex: 1 1 400px;
  padding: 30px;
  margin: auto;
  transform: translate(-150%);
  animation: about-text-animation 1s ease-in-out forwards;
}

@keyframes about-text-animation {
  100% {
    transform: translate(0);
  }
}

.about-img img {
  display: block;
  height: 400px;
  max-width: 100%;
  margin: auto;
  object-fit: cover;
  object-position: right;
}

#food {
  padding: 5rem 0 10rem 0;
}

#food h2 {
  text-align: center;
  font-size: 2.5rem;
  font-weight: 400;
  margin-bottom: 40px;
  text-transform: uppercase;
  color: #555;
}

.food-container {
  display: flex;
  justify-content: space-between;
}

.food-container img {
  display: block;
  width: 100%;
  margin: auto;
  max-height: 300px;
  object-fit: cover;
  object-position: center;
}

.img-container {
  margin: 0 1rem;
  position: relative;
}

.img-content {
  position: absolute;
  top: 70%;
  left: 50%;
  transform: translate(-50%, -50%);
  opacity: 0;
  z-index: 2;
  text-align: center;
  transition: all 0.3s ease-in-out 0.1s;
}

.img-content h3 {
  color: #fff;
  font-size: 2.2rem;
}

.img-content a {
  font-size: 1.2rem;
}

.img-container::after {
  content: "";
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.871);
  opacity: 0;
  z-index: 1;

  transform: scaleY(0);
  transform-origin: 100% 100%;
  transition: all 0.3s ease-in-out;
}

.img-container:hover::after {
  opacity: 1;
  transform: scaleY(1);
}

.img-container:hover .img-content {
  opacity: 1;
  top: 40%;
}

.food-menu-container img {
  display: block;
  width: 250px;
  height: 250px;
  border-radius: 50%;
  object-fit: cover;
  object-position: center;
}
.food-description p {
  font-size: 1.4rem;
  color: #555;
  font-weight: 500;
}

.food-description .food-price {
  color: #117964;
  font-weight: 700;
}

.testimonial-box .checked {
  color: #ff9529;
}

.testimonial-box .testimonial-text {
  margin: 1rem 0;
  color: #444;
}

.customer-photo img {
  display: block;
  width: 150px;
  height: 150px;
  object-fit: cover;
  object-position: center;
  border-radius: 50%;
  margin: auto;
}

.contact-img img {
  display: block;
  height: 400px;
  width: 100%;
  object-position: center;
  object-fit: cover;
}

.form-container input {
  display: block;
  width: 100%;
  border: none;
  border-bottom: 2px solid #ddd;
  padding: 1rem 0;
  box-shadow: none;
  outline: none;
  margin-bottom: 1rem;
  color: #444;
  font-weight: 500;
}

.form-container textarea {
  display: block;
  width: 100%;
  border: none;
  border-bottom: 2px solid #ddd;
  color: #444;
  outline: none;
  padding: 1rem 0;
  resize: none;
}

.form-container h2 {
  font-size: 2.7rem;
  font-weight: 500;
  color: #444;
  margin-bottom: 1rem;
  margin-top: -1.2rem;
}

.form-container a {
  font-size: 1.3rem;
}

#footer h2 {
  text-align: center;
  font-size: 1.8rem;
  padding: 2.6rem;
  font-weight: 500;
  color: #fff;
  background: rgb(65, 65, 65);
}

@media (max-width: 768px) {
  .navbar {
    opacity: 0.95;
  }

  .navbar-container input[type="checkbox"],
  .navbar-container .hamburger-lines {
    display: block;
  }

  .navbar-container {
    display: block;
    position: relative;
    height: 64px;
  }

  .navbar-container input[type="checkbox"] {
    position: absolute;
    display: block;
    height: 32px;
    width: 30px;
    top: 20px;
    left: 20px;
    z-index: 5;
    opacity: 0;
  }

  .navbar-container .hamburger-lines {
    display: block;
    height: 23px;
    width: 35px;
    position: absolute;
    top: 17px;
    left: 20px;
    z-index: 2;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }

  .navbar-container .hamburger-lines .line {
    display: block;
    height: 4px;
    width: 100%;
    border-radius: 10px;
    background: #333;
  }

  .navbar-container .hamburger-lines .line1 {
    transform-origin: 0% 0%;
    transition: transform 0.4s ease-in-out;
  }

  .navbar-container .hamburger-lines .line2 {
    transition: transform 0.2s ease-in-out;
  }

  .navbar-container .hamburger-lines .line3 {
    transform-origin: 0% 100%;
    transition: transform 0.4s ease-in-out;
  }

  .navbar .menu-items {
    padding-top: 100px;
    background: #fff;
    height: 100vh;
    max-width: 300px;
    transform: translate(-150%);
    display: flex;
    flex-direction: column;
    margin-left: -40px;
    padding-left: 50px;
    transition: transform 0.5s ease-in-out;
    box-shadow: 5px 0px 10px 0px #aaa;
  }

  .navbar .menu-items li {
    margin-bottom: 1.5rem;
    font-size: 1.3rem;
    font-weight: 500;
  }

  .navbar-container input[type="checkbox"]:checked ~ .menu-items {
    transform: translateX(0);
  }

  .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line1 {
    transform: rotate(35deg);
  }

  .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line2 {
    transform: scaleY(0);
  }

  .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line3 {
    transform: rotate(-35deg);
  }

  .food-container {
    flex-direction: column;
    align-items: stretch;
  }

  .food-type:not(:last-child) {
    margin-bottom: 3rem;
  }

  .food-type {
    box-shadow: 5px 5px 10px 0 #aaa;
  }

  .img-container {
    margin: 0;
  }
}

@media (max-width: 500px) {
  html {
    font-size: 65%;
  }

  .navbar .menu-items li{
    font-size: 1.6rem;
  }

  .food-menu-container img {
    margin: auto;
  }

  .navbar .menu-items li {
    margin-bottom: 2.5rem;
    font-size: 1.8rem;
    font-weight: 500;
  }
}

@media (min-width: 769px) and (max-width: 1200px) {
  .img-container h3 {
    font-size: 1.5rem;
  }

  .img-container .btn {
    font-size: 0.7rem;
  }
}


</style>
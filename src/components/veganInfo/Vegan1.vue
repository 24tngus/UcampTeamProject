<template>
  <Header/>
  <section class="showcase-area" id="showcase">
    <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
    <div class="showcase-container">
      <h1 class="main-title" id="home">What Is Vegan Food?</h1><br>
      <p>Eat Vegan Food</p>
      <a href="/vegan2" class="btn btn-primary">Vegetarian</a>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-text">
        <p class="small">vegan food</p>
        <h2>비건 음식이란?</h2><br>
        <p>비건 음식은 동물 기반 식품을 포함하지 않는 식사 스타일을 가리킵니다. <br>
          비건 식품은 식물성 원료로 만들어지며, 육류, 가금류, 해산물, 유제품, 계란 및 다른 동물성 성분을 제외합니다. <br>
          이로써 동물의 이용을 최소화하고 동물 권리를 존중하며, 환경적 영향을 줄이는 목표를 달성하려는 것이 주된 목표입니다.</p>
      </div>
      <div class="about-img">
        <img src="../../../public/a_vegan5.png" alt="food" />
      </div>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-img">
        <img src="../../../public/a_vegan9.png" alt="food" />
      </div>
      <div class="about-text">
        <p class="small">vegan feature</p>
        <h2>비건을 시작하면</h2><br>
        <p>
          비건 식단은 많은 영양소를 제공하며, 다양한 맛과 요리 방식을 통해 다채로운 식사를 만들 수 있습니다. 또한 환경적으로 친화적이며 동물 권리 문제에 대한 의식을 높일 수 있는 건강한 식사 스타일입니다.
        </p>
      </div>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-text">
        <p class="small">vegan example</p>
        <h2>비건 음식의 주요 종류와 예시</h2><br>
        <p>
          <strong>1. </strong><b>과일과 채소</b>
          <br> &nbsp;&nbsp;비건 식단의 기본은 신선한 과일과 채소입니다. <br> 다양한 종류의 과일과 채소를 섭취하여 영양소를 공급하고 맛을 뽐낼 수 있습니다.<br><br>
          <strong>2. </strong><b>견과류</b>
          <br> &nbsp;&nbsp;아몬드, 호두, 땅콩, 캐슈넛, 마카다미아넛 등의 견과류는 비건 식단에서 중요한 단백질, 지방, 비타민, 미네랄을 제공합니다. <br> 또한 견과류는 비건 치즈, 우유 및 버터 대체품을 만드는 데 사용됩니다.<br><br>
          <strong>3. </strong><b>대두 제품</b>
          <br> &nbsp;&nbsp;대두는 비건 식품 제조에 널리 사용됩니다. <br> 대두 우유, 두부, 된장, 대두 단백질 등 다양한 대두 제품이 있으며, 이들은 비건 식단의 중요한 부분입니다.
          <br><br><br>
        </p>
      </div>
      <div class="about-img"><br><br><br>
        <img src="../../../public/a_vegan7.png" />
      </div>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-img"><br><br><br>
        <img src="../../../public/a_vegan8.png" alt="food" />
      </div>
      <div class="about-text">
        <p>
          <strong>4. </strong><b>곡물과 유제품 대체품</b>
          <br> &nbsp;&nbsp;비건 식단에서는 밥, 귀리, 콩국수, 귀리가루 등 다양한 곡물을 섭취합니다. <br> 유제품 대체품으로는 코코넛 우유, 아몬드 우유, 콩 우유 등이 있습니다.<br><br>
          <strong>5. </strong><b>비건 단백질</b>
          <br> &nbsp;&nbsp;비건 식단에 필요한 단백질은 대부분 채소성 원료에서 얻을 수 있습니다. <br> 렌틸, 콩, 병아리콩, 퀴노아 등의 고단백질 식품이 비건 식품으로 사용됩니다.<br><br>
          <strong>6. </strong><b>채소성 기름과 조미료</b>
          <br> &nbsp;&nbsp;비건 식단에는 식물성 식용유 (예: 올리브 오일, 코코넛 오일) 및 다양한 조미료 (예: 허브, 양념)를 사용하여 요리를 풍부하게 합니다.<br><br>
          <strong>7. </strong><b>비건 간식</b>
          <br> &nbsp;&nbsp;비건 간식으로는 과일과 채소 스틱, 견과류, 채소 칩, 비건 과자, 생과일, 건포도, 비건 초콜릿 등이 있습니다.
          <br>
        </p>
      </div>
    </div>
  </section>
</template>

<script>
import Header from "@/components/header/Header.vue";
export default {
  name: "Vegan",
  components: {Header},
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
  background: darkolivegreen;
  width: 15%;
  opacity: 0.7; /* 투명도를 조정합니다. 0.0에서 1.0까지 가능합니다. */
  transition: opacity 0.3s ease-in-out;
}

.btn-primary:hover {
  background: darkolivegreen;
  transition: background 0.3s ease-in-out;
  opacity: 1.0;
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
  url("https://i.postimg.cc/Xq5YZ3kV/1.png");
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

@media (orientation: landscape) and (max-height: 500px) {
  .showcase-area {
    height: 50vmax;
  }
}
</style>
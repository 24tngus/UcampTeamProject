<template>
  <Header/>
  <section class="showcase-area" id="showcase">
    <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
    <div class="showcase-container">
      <h1 class="main-title" id="home">What Is Vegetarian?</h1><br>
      <p>Start to VeganLoadMap</p>
      <a href="/shop" class="btn btn-primary">시작하기</a>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-text">
        <p class="small">vegetarian</p>
        <h2>채식주의자란?</h2><br>
        <p>채식주의자(vegetarian)는 동물 기반 식품을 제한하거나 포함하지 않는 식단을 따르는 사람을 가리킵니다. <br>
          채식주의자는 식사 스타일에 따라 다양한 종류로 나뉠 수 있으며, 아래에서 주요 채식주의자의 종류를 설명하겠습니다.
        </p>
      </div>
      <div class="about-img">
        <img src="../../../public/a_vegan15.png" alt="food" />
      </div>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-img"><br><br><br><br>
        <img src="../../../public/a_vegan10.png" alt="food" />
      </div>
      <div class="about-text">
        <p class="small">vegetarian type</p>
        <h2>채식주의자의 종류</h2><br>
        <p>
          <strong>1. </strong><b>락토 오보 채식주의자 (Lacto-Ovo Vegetarian)</b>
          <br> &nbsp;&nbsp;락토 오보 채식주의자는 유제품과 계란을 포함한 동물성 식품을 섭취하지 않는 사람을 가리킵니다. <br> 이들은 유제품과 계란을 채식 식단의 중요한 영양원으로 고려합니다.<br><br>
          <strong>2. </strong><b>락토 채식주의자 (Lacto-Vegetarian)</b>
          <br> &nbsp;&nbsp;락토 채식주의자는 유제품을 섭취하고, 육류, 가금류, 해산물 및 계란을 포함하지 않는 식단을 따릅니다. <br> 유제품은 주로 단백질 및 칼슘 공급원으로 사용됩니다.<br><br>
          <strong>3. </strong><b>오보 채식주의자 (Ovo-Vegetarian)</b>
          <br> &nbsp;&nbsp;오보 채식주의자는 계란을 섭취하고, 육류, 가금류, 해산물 및 유제품을 제한하는 식단을 따릅니다. <br> 계란은 단백질과 다른 영양소를 제공하는 중요한 식품입니다.
        </p>
      </div>
    </div>
  </section>
  <section id="about">
    <div class="about-wrapper container">
      <div class="about-text">
        <p>
          <strong>4. </strong><b>폴로 채식주의자 (Pollotarian)</b>
          <br> &nbsp;&nbsp;폴로 채식주의자는 육류와 해산물을 제한하며, 가금류 (예: 닭)를 포함한 식단을 따릅니다. <br> 이들은 주로 채식 식단으로 인간 건강 및 환경적 이점을 얻으려는 사람들 중 하나입니다.<br><br>
          <strong>5. </strong><b>비건 (Vegan)</b>
          <br> &nbsp;&nbsp;비건은 가장 엄격한 채식주의자로, 동물성 식품을 모두 제한합니다.<br>  비건은 육류, 가금류, 해산물, 유제품, 계란 및 다른 동물성 성분을 섭취하지 않습니다.<br><br>
          <strong>6. </strong><b>로완식주의자 (Raw Vegan)</b>
          <br> &nbsp;&nbsp;로완식주의자는 비건 식단을 따르지만 식물성 식품을 가열하지 않고 날 것으로 섭취합니다. <br> 이들은 주로 과일, 채소, 견과류, 씨앗 및 혹은 건강을 위해 날 것으로 섭취될 수 있는 다른 비건 식품을 포함합니다.
          <br>
        </p>
      </div>
      <div class="about-img"><br><br><br>
        <img src="../../../public/a_vegan16.png" alt="food" />
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
  url("https://i.postimg.cc/fyH6s7M0/2.png");
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

@media (orientation: landscape) and (max-height: 500px) {
  .showcase-area {
    height: 50vmax;
  }
}
</style>
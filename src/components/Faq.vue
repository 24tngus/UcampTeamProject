<template>
  <Header/>
  <section class="showcase-area" id="showcase">
    <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
    <div class="showcase-container">
      <h1 class="main-title" id="home">F A Q</h1><br>
      <p class="p-title">자주 묻는 질문</p>
    </div>
  </section>
  <section id="food">
<!--    <h2>F A Q</h2>-->
    <div class="container">
      <section class= "faq">
        <div class="accordion" id="accordionExample">
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
              <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                <strong>Q1. VeganRoadMap은 어떤 웹사이트인가요?</strong>
              </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                VeganRoadMap은 비건인들과 논비건인들을 위한 맛집 조회 및 예약 사이트입니다.<br>
                VeganRoadMap에서 평점 4.0이상의 맛집들을 만나보세요!
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingTwo">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <strong>Q2. VeganRoadMap을 잘 활용하고 싶어요.</strong>
              </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                <strong>1. 식당 조회</strong><br>
                Restaurant 에서 원하는 식당을 조회해 보세요! 내 위치별, 카테고리 별로 조회가능합니다 :)<br><br>
                <strong>2. 예약 방법</strong><br>
                원하는 식당을 예약하고 예약 현황을 마이페이지에서 확인해보세요!
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingThree">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <strong>Q3. 예약 변경 및 취소하고 싶어요.</strong>
              </button>
            </h2>
            <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                <strong>마이페이지 > 예약 목록 > 수정</strong>을 선택해주세요. <br><br>
                방문 예정 예약의<strong> 예약 상세 내역 페이지</strong>에서 예약을 변경하거나 취소할 수 있습니다.
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingFour">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                <strong>Q4. 예약 취소시 예약금 환급이 가능한가요? </strong>
              </button>
            </h2>
            <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                <strong>마이페이지 > 예약 목록 > 수정</strong>을 선택해주세요.<br><br>
                예약 예정 시간 하루 전까지 취소할 경우, 별다른 수수료 없이 전액 환불 가능합니다.
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingFive">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                <strong>Q5. 회원가입하기 번거로워요. 소셜로그인도 가능한가요?</strong>
              </button>
            </h2>
            <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                편리하게 로그인 및 회원가입 할 수 있도록 소션 로그인 기능을 지원하고 있습니다. <br><br>
                <strong>카카오 소셜 로그인</strong>과 <strong>구글 소셜 로그인</strong>을 이용하실 수 있습니다 :) <br><br>
                <strong>◆ 소셜 로그인 아이디 찾기</strong><br>
                - [로그인] → [아이디 찾기] 클릭 시, 인증기관을 통해 본인인증 후 아이디 찾기 가능<br><br>
                <strong>◆ 소셜 로그인 비밀번호 찾기</strong><br>
                - [로그인] → [비밀번호 찾기] 클릭 시, 아이디 조회 후 비밀번호 변경 가능<br><br>
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingSix">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                <strong>Q6. 이미 가입하였으나, 로그인이 되지 않아요.</strong>
              </button>
            </h2>
            <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                안녕하세요. 고객님 <br><br>
                불편을 끼쳐드려 죄송합니다.<br><br>
                로그인되지 않는 상황에 대해 자세한 설명 남겨주시면, 빠른 확인 도와드리겠습니다.<br><br>
                (오류메세지가 발생하시면 캡쳐 후 보내주시면 좀 더 빠른 확인이 가능합니다.)
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h2 class="accordion-header" id="headingSeven">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                <strong>Q7. 회원정보를 수정하고 싶어요. </strong>
              </button>
            </h2>
            <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                홈페이지 상단 <strong>마이페이지</strong>를 통해 확인하실 수 있으며, <strong>개인 정보 수정</strong>을 이용하세요.<br><br>
                회원가입시 입력했던 이름, 닉네임, 주소 등 변경하실 수 있습니다.
              </div>
            </div>
          </div>

        </div>
      </section>
    </div>
  </section>

</template>

<script>
import Header from "@/components/header/Header.vue";
export default {
  name: "Faq",
  components: {Header},
}

</script>


<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

@media (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media (min-width: 992px) {
  .container {
    width: 1000px;
  }
}

@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

.showcase-area {
  height: 50vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/3RG18JRK/7.jpg");
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
  font-size: 80px;
  font-weight: bold;
  color: white;
  text-transform: uppercase;
}
.p-title {
  font-size: 30px;
  font-weight: bold;
  color: #ffffff;
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

/* 클릭 전의 색상 */
.accordion-header button.collapsed {
  background-color: rgb(255, 255, 255);
}
/* 클릭 후의 색상 */
.accordion-header button:not(.collapsed) {
  background-color: #eafaea;
  color : #051c17;
}
</style>
<template>
  <Header/>
  <div class="container">
    <div class="boardTitle">
      <br><br>
      <h1>FAQ</h1>
      <br>
    </div>
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
              Restaurant 에서 원하는 식당을 조회해 보세요! 내 위치별, 카테고리 별로 조회가능합니다 :)<br>
              <strong>2. 예약 방법</strong><br>
              원하는 식당을 예약하고 마이페이지에서 확인해보세요!
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingThree">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
              <strong>Q3. 회원가입하기 번거로워요. 소셜로그인도 가능한가요?</strong>
            </button>
          </h2>
          <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              ※ 카카오 소셜 로그인을 이용해보세요 :)
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingFour">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
              <strong>Q4. 예약 취소와 예약금 환급이 가능한가요? </strong>
            </button>
          </h2>
          <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              물론, 둘 다 가능합니다! <strong>마이페이지</strong>에서 예약 취소하면 돌려줌

            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingFive">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
              <strong>Q5. 궁금한점~~~ </strong>
            </button>
          </h2>
          <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              궁금해요? 궁금하면 500원
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingSix">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
              <strong>Q6. 회원정보를 수정하고 싶어요. </strong>
            </button>
          </h2>
          <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              홈페이지 상단 [로그인]을 통해 확인하실 수 있으며, '아이디 찾기', '비밀번호 찾기'를 이용하세요.<br><br>
              <strong>◆ 아이디 찾기</strong><br>
              - [로그인] → [아이디 찾기] 클릭 시, 인증기관을 통해 본인인증 후 아이디 찾기 가능<br><br>
              <strong>◆ 비밀번호 찾기</strong><br>
              - [로그인] → [비밀번호 찾기] 클릭 시, 아이디 조회 후 TJoeun홈페이지에서 회원정보 수정<br><br>
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingSeven">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
              <strong>Q7. 밍밍밍미임ㅇ</strong>
            </button>
          </h2>
          <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              밍밍
            </div>
          </div>
        </div>

      </div>
    </section>
  </div>
  <br><br><br><br><br><br><br><br><br><br>
  <!-- content -->

</template>

<script>
import Header from "@/components/header/Header.vue";
export default {
  name: "Faq",
  components: {Header},
}

</script>


<style scoped>
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

</style>
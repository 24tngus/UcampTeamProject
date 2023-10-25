<template>
  <Header/>
  <br><br><br>
  <div class="wiv">
    <div>
      <strong class="what">About Vegan</strong>
    </div><br><br>

    <div class="whatbtn">
      <router-link to="/vegan"><button type="button" class="btn btn-success" id="whatis">Vegan food</button></router-link>
      <router-link to="/vegan2"><button type="button" class="btn btn-success" id="whatis">Vegetarian</button></router-link>
    </div>

    <div class="veganfood">
      <br><br>
      <strong>What Is Vegan Food?</strong><br>
      <strong>비건 음식이란?</strong><br><br>

      비건 음식은 동물 기반 식품을 포함하지 않는 식사 스타일을 가리킵니다. <br>
      비건 식품은 식물성 원료로 만들어지며, 육류, 가금류, 해산물, 유제품, 계란 및 다른 동물성 성분을 제외합니다. <br>
      이로써 동물의 이용을 최소화하고 동물 권리를 존중하며, 환경적 영향을 줄이는 목표를 달성하려는 것이 주된 목표입니다.<br><br><br>

      <strong>비건 음식의 주요 종류와 예시</strong>  <br><br>

      <strong>1. </strong>과일과 채소: 비건 식단의 기본은 신선한 과일과 채소입니다. 다양한 종류의 과일과 채소를 섭취하여 영양소를 공급하고 맛을 뽐낼 수 있습니다.<br>

      <strong>2. </strong>견과류: 아몬드, 호두, 땅콩, 캐슈넛, 마카다미아넛 등의 견과류는 비건 식단에서 중요한 단백질, 지방, 비타민, 미네랄을 제공합니다. 또한 견과류는 비건 치즈, 우유 및 버터 대체품을 만드는 데 사용됩니다.<br>

      <strong>3. </strong>대두 제품: 대두는 비건 식품 제조에 널리 사용됩니다. 대두 우유, 두부, 된장, 대두 단백질 등 다양한 대두 제품이 있으며, 이들은 비건 식단의 중요한 부분입니다.<br>

      <strong>4. </strong>곡물과 유제품 대체품: 비건 식단에서는 밥, 귀리, 콩국수, 귀리가루 등 다양한 곡물을 섭취합니다. 유제품 대체품으로는 코코넛 우유, 아몬드 우유, 콩 우유 등이 있습니다.<br>

      <strong>5. </strong>비건 단백질: 비건 식단에 필요한 단백질은 대부분 채소성 원료에서 얻을 수 있습니다. 렌틸, 콩, 병아리콩, 퀴노아 등의 고단백질 식품이 비건 식품으로 사용됩니다.<br>

      <strong>6. </strong>채소성 기름과 조미료: 비건 식단에는 식물성 식용유 (예: 올리브 오일, 코코넛 오일) 및 다양한 조미료 (예: 허브, 양념)를 사용하여 요리를 풍부하게 합니다.<br>

      <strong>7. </strong>비건 간식: 비건 간식으로는 과일과 채소 스틱, 견과류, 채소 칩, 비건 과자, 생과일, 건포도, 비건 초콜릿 등이 있습니다.<br>
      <br>

      비건 식단은 많은 영양소를 제공하며, 다양한 맛과 요리 방식을 통해 다채로운 식사를 만들 수 있습니다. 또한 환경적으로 친화적이며 동물 권리 문제에 대한 의식을 높일 수 있는 건강한 식사 스타일입니다.
      <br><br><br>

    </div>
  </div> <!--wiv-->

</template>

<script>
import Header from "@/components/header/Header.vue";
export default {
  name: "Vegan",
  components: {Header},
}
</script>

<style scoped>
.wiv{
  width : 60%;
  height : auto;
  margin : auto;
}

.what{
  font-size: 40px;
}
.whatbtn{
  margin-right: 30px;
}

#whatis{
  float: right;
  border : 1px solid darkgreen;
}
.veganfood{
  border : 2px solid darkgreen;
  background : whitesmoke;
  border-radius: 7px;
  margin : 0 30px;
  padding : 10px 20px;
}

</style>
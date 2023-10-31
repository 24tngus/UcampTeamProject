<template>
  <footer>
    <article class="content2">
      <ul>
        <li><a href="#">이용약관</a></li>
        <li><a href="#">개인정보처리방침</a></li>
        <li><a href="/home_store">판매자</a></li>
        <li><a href="http://localhost:8087/admin/main">점주관리자</a></li>
        <li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i>소윤이 예쁘다<i class="fa fa-star-o" aria-hidden="true"></i></a></li>
      </ul>
    </article>
    <hr>
    <article class="address">
      <section>
        <div>
          <p>서울특별시 강서구 마곡중앙10로 70  3층 대표 ❙ 김소윤  전화 ❙ 02-135-2468 사업자등록번호 ❙ 101-11-58585</p>
        </div>
        <div>
          <p>VeganLoadMap® is a Registered Trademark of VeganLoadMap IP LLC. © 2023 VeganLoadMap IP LLC. All Rights Reserved.</p>
        </div>
      </section>
    </article>
  </footer>
<!--    <footer class="text-body-secondary py-5">-->
<!--      <ul class="nav justify-content-center border-bottom pb-3 mb-3">-->
<!--        <li class="nav-item"><a href="#"-->
<!--                                class="nav-link px-2 text-body-secondary">Home</a></li>-->
<!--        <li class="nav-item"><a href="#"-->
<!--                                class="nav-link px-2 text-body-secondary">Features</a></li>-->
<!--        <li class="nav-item"><a href="#"-->
<!--                                class="nav-link px-2 text-body-secondary">Pricing</a></li>-->
<!--        <li class="nav-item"><a href="#"-->
<!--                                class="nav-link px-2 text-body-secondary">FAQs</a></li>-->
<!--        <li class="nav-item"><a href="#"-->
<!--                                class="nav-link px-2 text-body-secondary">About</a></li>-->
<!--      </ul>-->
<!--      <p class="text-center text-body-secondary">&copy; 2023 Company,-->
<!--        Inc</p>-->
<!--  </footer>-->
</template>

<script>
export default {
  name: 'Footer',
  props: {
   
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
@import url('https://fonts.googleapis.com/css?family=Roboto&display=swap');
@import url('https://fonts.googleapis.com/css?family=Oswald&display=swap');
@import url('https://fonts.googleapis.com/css?family=Playfair+Display&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  border: 0px solid silver;
}

img {
  width: 100px;
}

body {
  font-family: 'Noto Sans KR', sans-serif;
  font-size: 0.9rem;
  line-height: 1rem;
  letter-spacing: 0.1px;
}

ul, section {
  margin-left: 3%;
}

h1, h2, h3 {
  font-family: 'Noto Sans KR', sans-serif;
}
h1 {
  font-size: 2.6rem;
  line-height: 4rem;
}
h2 {
  font-size: 28px;
  line-height: 2.4rem;
  text-transform: uppercase;
  margin-bottom: 1rem;
}
h3 {
  font-size: 1.4rem;
  line-height: 1.4rem;
}
h4, h5 {
  font-family: 'Noto Sans KR', serif;
}
h4 {
  font-size: 1.1rem;
  line-height: 1.1rem;
}
h5 {
  font-size: 0.7rem;
  line-height: 0.7rem;
}

a:link {
  color: #666;
  text-decoration: none;
}
a:visited {
  color: #666;
}
a:active {
  color: red;
}

button {
  color: white;
  font-size: 1rem;
  font-weight: bold;
  padding: 8px 20px;
  text-transform: uppercase;
  border: 2px solid #fff;
  border-radius: 50px;
  background: none;

}

footer{
  background: #222;
}

footer .content2{
  width: 1170px;
  margin: 0 auto;
  padding: 1.2rem 0;
}

footer ul li{
  list-style: none;
  display: inline;
  padding: 0 1.2rem 0 0;
}

footer .content2 ul :nth-child(2) :first-child{
  font-weight: bold;
  color: white;
}

footer .address{
  width: 1170px;
  margin: 0 auto;
  padding: 1.2rem 0;
  display: flex;
  justify-content: space-between;
}

footer .address> :nth-child(1){
  color: #666666;
  float: left;
}

footer .address section div{
  padding: 0 0 0.5rem 0;
}

footer .address> :nth-child(2){
  float: right;
}
.address img{
  width: 2.5rem;
  border-radius: 8px;
  margin : 0 0 0 0.6rem;
}
</style>

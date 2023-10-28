<template>
  <Header2 />
<div id="wrapper">
  <div id="container">
    <div class="tab">
      <router-link to="/mystore"><h1>마이페이지</h1></router-link>
      <div class="buttontab">
        <router-link to="/mystore_info"><button class="tablink">회원 정보</button></router-link>
        <router-link to="/myshop_info"><button class="tablink">가게 정보</button></router-link>
        <router-link to="/reserve_select"><button class="tablink">예약 확인</button></router-link>
        <router-link to="/review"><button class="tablink">리뷰 확인</button></router-link>
      </div>
    </div>

    <!-- 본문 작성 -->
    <div class="online small" id="online">
      <h1>{{state.items.name}}님 가게 리뷰 확인</h1>
      <div class="status">
        <div class="item">
          <div>
            <router-link to="/cart">
              <div class="green number">1</div>
            </router-link>
            <div class="item_text">예약대기</div>
          </div>
          <div class="item_icon"> > </div>
        </div>
        <div class="item">
          <div>
            <div class="number">0</div>
            <div class="item_text">예약확정</div>
          </div>
          <div class="item_icon"> > </div>
        </div>
        <div class="item">
          <div>
            <div class="green number">1</div>
            <div class="item_text">이용완료</div>
          </div>
          <div class="item_icon"> > </div>
        </div>
        <div class="item">
          <div>
            <router-link to="/review">
            <div class="green number">3</div>
            <div class="item_text">가게후기</div>
            </router-link>
          </div>
        </div>
      </div>

      <div class='app'>
        <main class='project'>
          <div class='project-tasks'>
            <div class='project-column'>
              <div class='task' draggable='true'>
                <div class='task__tags'><span class='task__tag task__tag--copyright'>리뷰1</span><button class='task__options'></button></div>
                <p>Konsep hero title yang menarik</p>
              </div>


            </div>

          </div>
        </main>
      </div>

      <!-- 페이지 처리 -->
      <div id="num">
        <span><a href="#"> &lt; </a></span>
        <span><a href="">1</a></span>
        <span><a href="#"> > </a></span>
      </div>
    </div>
  </div>
</div>
</template>

<script>

import {reactive} from "vue";
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";

export default {
  name: "Mystore",
  components: {Header2},
  setup() {
    const state = reactive({
      items: Object
    })

    const load = () => {
      axios.get("/api/store/mypage").then(({data}) => {
        state.items = data;
      })
    };
    load();

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

#wrapper{
  width: 100%;
}

#num{
  text-align: center;
  margin: 30px 0;
  padding: 40px 0;
  position: relative;
  z-index: 2
}
#num:before{
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  top:0px;
  left: 0;
  border-top: 1px solid #d4d4d4;
  z-index: -1
}
#num span{
  display: inline-block;
  border: 1px solid #d4d4d4;
  margin: 0 2px;
  padding: 5px 10px;
  vertical-align: middle;
  cursor: pointer
}
#num span a{
  font-size: 10px;
}
.currentNum{
  background: #32312f!important;
}
.currentNum a{
  color: #fff
}
#num span:hover{
  background: #d4d4d4;
}
#num span:hover a,#num span:hover i{
  color: #fff
}

.status{
  display: flex;
  justify-content: space-between;
  margin-bottom: 21px;
}
.item{
  display: flex;
}
.number{
  font-size: 25px;
  font-weight: 500;
  text-align: center;
}
.item_text{
  font-size: 11px;
  font-weight: normal;
  color: #c2c2c2;
  text-align: center;
}
.item_icon{
  display: flex;
  align-items: center;
  padding: 20px;
  width: 16px;
  height: 16px;
}

#notice:after{
  content: '';
  display: block;
  clear: both;
}
#notice ul{
  display: inline-block;
  height:25px;
  line-height: 25px;
  width: 70%;
  text-align: left;
  padding-left: 15%;
  float: left;
  overflow: hidden;
  position: relative;
  background-size: 20px;
}
#notice ul:after{
  content: '';
  position: absolute;
  width: 20px;
  height: 25px;
  line-height: 25px;
  background-size: 20px;
  z-index: 2000;
  top:4px;
  left: 16%;
  z-index: 120;
}

#noticewrap a, #noticewrap i{
  color: #fff;
}
#noticewrap ul a{
  font-size: 0.7em;
}

#noticewrap p{
  display: inline-block;
  line-height: 25px;
}

#wrapper{
  background: #f1f1f1
}
#wrapper header {
  position: relative !important;
  background: #fff!important
}
#wrapper .headerwrap a, #wrapper .user i{
  color: #333
}
#container{
  position: relative;
  max-width: 70%;
  min-width:  880px;
  margin: 40px auto;
  background: #fff;
}
#container:after{
  content:'';
  display: block;
  clear: both
}
#container > div:not(:first-of-type){
  background: #fff;
  padding: 40px 20px 0 250px;

}
.tab{
  position: absolute;
  left: 0;
  width: 200px;
  height: 100%;
  /*    float: left;*/
  /*    background: pink;*/
  height: 100%;
  /*    position: relative;*/
  padding: 200px 20px 0 20px;
}
.tab:after{
  content: '';
  display: block;
  clear:both
}
button{
  border: none;
  background: none;
  outline: none;
  cursor: pointer;
  width: 100px;
  height: 70px;
}
button.on{
  color: #fa2828;
  font-weight: 900
}
.tab h1{
  position: absolute;
  top: 0;
  left: 0;
  /*    float: left;*/
  height: 150px;
  width: 100%;
  background: darkolivegreen;
  color: #fff;
  font-size: 18px;
  text-align: left;
  padding: 25px
}
.tab button{
  width: 100%;
  text-align: left;
  height: 80px;
  font-size: 14px;
  font-weight: 800;
  position: relative;
  cursor: pointer;
  padding-left: 10px
}
.tab button:hover{
  color: #fa2828;
}
.tab button:after{
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  border-bottom: 1px solid #d4d4d4;
}

.online.small h1{
  font-size: 25px;
  margin-bottom: 40px;
}

#num{
  text-align: center;
  margin: 30px 0;
  padding: 40px 0;
  position: relative;
  z-index: 2
}
#num:before{
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  top:0px;
  left: 0;
  border-top: 1px solid #d4d4d4;
  z-index: -1
}
#num span{
  display: inline-block;
  border: 1px solid #d4d4d4;
  margin: 0 2px;
  padding: 5px 10px;
  vertical-align: middle;
  cursor: pointer
}
#num span a{
  font-size: 10px;
}
.currentNum{
  background: #32312f!important;
}
.currentNum a{
  color: #fff
}
#num span:hover{
  background: #d4d4d4;
}
#num span:hover a,#num span:hover i{
  color: #fff
}
footer{
  background: #fff;
  position: relative;
  z-index: 1
}
footer:before{
  content: '';
  position: absolute;
  top: 0;
  left: -50%;
  width: 300%;
  height: 100%;
  background: #fff;
  z-index: -1
}
@media (max-width:700px){
  #wrapper header {
    position: fixed !important;
    top: 0;
  }
  #container{
    position: relative;
    min-width: 100%;
    max-width: 100%;
    margin-top: 120px;
  }
  .tab{
    width: 100%;
    height:100px;
    padding:0  20px 0 0;
  }
  .tab > h1{
    position:static;
    float: left;
    height: 100%;
    width: 30%;
  }
  .tab .buttontab{
    float: left;
    width: 70%;
    height:100%;
    padding-left: 20px;
  }
  .tab button{
    height: 50%;
  }

  #container > div:not(:first-of-type){
    padding:120px 0 0 0;
    width: 100%;
  }
  .online ul{
    min-width: 100%;
    max-width: 100%
  }
  .online ul .thumbox{
    padding: 0 0 0 120px ;
  }
  #online h1{
    display: none;
  }

  .online .thumbox{
    margin-bottom: 25px;
    width:100%;
  }
  .online .thumbox .textbox{
    text-align: left;
  }

  .online .thumbox .img{
    left:0;
    transform: translate(0);
  }
  #num{
    display: none
  }
}

.btn {
  background-color: darkolivegreen;
  color: #ffffff;
  width : 20%;
  height : 90%;
}

:root {
  --bg:#ebf0f7;
  --header:#fbf4f6;
  --text:#2e2e2f;
  --white:#ffffff;
  --light-grey:#c4cad3;
  --tag-1:#ceecfd;
  --tag-1-text:#2e87ba;
  --tag-2:#d6ede2;
  --tag-2-text:#13854e;
  --tag-3:#ceecfd;
  --tag-3-text:#2d86ba;
  --tag-4:#f2dcf5;
  --tag-4-text:#a734ba;
  --purple:#7784ee;
}

@mixin display {
  display:flex;
  align-items:center;
}

h1 {
  font-size:30px;
}
.project {
  padding:2rem;
  max-width:75%;
  width:100%;
  display:inline-block;
}

.task {
  cursor: move;
  background-color:white;
  padding: 1rem;
  border-radius: 8px;
  width: 100%;
  box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px;
  margin-bottom: 1rem;
  border: 3px dashed transparent;

  &:hover {
    box-shadow: rgba(99, 99, 99, 0.3) 0px 2px 8px 0px;
    border-color: rgba(162, 179, 207, .2) !important;
  }

  p {
    font-size: 15px;
    margin: 1.2rem 0;
  }
}
</style>
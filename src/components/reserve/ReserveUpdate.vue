<template>
  <Header2/>
  <div id="wrapper">
  <div id="container">
    <div class="tab">
      <router-link to="/mystore"><h1>마이페이지</h1></router-link>
      <div class="buttontab">
        <router-link to="/mystore_info"><button class="tablink">회원 정보</button></router-link>
        <router-link to="/myshop_info"><button class="tablink">가게 정보</button></router-link>
        <router-link to="/reserve_update"><button class="tablink">예약 확인</button></router-link>
        <router-link to="/review"><button class="tablink">리뷰 확인</button></router-link>
      </div>
    </div>
    <!-- 본문 작성 -->
    <h1> 예약 목록</h1>
    <div class="online small" id="online" v-for="reserve in reserves" :key="reserve.date">
      {{formatDate(reserve.date).substring(6, 8)}}
      <div class="schedule">
        <header class="date">
          <span class="day">{{formatDate(reserve.date).substring(10, 12)}}</span>
          <span class="weekday">{{formatDate(reserve.date).substring(14, 25)}}</span>
          max 테이블 개수 {{reserve.team}}<br>
          max 인원 수 {{reserve.people}}<br>
        </header>
        <section>
          <header class="row">
            <strong class="room caption">Room</strong>

            <div class="legend">
              <span style="left: 0%;">8am</span>
              <span style="left: 16.666%;">10am</span>
              <span style="left: 33.333%;">12am</span>
              <span style="left: 50%;">2pm</span>
              <span style="left: 66.666%;">4pm</span>
              <span style="left: 83.333%;">6pm</span>
              <span style="left: 98%;">8pm</span>
            </div>
          </header>
          <div class="row" >
            <span class="room">table</span>

            <div class="bookings">
              <span class="block" style="left: 0%; background: #388E3C; width: 16.6666666%"></span>
<!--              <span class="block" style="left: 60%; background: #FF5722; width: 8.33333%"></span>-->
            </div>
          </div>
          <div class="row">
            <span class="room">202</span>

            <div class="bookings">
              <span class="block" style="left: 10%; width: 90%; background: #FFC107;"></span>
            </div>
          </div>
          <div class="row">
            <span class="room">203</span>

            <div class="bookings">
              <span class="block" style="left: 25%; background: #673AB7; width: 16.6666666%"></span>
              <span class="block" style="left: 50%; background: #1976D2;width: 8.33333%"></span>
            </div>
          </div>
          <div class="row">
            <span class="room">204</span>

            <div class="bookings">

            </div>
          </div>
        </section>
      </div>
    </div>
    <!-- 페이지 처리 -->
    <div id="num">
      <span><a href="#"> &lt; </a></span>
      <span><a href="">1</a></span>
      <span><a href="#"> > </a></span>
    </div>
  </div>
  </div>


</template>

<script>
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";
import {reactive} from "vue";

export default {
  components: {Header2},
  setup() {
    const state = reactive({
      items: [],
      storename: ""
    })

    const load = () => {
      axios.get("/api/reserve/shop").then(({data}) => {
        state.items = data;
      })
    };
    load();
    return {state};
  },
  data() {
    return {
      reserves: []
    };
  },
  created() {
    this.fetchReserves();
  },
  methods: {
    formatDate(timestamp) {
      const date = new Date(timestamp);
      const year = date.getFullYear();
      const month = (date.getMonth() + 1).toString().padStart(2, '0');
      const day = date.getDate().toString().padStart(2, '0');
      const dayOfWeek = date.getDay();
      const daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
      const dayName = daysOfWeek[dayOfWeek];
      return `${year}년 ${month}월 ${day}일 ${dayName}`;
    },
    // 수정시 시간 1개만 선택할 수 있도록 구현
    checkOtherTime(reserve, time) {
      for (let key in reserve) {
        if (key.includes('time') && key !== time && reserve[key] === 1) {
          return true;
        }
      }
      return false;
    },
    toggleTime(reserve, time) {
      if (reserve[time] === 1) {
        reserve[time] = 0;
      } else {
        for (let key in reserve) {
          if (key.includes('time') && key !== time) {
            reserve[key] = 0;
          }
        }
        reserve[time] = 1;
      }
      this.updateReserve(reserve);
    },
    updateReserve(reserve) {
      axios
          .put(`/api/reserve/update/${reserve.seq}`, reserve)
          .then((response) => {
            console.log("Reserve updated successfully", response.data);
            this.fetchReserves();
          })
          .catch((error) => {
            console.error("Error updating reserve", error);
          });
    },
    fetchReserves() {
      axios
          .get("/api/reserve/shop")
          .then((response) => {
            this.reserves = response.data;
          })
          .catch((error) => {
            console.error("Error fetching reserves", error);
          });
    },
  },
};
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

.schedule{
  margin: 10px 0;
  padding: 50%;
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
  max-width: 90%;
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
.online .filter{
  width: 100%;
  background: #f1f1f1;
  height: 70px;
  line-height: 70px;
  padding: 0 20px;
  margin-bottom: 30px;
}
.online .filter button{
  border: 1px solid #d4d4d4;
  background: #fff;
  width: 100px;
  padding: 5px;
  margin-right: 10px;
  color: #6e6a67
}
.online .filter span{
  float: right;
  font-size: 11px;
  color: #6e6a67
}
.online .filter span b{
  color: #fa2424;
}
.online ul{
  text-align: center;
  padding: 0 5%;
  max-width: 100%;
  min-width: 600px;

}
.online .thumbox{
  /*    padding-left: 120px;*/
  position: relative;
  margin-bottom: 25px;
  /*    margin-right: 10px;*/
  width:250px;
  display: inline-block;
  padding: 70px 0 0 0;
  text-align: center
}
.online .thumbox .img{
  background-size: contain;
  width: 120px;
  height: 100px;
  display: table-cell;
  vertical-align: middle;
  position: absolute;
  top: 0;
  left: 50%;

  transform: translateX(-50%);
  text-align: center;
}
.online .thumbox .img a{
  display: inline-block;
  width: 100%;
  height: 100%;
}
.online .thumbox .textbox{
  /*    float: left;*/
  height: 100px;
  width: 100%;
  padding:15px 25px;

}
.online .thumbox .textbox h3{
  font-weight: 900;
  font-size: 14px;
  margin-bottom: 10px;
}
.online .thumbox .textbox p{
  color: #6e6a67;
  font-size: 11px;
}
.online .thumbox .textbox p:first-of-type{
  margin-bottom: 10px;
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
/*member sign in*/
.member{
  width: 400px;
  /* border: 1px solid #000; */
  margin-left: 7px;
  padding: 0 20px;
  margin-bottom: 20px;
}

.member .logo{
  /*로고는 이미지라 인라인 블록이니까 마진 오토 안됨 블록요소만 됨 */
  display: block;
  margin :50px auto;
}

.member .field{
  margin :5px 0; /*상하로 좀 띄워주기*/
}

.member b{
  /* border: 1px solid #000; */
  display: block; /*수직 정렬하기 */
  margin-bottom: 5px;
}

.block {
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
}

.member .member select{
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
}

.member input[type=button],
.member input[type=submit]{
  background-color:green;
  color:#fff
}

.member input:focus, .member select:focus{
  border: 1px solid #2db400;
}

.field.birth div{ /*field 이면서 birth*/
  display: flex;
  gap:10px; /*간격 벌려줌*/
}

.field.tel-number div {
  display: flex;
}

.field.tel-number div input:nth-child(1){
  flex:2;
}

.field.tel-number div input:nth-child(2){
  flex:1;
}

.field.gender div{
  border: 1px solid #dadada;
  padding: 15px 5px;
  background-color: #fff;
}

.placehold-text{
  display: block; /*span 으로 감싸서 크기영역을 블록요소로 만들어ㅜ저야한다*/
  position:relative;
  /* border: 1px solid #000; */
}

.placehold-text:before{
  position:absolute; /*before은 inline 요소이기 때문에 span으로 감싸줌 */
  right : 20px;
  top:13px;
  pointer-events: none; /*자체가 가지고 있는 pointer event 를 없애준다 */
}

.member-footer {
  text-align: center;
  font-size: 12px;
  margin-top: 20px;
}

.member-footer div a:hover{
  text-decoration: underline;
  color:#2db400
}

.member-footer div a:after{
  content:'|';
  font-size: 10px;
  color:#bbb;
  margin-right: 5px;
  margin-left: 7px;
  display: inline-block;
  transform: translateY(-1px);
}

.member-footer div a:last-child:after{
  display: none;
}

.btn {
  background-color: darkolivegreen;
  color: #ffffff;
  width : 20%;
  height : 90%;
}

@media (max-width:768px) {
  .member{
    width: 100%;
  }
}
.schedule{
  margin: 40px 0;
  padding: 20px;
  padding: 2px 0;
}

.date{
  display: grid;
  grid-template-columns: 100px 1fr;
  grid-column-gap: 12px;
  align-items: center;
}

.day{
  border-radius: 50%;
  display: block;
  width: 80px;
  height: 80px;
  font-size: 56px;
  line-height: 1;
  font-weight: 700;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  margin-right: 15px;
}

.today .day{
  background: black;
  color: white;
  font-weight: 400;
}

.weekday{
  font-size: 26px;
  font-weight: 400;
}

.today .weekday{
  font-weight: 700;
}

.row{
  display: grid;
  grid-template-columns: 100px 1fr;
  grid-column-gap: 12px;
  height: 30%;
  width: 95%;
  margin: 0px 0;

  height: 26px;
}

.room{
  font-family: 'Roboto Mono', monospace;
  min-width: 50px;
  border-bottom: 1px solid #e4e4e4;
  position: relative;
  padding: 4px 0;
  min-width: 65px;
  font-weight: 100;
  &.caption{
    font-weight: 500;
  }
  &:after{
    content: "";
    position: absolute;
    background: #e4e4e4;
    width: 1px;
    display: block;
    height: 120%;
    top: 0;
    right: -6px;
  }
}

.legend span{
  display: block;
  min-width: 95%;
  position: absolute;
  font-family: 'Roboto Mono', monospace;
  font-weight: 100;
}

.bookings, .legend{
  border-bottom: 1px solid #e4e4e4;
  position: relative;
  width: 100%;
  padding: 0 8px;
}

.block{
  position: absolute;
  background: grey;
  height: 20px;
  padding: 0 6px;
  color: white;
  top: 6px;
  white-space: nowrap;
  text-overflow: ellipsis;
  border-radius: 1px;
  overflow: hidden;
  opacity: 0.4;
  margin: 0 1px;
}

.today {
  .block {
    opacity: 1;
  }
}
</style>
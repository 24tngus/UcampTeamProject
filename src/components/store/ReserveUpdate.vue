<template>
  <Header2 />
  <div id="wrapper">
    <div id="container">
      <div class="tab">
        <router-link to="/mystore"><h1>마이페이지</h1></router-link>
        <div class="buttontab">
          <router-link to="/mystore_info"><button class="tablink">회원 정보</button></router-link>
          <router-link to="/myshop_info"><button class="tablink">가게 정보</button></router-link>
          <router-link to="/reserve_update"><button class="tablink">예약 관리</button></router-link>
          <router-link to="/reserve_store"><button class="tablink">예약 확인</button></router-link>
          <router-link to="/review_store"><button class="tablink">리뷰 확인</button></router-link>
        </div>
      </div>
      <!-- 본문 작성 -->
      <div v-if="this.reserves && this.reserves.length === 0">
        <div class="online small" id="online">
          <br>
          <h1>{{state.store.name}}님 가게 예약 설정</h1>
          <br><br>
          <div class="member">
            <div class="field">
              <br><br><br><br><br><br><br><br><br><br><br><br>
              <b style="font-size: 13px">예약 등록 정보가 없습니다.</b>
              <br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
          </div>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>
      </div>
      <div class="online small" id="online" v-else>
        <br>
        <h1>{{state.store.name}}님 가게 예약 설정</h1>
        <br>
        <div class="background">
          <div class="resume">
            <div class="top">
              <h1 class="top_name">예약 시간 설정</h1>
            </div>
            <div class="left">
              <div class="container">
                <div class="thead">
                  <div class="pic"></div>
                  <div class="edu">
                    <h2 class="bhead" style="font-size: 20px; color: white">TIME</h2>
                    <div class="line"></div><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time0810')" >{{ reserve.time0810 === 1 ? '✔️' :  '08:00 ~ 10:00'}}</button><br><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time1012')">{{ reserve.time1012 === 1 ? '✔️' : '10:00 ~ 12:00' }}</button><br><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time1214')">{{ reserve.time1214 === 1 ? '✔️' : '12:00 ~ 14:00' }}</button><br><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time1416')">{{ reserve.time1416 === 1 ? '✔️' : '14:00 ~ 16:00' }}</button><br><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time1618')">{{ reserve.time1618 === 1 ? '✔️' : '16:00 ~ 18:00' }}</button><br><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time1820')">{{ reserve.time1820 === 1 ? '✔️' : '18:00 ~ 20:00' }}</button><br><br>
                    <button class="bbtn" @click="toggleTime(reserve, 'time2022')">{{ reserve.time2022 === 1 ? '✔️' : '20:00 ~ 22:00' }}</button><br><br>
                  </div>
                </div>
              </div>
            </div><div class="right">
            <div class="rtop"><br>
              <h2 class="rthead" style="font-size: 40px; color: darkslategrey; opacity: 0.7">날짜와 시간을 <br>선택해주세요</h2><br><br>
              <div class="rline"></div>
            </div>
            <div class="rmiddle">
              <h2 class="rbhead" style="font-size: 15px; ">예약 날짜</h2>
              <div class="rmpoint">
                <input type="date" class="ruser" style="font-size: 15px; height: 120%; width:90%; margin: -5% 0 0 5%" v-model="reserve.date"><br><br>
              </div>
            </div>
            <div v-if="this.selectedReserve.seq === 0">
              <div class="rmiddle">
                <div class="rmpoint" style="margin-left: 10%; font-size: 20px">
                  예약 등록 정보가 없습니다.<br><br><br><br><br><br>
                  <button @click="$router.push('/reserve_insert')" class="rbhead" style="font-size: 15px; width: 110%; height: 100%; margin-left: -10%; border-style: solid; font-size:15px; background-color: darkolivegreen; border-color: white; color: white; opacity: 0.7; border-radius: 10%">추가하기</button>
                </div>
              </div>
            </div>
            <div v-else>
              <div class="rmiddle">
                <h2 class="rmhead" style="font-size: 15px; ">max 테이블 개수</h2>
                <div class="rmpoint">
                  <input type="number" style="font-size: 15px; width:90%; margin: -5% 0 0 5%" v-model="this.selectedReserve.team">
                </div>
                <h2 class="rbhead" style="font-size: 15px; height: 40%; margin-top: 5%">max 인원 수</h2>
                <div class="rmpoint">
                  <input type="number" style="font-size: 15px; width:90%; margin: -5% 0 0 5%" v-model="this.selectedReserve.people">
                </div>
              </div><br><br><br>
              <div class="button-container">
                <button @click="$router.push('/reserve_insert')" style="margin-left: 18%; height: 50%; border-style: solid; font-size:15px; background-color: darkolivegreen; border-color: white; color: white; opacity: 0.7; border-radius: 10%">추가하기</button>
                <button @click="updateReserve(reserve)" style="margin-right: 9%; height: 50%; border-style: solid; font-size:15px; background-color: darkolivegreen; border-color: white; color: white; opacity: 0.7; border-radius: 10%">수정하기</button>
              </div>
            </div>
          </div>
          </div>
        </div>


      </div>
    </div>
  </div>

</template>

<script>
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";
import router from "@/scripts/router";
import {reactive} from "vue";

export default {
  components: { Header2 },
  data() {
    return {
      reserves: [],
      reserve: {
        seq: 0,
        team: "",
        people: "",
        date: "",
        time0810: 0,
        time1012: 0,
        time1214: 0,
        time1416: 0,
        time1618: 0,
        time1820: 0,
        time2022: 0,
      },
      selectedReserve: {},
      selectedTeam: 0,
      selectedPeople: 0,
      selectedSeq: 0
    };
  },
  created() {
    this.reserve.date = new Date().toISOString().split('T')[0]; // 현재 날짜로 설정
    this.fetchReserves(this.reserve.date);
  },
  methods: {
    formatDate(date) {
      const formattedDate = new Date(date).toISOString().split("T")[0];
      return formattedDate;
    },
    toggleTime(reserve, time) {
      if (reserve[time] === 1) {
        reserve[time] = 0;
      } else {
        for (let key in reserve) {
          if (key.includes("time") && key !== time) {
            reserve[key] = 0;
          }
        }
        reserve[time] = 1;
      }
      const selectedReserve = this.reserves.find((r) => r.seq === reserve.seq);
      if (selectedReserve) {

        this.selectedTeam = selectedReserve.team;
        this.selectedPeople = selectedReserve.people;
        this.selectedSeq = selectedReserve.seq;
      }
      this.fetchReserves(this.reserve.date);
    },
    updateReserve(reserve) {
      reserve.seq = this.selectedReserve.seq;
      reserve.team = this.selectedReserve.team;
      reserve.people = this.selectedReserve.people;
      axios
          .put(`/api/reserve/set/update/${reserve.seq}`, reserve)
          .then((response) => {
            console.log("Reserve updated successfully", response.data);
            this.fetchReserves();
          })
          .catch((error) => {
            console.error("Error updating reserve", error);
          });
      alert("수정되었습니다.");
      router.push({path: "/mystore"});
    },
    fetchReserves(date) {
      const formattedDate = new Date(date).toISOString().split("T")[0];
      const checksetting = {
        date: formattedDate,
        time0810: this.reserve.time0810,
        time1012: this.reserve.time1012,
        time1214: this.reserve.time1214,
        time1416: this.reserve.time1416,
        time1618: this.reserve.time1618,
        time1820: this.reserve.time1820,
        time2022: this.reserve.time2022,
        team: this.reserve.team,
        people: this.reserve.people
      };
      console.log("예약", JSON.stringify(checksetting));

      axios
          .get("/api/reservecheck", {
            params: checksetting,
          })
          .then((response) => {
            this.selectedReserve = response.data;
            console.log("팀" + this.selectedReserve.team);
            console.log("사람" + this.selectedReserve.people);
          })
          .catch((error) => {
            console.error("Error fetching reserves", error);
          });
    },

  },
  setup() {
    const state = reactive({
      store: Object,
    })

    const load = () => {
      axios.get("/api/store/mypage").then(({data}) => {
        state.store = data;
      })
    };
    load();

    return {state};
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 15px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
}

.button-container {
  display: flex;
  justify-content: space-between; /* 두 버튼을 왼쪽과 오른쪽으로 배치합니다. */
  align-items: center;
}

.bbtn {
  width: 100%;
  height: 20%;
  font-size: 20px;
  border-style: solid;
  border-color: black;
  background-color: white;
  opacity: 0.7;
  color:black;
  cursor: pointer;
}
.bbtn.selected {
  background-color: white;
}
.online.small h1{
  font-size: 25px;
  margin-bottom: 40px;
  margin-left: 40px;
}
.online ul{
  min-width: 100%;
  max-width: 100%
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
.contain {
  display: flex;
  flex-wrap: wrap; /* 자동 줄 바꿈을 위해 설정 */
  justify-content: space-between; /* figure 요소들을 가로로 균등하게 배치 */

}
*,html,body{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333;
  font-size: 13px;
  font-family: 'Nanum Gothic', sans-serif, '굴림', 'gulim'
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
  margin: 0 0 0 10%;
  background: #fff;
}
#container:after{
  content:'';
  display: block;
  clear: both
}
#container > div:not(:first-of-type){
  background: #fff;
  padding: 3% 10% 0 25%;

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
* {
  /*  border: solid 1px; */
  vertical-align: top;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  color: #333333;

  font-family: "Piazzolla", serif;
  font-family: "Roboto", sans-serif;
}
h2 {
  font-size: 16px;
}
p {
  font-size: 2px;
}
html,
body {
  width: 100%;
  height: 100%;
}
.background {
  width: 100%;
  height: 160%;
  background-color: #fefaf9;
}
.resume {
  padding-bottom: 30px;
  margin-top: 40px;
  margin-bottom: 40px;
  margin-left: auto;
  margin-right: auto;
  width: 600px;
  background-color: white;
  box-shadow: 0px 5px 2px 2px darkolivegreen;
}

.top {
  background-color: darkolivegreen;
  padding-top: 60px;
}
.top_name {
  letter-spacing: 6px;
  text-align: right;
  padding-bottom: 20px;
  margin-right: 20px;
  color: white;
}
.left,
.right {
  box-sizing: border-box;
  display: inline-block;
}
.left {
  width: 30%;
  height: 100%;
}
.right {
  padding-left: 20px;
  width: 70%;
  height: 100%;
}
.container {
  width: 120%;
  height: 100%;
  margin-left: 20px;
  background-color: darkolivegreen;
  opacity: 0.5;
  padding: 25px;
}
.pic {
  height: 133.391px;
  background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSIVzx63hJ1xvDiCNLBokvf-xqi04vhGr1T1A&usqp=CAU");
  background-position: 50% 50%;
  background-size: cover;
  margin-bottom: 30px;
}
.name {
  line-height: 1.5;
  margin-bottom: 30px;
}
.way,
.exp {
  margin-bottom: 40px;
}

.way p {
  margin-top: 20px;
  font-size: 16px;
}
.way i {
  line-height: 2;
  vertical-align: middle;
}

.exp p {
  line-height: 2;
}
.line {
  width: calc(100% + 50px);
  margin-left: -25px;
  margin-top: 5px;
  margin-bottom: 5px;
  border-bottom: solid 1px darkolivegreen;
}
.edu p {
  padding-top: 5px;
}
.ent1,
.ent2,
.ent3 {
  margin-top: 20px;
}
.rtop,
.rmiddle,
.rbottom {
  margin-left: 45px;
  margin-right: 10px;
}
.rthead {
  text-align: center;
  letter-spacing: 6px;
  padding-top: 10px;
}
.rline {
  width: 100px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 8px;
  border-bottom: solid 3px #888888;
}
.rmhead,
.rbhead {
  /*   border: solid 1px red; */
  width: 300px;
  text-align: center;
  letter-spacing: 5px;
  font-weight: 700;
  padding: 2px;
  margin-top: 15px;
  margin-left: auto;
  margin-right: auto;
  background-color: #e9e9e9;
}
.rmpoint {
  margin-top: 30px;
  padding: 10px;
}
.rmpoint p {
  line-height: 2;
  font-size: 14px;
}
.rbhead {
  margin-top: 50px;
}
.job1,
.job2 {
  padding-left: 10px;
  margin-top: 40px;
}
.rbottom p {
  margin-top: 10px;
}
.rbottom ul {
  margin-top: 20px;
  padding-left: 20px;
  font-size: 14px;
}
.rbottom li {
  line-height: 2;
}

.field b {
  display: block; /* 제목을 블록 요소로 변경하여 제목 아래 공백 제거 */
}
.ruser{
  width : 60%;
}
.field{
  width : 50%;
  text-align: center;
  display: inline-block; /* div 요소를 가로로 정렬 */
}
.field1{
  margin-left : 20px;
  margin-top : 20px;
}
.field{
  margin :10px 0; /*상하로 좀 띄워주기*/
  gap:10px;
}
.fieldbook{
  white-space: nowrap;
}
</style>
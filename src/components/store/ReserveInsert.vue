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

      <div>
        <div class="online small" id="online">
          <br><br>
          <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            {{state.store.name}}님 가게 예약 설정</h1>
          <br><br><br>

          <div class="card shadow-sm" id="cat">
            <div class="card-body" >
              <div><h2 class="cattitle" style="font-size: 150%; color: darkolivegreen; text-align: center">예약 시간 추가 설정</h2></div>
              <div>
                <ul>
                  <hr><br><br>
                  <div  class="memberform">
                    <div class="button-container">
                      <b>테이블 개수</b>
                      <b style="margin-right:33%; text-align: left;">최대 인원 수</b>
                    </div>
                    <div class="button-container">
                      <input type="number" style="width:45%" v-model="team">
                      <input type="number" style="width:45%;" v-model="people">
                    </div>

                    <div class="fieldbook">
                      <br><br>
                      <div class="field">
                        <div class="datepicker-container" >
                          <div class="datepicker">
                            <b style="margin-top: 40%">에약 날짜</b>
                            <Datepicker
                                v-model="pickerDate"
                                @open="clearpickerDate"
                                :text-color="style['--vdp-text-color']"
                                :background-color="style['--vdp-bg-color']"
                                :style="{
                            'border-radius': '8px',
                            'padding': '15px 5px',
                            'text-weight': '600px',
                            'margin-top': '55%',
                            'margin-left': '8%',
                            'text-align' : 'center'
                          }"
                                input-format="yyyy-MM-dd"
                            />

                          </div>
                          <!--                  <div class="formatDate">-->
                          <!--                    {{formattedPickerDate}}-->
                          <!--                  </div>-->
                        </div>
                        <br>
                        <div class="utime">
                          <b>예약시간</b><br>
                          <div class="time">
                            <button id ="timebtn" class="btn btn-outline-success" @click="handleInsert('time0810')">08:00 ~ 10:00</button>&nbsp;<span v-if="time0810 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                            <button id ="timebtn" class="btn btn-outline-success" @click="handleInsert('time1012')">10:00 ~ 12:00</button>&nbsp;<span v-if="time1012 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                            <button id ="timebtn" class="btn btn-outline-success" @click="handleInsert('time1214')">12:00 ~ 14:00</button>&nbsp;<span v-if="time1214 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                            <button id ="timebtn" class="btn btn-outline-success" @click="handleInsert('time1416')">14:00 ~ 16:00</button>&nbsp;<span v-if="time1416 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                            <button id ="timebtn"  class="btn btn-outline-success" @click="handleInsert('time1618')">16:00 ~ 18:00</button>&nbsp;<span v-if="time1618 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                            <button id ="timebtn"  class="btn btn-outline-success" @click="handleInsert('time1820')">18:00 ~ 20:00</button>&nbsp;<span v-if="time1820 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                            <button id ="timebtn"  class="btn btn-outline-success" @click="handleInsert('time2022')">20:00 ~ 22:00</button>&nbsp;<span v-if="time2022 === 1"><i class="fa fa-check" aria-hidden="true"></i></span>
                          </div>
                        </div>

                      </div>
                    </div>
                    <br><br><hr><br>
                    <button @click="insertReserve" class="bookbtn" style="height: 50%; opacity: 0.7">추가하기</button>
                  </div>
                </ul>
              </div>
            </div>
          </div>
          <br><br><br><br><br><br><br><br><br><br><br><br>
        </div>
      </div>


    </div>
  </div>
</template>
<script>
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";
import Datepicker from 'vue3-datepicker';
import router from "@/scripts/router";
import {reactive} from "vue";

export default {
  components: {Header2, Datepicker},
  computed: {
    formattedPickerDate() {
      if (this.pickerDate) {
        const date = new Date(this.pickerDate);
        const year = date.getFullYear();
        const month = (date.getMonth() + 1).toString().padStart(2, '0');
        const day = date.getDate().toString().padStart(2, '0');
        return `${year}-${month}-${day}`;
      }
      return '';
    },
  },

  data() {
    return {
      team: 0,
      people: 0,
      date: '',
      time0810: 0,
      time1012: 0,
      time1214: 0,
      time1416: 0,
      time1618: 0,
      time1820: 0,
      time2022: 0,

      pickerDate: new Date(),
      style: {
        "--vdp-bg-color": "#ffffff",
        "--vdp-text-color": "#000000",
        "--vdp-box-shadow": "0 4px 10px 0 rgba(128, 144, 160, 0.1), 0 0 1px 0 rgba(128, 144, 160, 0.81)",
        "--vdp-border-radius": "3px",
        "--vdp-heading-size": "2.5em",
        "--vdp-heading-weight": "bold",
        "--vdp-heading-hover-color": "#eeeeee",
        "--vdp-arrow-color": "currentColor",
        "--vdp-elem-color": "currentColor",
        "--vdp-disabled-color": "#d5d9e0",
        "--vdp-hover-color": "#ffffff",
        "--vdp-hover-bg-color": "#1c5f46",
        "--vdp-selected-color": "#ded9d9",
        "--vdp-selected-bg-color": "#ffffff",
        "--vdp-current-date-outline-color": "#888888",
        "--vdp-current-date-font-weight": "bold",
        "--vdp-elem-font-size": "0.8em",
        "--vdp-elem-border-radius": "3px",
        "--vdp-divider-color": "#d5d9e0"
      },

    };
  },
  methods: {
    handleInsert(time) {
      this.time0810 = time === 'time0810' ? 1 : 0;
      this.time1012 = time === 'time1012' ? 1 : 0;
      this.time1214 = time === 'time1214' ? 1 : 0;
      this.time1416 = time === 'time1416' ? 1 : 0;
      this.time1618 = time === 'time1618' ? 1 : 0;
      this.time1820 = time === 'time1820' ? 1 : 0;
      this.time2022 = time === 'time2022' ? 1 : 0;
    },
    insertReserve() {
      const data = {
        team: this.team,
        people: this.people,
        date: this.formattedPickerDate,
        time0810: this.time0810,
        time1012: this.time1012,
        time1214: this.time1214,
        time1416: this.time1416,
        time1618: this.time1618,
        time1820: this.time1820,
        time2022: this.time2022
      };
      axios

          .post('/api/reserve/set/insert', data)
          .then((response) => {
            console.log('Data inserted successfully', response.data);
            alert("예약 설정이 완료되었습니다.");
            router.push({path: "/reserve_update"});
          })
          .catch((error) => {
            if (error.response && error.response.status === 409) {
              alert("이미 존재하는 예약 세팅값입니다."); // 이미 존재하는 경우 메시지를 보여줌
            } else {
              console.error('Error inserting data', error);
              // Handle other errors as needed
            }
          });
    },
    clearpickerDate: function () {
      this.pickerDate = null;
    }
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
#container{
  position: relative;
  margin: 0 0 0 10%;
  background: #fff;
}
#container:after{
  content:'';
  display: block;
  clear: both
}

.button-container {
  display: flex;
  justify-content: space-between; /* 두 버튼을 왼쪽과 오른쪽으로 배치합니다. */
  align-items: flex-start;
}

.datepicker-container {
  width: 40%;
  padding: 30px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.datepicker {
  padding : 20px 5px;
}

.formatDate {
  margin-top: 10px;
}
.fieldbook div{
  display: flex;
  gap:10px;
}
.field{
  gap:10px;
}
.utime {
  display: flex;
  align-items: center;
  padding: 10px;
}

.time {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.time button {
  margin: 0;
}
#timebtn{
  padding : 10px;
  border-radius: 8px;
  border : 3px solid lightgray;
}
.memberform input:not(input[type=radio]){
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
  border-radius: 6px;
}
.memberform{
  padding : 0 30px 30px 30px;
}
.bookbtn{
  background-color: darkolivegreen;
  color: white;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
  border-radius: 6px;
  font-weight: 700;
  font-size: 15px;
  border : 1px solid white;
}
#cat{
  width : 60%;
  height : auto;
  margin : auto;
  text-align: left;
}
.cattitle{
  padding : 20px;
  font-weight: 700;
}


@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
@import url(https://fonts.googleapis.com/css?family=Oswald:300,400);
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:700,800&subset=korean');

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
  background: #f1f1f1;
}
#wrapper header {
  position: relative !important;
  background: #fff!important
}
#wrapper .headerwrap a, #wrapper .user i{
  color: #333
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

</style>
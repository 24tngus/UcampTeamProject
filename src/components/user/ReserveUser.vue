<template>
  <Header />
  <section class="showcase-area" id="showcase">
    <div class="background-image" :style="'background-image: url(/aaa1.png)'"></div>
    <div class="showcase-container"><br><br><br><br>
      <h1 class="main-title" id="home">Recommendation</h1><br>
    </div>
  </section>
  <br><br>
  <div class="card shadow-sm" id="cat">
    <div class="card-body" >
      <div><h2 class="cattitle">Book Here!</h2></div>
      <div>
        <ul>
          <hr>
          <div class="memberform">
            <div class="member">
              <div class="userbookinfo">
                <div class="field1">
                  <b class="rname">가게명 : {{ storename }}</b><br><br>
                  <b class="rname">예약자 닉네임 : {{ this.nickname }}</b>
                </div>
              </div><hr>
              <div class="fieldbook">
                <div class="field">
                  <b>예약 인원</b>
                  <input type="number" v-model="people" class="ruser" style="width: 200%">
                  <br>
                </div>
              </div>
              <div class="fieldbook">
                <div class="field">
                  <b>예약 시간</b>
                  <span v-if="reserveData && reserveData.time0810 === 1">
                    <input type="text" class="ruser" value="08:00 ~ 10:00">
                  </span>
                  <span v-else-if="reserveData && reserveData.time1012 === 1">
                    <input type="text" class="ruser" value="10:00 ~ 12:00">
                  </span>
                  <span v-else-if="reserveData && reserveData.time1214 === 1">
                    <input type="text" class="ruser" value="12:00 ~ 14:00">
                  </span>
                  <span v-else-if="reserveData && reserveData.time1416 === 1">
                    <input type="text" class="ruser" value="14:00 ~ 16:00">
                  </span>
                  <span v-else-if="reserveData && reserveData.time1618 === 1">
                    <input type="text" class="ruser" value="16:00 ~ 18:00">
                  </span>
                  <span v-else-if="reserveData && reserveData.time1820 === 1">
                    <input type="text" class="ruser" value="18:00 ~ 20:00">
                  </span>
                  <span v-else-if="reserveData && reserveData.time2022 === 1">
                    <input type="text" class="ruser" value="20:00 ~ 22:00">
                  </span>
                  <span v-else>
                    <input type="text" class="ruser" value="">
                  </span>

                  <br>
                </div>

                <div class="field">
                  <b>예약 날짜</b>
                  <input type="date" v-model="date" class="ruser" >
                  <!--                {{ date }}-->
                  <br>
                  <div class="time-section">
                    <div class="timebtn" v-if="isDataLoaded">
                      <template v-if="reserveData">
                        08:00 - 10:00
                        <button @click="toggleTime(reserveData, 'time0810')" :disabled="reserveGetData.time0810 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>
                        </button>
                        <!-- {{ reserveData.time0810 }}-->
                        &nbsp;&nbsp;
                        10:00 - 12:00
                        <button @click="toggleTime(reserveData, 'time1012')" :disabled="reserveGetData.time1012 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>                </button>
                        <!-- {{ reserveData.time1012 }}-->
                        <br>
                        12:00 - 14:00
                        <button @click="toggleTime(reserveData, 'time1214')" :disabled="reserveGetData.time1214 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>
                        </button>
                        <!-- {{ reserveData.time1214 }}-->
                        &nbsp;&nbsp;
                        14:00 - 16:00
                        <button @click="toggleTime(reserveData, 'time1416')" :disabled="reserveGetData.time1416 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>
                        </button>
                        <!-- {{ reserveData.time1416 }}-->
                        <br>
                        16:00 - 18:00
                        <button @click="toggleTime(reserveData, 'time1618')" :disabled="reserveGetData.time1618 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>
                        </button>
                        <!--{{ reserveData.time1618 }}-->
                        &nbsp;&nbsp;
                        18:00 - 20:00
                        <button @click="toggleTime(reserveData, 'time1820')" :disabled="reserveGetData.time1820 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>
                        </button>
                        <!--{{ reserveData.time1820 }}-->
                        <br>
                        20:00 - 22:00
                        <button @click="toggleTime(reserveData, 'time2022')" :disabled="reserveGetData.time2022 !== 1">
                          <i class="fa fa-check" aria-hidden="true"></i>
                        </button>
                        <!--{{ reserveData.time2022 }}-->
                        <br>


                      </template>
                      <template v-else>
                        해당 날짜에 대한 정보가 없습니다. 다른 날짜를 선택해주세요.<br>
                      </template>
                    </div>
                  </div>
                </div>


              </div></div><hr>
            <div class="request-section">
              <div><b>요청사항</b> <input type="text" placeholder="알레르기 정보나 가게에 전달하고 싶은 사항을 작성해주세요." v-model="comment" class="com" style="height:200px"></div>
              <!--  {{ comment }} -->
            </div><br><br>
            <button @click="insertReserve" class="bookbtn">예약금 결제</button>
          </div>
        </ul>
      </div>
    </div>
  </div>
  <br><br><br><br><br><br><br><br>
</template>

<script>
import axios from "axios";
import Header from "@/components/header/Header.vue";
import router from "@/scripts/router";

export default {
  components: {Header},
  data() {
    return {
      userid: "",
      nickname: "",
      reserveGetData: {
        time0810: 0,
        time1012: 0,
        time1214: 0,
        time1416: 0,
        time1618: 0,
        time1820: 0,
        time2022: 0,
      },
      storename: '',
      shopseq: 0,
      reserver: '',
      team: 0,
      people: 0,
      date: "",
      time0810: 0,
      time1012: 0,
      time1214: 0,
      time1416: 0,
      time1618: 0,
      time1820: 0,
      time2022: 0,
      comment: "",
      reverse: [],
      isDataLoaded: true,
      reserveData: null,
      currentTime : new Date(),
      mUidDate : '',
    };
  },
  mounted() {
    this.storename = this.$route.query.storename;
    this.load();
  },
  methods: {
    load () {
      axios.get("/api/user/mypage").then(({data}) => {
        this.userid = data.id;
        this.nickname = data.nickname;
      })
    },
    toggleTime(reserve, time) {
      if (this.isDataLoaded) { // Check if data is loaded
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
      }
    }
    ,

    handleInsert(time) {
      this.time0810 = time === "time0810" ? 1 : this.time0810;
      this.time1012 = time === "time1012" ? 1 : this.time1012;
      this.time1214 = time === "time1214" ? 1 : this.time1214;
      this.time1416 = time === "time1416" ? 1 : this.time1416;
      this.time1618 = time === "time1618" ? 1 : this.time1618;
      this.time1820 = time === "time1820" ? 1 : this.time1820;
      this.time2022 = time === "time2022" ? 1 : this.time2022;
    },
    insertReserve() {
      const data = {
        team: this.team,
        people: this.people,
        date: this.date,
        time0810: this.reserveData.time0810,
        time1012: this.reserveData.time1012,
        time1214: this.reserveData.time1214,
        time1416: this.reserveData.time1416,
        time1618: this.reserveData.time1618,
        time1820: this.reserveData.time1820,
        time2022: this.reserveData.time2022,
        comment: this.comment,
      };
      axios
          .post(`/api/reserve/insert`, data, {params: {
              storename: this.storename
            }})
          .then((response) => {
            console.log("Data inserted successfully", response.data);
          })
          .catch((error) => {
            console.error("Error inserting data", error);
            // Handle error as needed
            alert("현재 예약 인원이 가득찼습니다.");
            window.location.reload();
          });
      this.requestPay();
    },
    // 결제
    requestPay() {
      const { IMP } = window;

      IMP.init('imp70364071');
      // https://developers.portone.io/docs/ko/sdk/javascript-sdk/payrq >> 파라미터 정리 되어있음.
      IMP.request_pay({ // param
        pg: "kcp.INIBillTst_inicis",  // pg사 구분코드
        pay_method: "card", // 결제수단 구분코드
        merchant_uid: "vrm_wando_" + this.mUidDate,  // 가맹점 주문번호. 40bytes 이하. 매 거래시 다 달라야함. 거래고유코드라고 생각해도 될듯?
        name: this.storename,  // 결제대상 제품명 (상품명) > 상점명(storename + 예약)
        amount: 50, // 결제 금액@@@@
        buyer_email: '', // 주문자 이메일  > default로 저게 박힘
        buyer_name: this.nickname
      }, rsp => { // callback
        if (rsp.success) {  // 결제 성공
          console.log("rsp.success => " + rsp)

          const paymentData = {
            paymentid: rsp.merchant_uid,  // 포트원 고유 결제번호. success가 false이고 사전 validation에 실패한 경우, imp_uid는 null일 수 있음
            storename: this.storename,
            userid: this.userid,
            price: rsp.paid_amount,
            status: rsp.status, // 결제 성공 시에는 status
            /* 결제상태
                ready(브라우저 창 이탈, 가상계좌 발급 완료 등 미결제 상태)
                paid(결제완료)
                failed(신용카드 한도 초과, 체크카드 잔액 부족, 브라우저 창 종료 또는 취소 버튼 클릭 등 결제실패 상태) */
          };

          axios.post("/api/payment", paymentData)
              .then((data) => {
                // 서버 결제 API 성공시 로직
                console.log(data)
                alert("예약금 결제 및 예약이 완료되었습니다!");

                router.push({ name: "PaymentSuccess", params: { value : paymentData.paymentid } })
              })
              .catch((error) => {
                // 서버 결제 API 실패 시 로직
                console.log(error)
                alert("예약금 결제에 실패하였습니다.");
              });

        } else {  // 결제 실패
          const paymentData = {
            paymentid: "wando_" + rsp.imp_uid,  // 포트원 고유 결제번호. success가 false이고 사전 validation에 실패한 경우, imp_uid는 null일 수 있음
            storename: rsp.merchant_uid,
            userid: this.userid,
            price: "1",
            status: rsp.success,  // 결제 실패 시에는 status가 할당되지 않아서 success.
          };

          axios.post("/api/payment", paymentData)
              .then((data) => {
                // 서버 결제 API 실패 시 로직
                console.log(data);
                alert("결제에 실패했습니다. 에러 내용 : " + rsp.error_msg)
              })
              .catch((error) => {
                // 서버 결제 API 실패시 로직
                console.log(error)
                alert("예약금 결제에 실패하였습니다.");
              });

        }
      });
    },
    fetchData() {
      axios
          .get(`/api/reservesetting/${this.date}`, {params:{
              storename: this.storename
            }})
          .then((response) => {
            this.reserveData = response.data[0];
            this.isDataLoaded = true;
            if (this.reserveData) {
              for (let key in this.reserveData) {
                if (this.reserveData[key] === 1) {
                  this.reserveGetData[key] = 1;
                }
              }
            } else {
              this.reserveData = null;
              this.isDataLoaded = false;
            }

            if (
                this.reserveData.time0810 === 0 &&
                this.reserveData.time1012 === 0 &&
                this.reserveData.time1214 === 0 &&
                this.reserveData.time1416 === 0 &&
                this.reserveData.time1618 === 0 &&
                this.reserveData.time1820 === 0 &&
                this.reserveData.time2022 === 0
            ) {
              console.log(this.isDataLoaded);
              this.isDataLoaded = false;
            }
          })
          .catch((error) => {
            console.error("Error fetching reserve data", error);
            this.reserveData = null;
            this.isDataLoaded = false;
          });
    },
  },
  computed: {
    // yyMMdd_HHmmss 변환 후 merchant_uid에 붙임 ex)231031_224258
    formattedCurrentTime() {
      const date = this.currentTime;
      const year = String(date.getFullYear()).slice(-2);
      const month = String(date.getMonth() + 1).padStart(2, '0');
      const day = String(date.getDate()).padStart(2, '0');
      const hours = String(date.getHours()).padStart(2, '0');
      const minutes = String(date.getMinutes()).padStart(2, '0');
      const seconds = String(date.getSeconds()).padStart(2, '0');

      return `${year}${month}${day}_${hours}${minutes}${seconds}`;
    },
  },
  created() {
    this.fetchData();
    this.mUidDate = this.formattedCurrentTime
  },
  watch: {
    date: function () {
      this.fetchData();
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");


body {
  font-family: "Poppins", sans-serif;
}
.showcase-area {
  height: 50vh;
  background: linear-gradient(
      rgba(240, 240, 240, 0.144),
      rgba(255, 255, 255, 0.336)
  ),
  url("https://i.postimg.cc/C5dkH0H6/BUCA-HEADERS-IMAGES-2-Reservations.png");
  background-size: cover;
  background-position: 30% 30%;
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
  font-size: 180%;
  color: #545d32;
}

btn {
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

/* 클릭된 버튼 스타일 */
button:active {
  background-color: darkolivegreen; /* 클릭 시 배경색 변경 */
  color: #fff; /* 클릭 시 텍스트 색상 변경 */
}
.timebtn{
  float : right;
  margin-right : 20px;
}
.timebtn button input[type="checkbox"]:checked {
  background-color: #4CAF50; /* Change the background color when checked */
  color: #fff; /* Change the text color when checked */
}
button i {
  margin-right: 5px; /* 아이콘과 텍스트 사이의 간격 조절 */
  font-size: 20px; /* 아이콘 크기 조절 */
}

/* 다른 버튼 스타일은 이전 답변의 CSS를 그대로 사용 */
button {
  padding: 10px 10px;
  font-size: 16px;
  color: #283827;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-right: 10px;
  margin-bottom: 10px;
}

button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}

button:hover {
  color: #beefbe;
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
.rname{
  color : #4f4e4e;
}
.userbookinfo{
  border-radius: 7px;
  background : #eeeeee;
  padding : 20px 10px;
}

.memberform{
  padding : 0 30px 30px 30px;
}
.fieldbook{
  white-space: nowrap;
}
.member input:not(input[type=radio]), .com{
  border: 1px solid #dadada;
  padding: 15px;
  width: 100%;
  margin-bottom: 5px;
  border-radius: 6px;
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
.field{
  margin :10px 0; /*상하로 좀 띄워주기*/
  gap:10px;
}

.member b{
  /* border: 1px solid #000; */
  display: block; /*수직 정렬하기 */
  margin-bottom: 5px;
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

</style>
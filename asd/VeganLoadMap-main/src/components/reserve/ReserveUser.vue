<template>
  <Header />
  <br><br>
  <div class="card shadow-sm" id="cat">
    <div class="card-body" >
      <div><h2 class="cattitle">Book Here!</h2></div>
      <div>
        <ul>
          <hr>
          <div class="memberform">
            <div class="member">
              <div class="field">
                <b>{{ storename }}</b>
              </div>
              <div class="fieldbook">
                <div>
                  <b>예약 인원 수</b>
                  <input type="number" v-model="people" class="ruser" >{{ people }}<br>
                </div>
              </div>
              <div class="field">
                <b>예약 날짜</b>
                <input type="date" v-model="date" class="ruser" >{{ date }}<br>
              </div>
            </div>
            <div v-if="isDataLoaded">
              <template v-if="reserveData">
                08:00 ~ 10:00
                <button @click="toggleTime(reserveData, 'time0810')" :disabled="reserveGetData.time0810 !== 1">
                  {{ reserveData.time0810 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time0810 }}
                <br>
                10:00 ~ 12:00
                <button @click="toggleTime(reserveData, 'time1012')" :disabled="reserveGetData.time1012 !== 1">
                  {{ reserveData.time1012 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time1012 }}
                <br>
                12:00 ~ 14:00
                <button @click="toggleTime(reserveData, 'time1214')" :disabled="reserveGetData.time1214 !== 1">
                  {{ reserveData.time1214 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time1214 }}
                <br>
                14:00 ~ 16:00
                <button @click="toggleTime(reserveData, 'time1416')" :disabled="reserveGetData.time1416 !== 1">
                  {{ reserveData.time1416 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time1416 }}
                <br>
                16:00 ~ 18:00
                <button @click="toggleTime(reserveData, 'time1618')" :disabled="reserveGetData.time1618 !== 1">
                  {{ reserveData.time1618 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time1618 }}
                <br>
                18:00 ~ 20:00
                <button @click="toggleTime(reserveData, 'time1820')" :disabled="reserveGetData.time1820 !== 1">
                  {{ reserveData.time1820 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time1820 }}
                <br>
                20:00 ~ 22:00
                <button @click="toggleTime(reserveData, 'time2022')" :disabled="reserveGetData.time2022 !== 1">
                  {{ reserveData.time2022 === 1 ? '선택' : '해제' }}
                </button>
                {{ reserveData.time2022 }}
                <br>


              </template>
              <template v-else>
                해당 날짜에 대한 정보가 없습니다. 다른 날짜를 선택해주세요.<br>
              </template>
            </div>
            <b>요청사항</b> <input type="text" v-model="comment" class="com">{{ comment }}<hr>
            <button @click="insertReserve" class="bookbtn">예약하기</button>
          </div>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Header from "@/components/header/Header.vue";
import router from "@/scripts/router";

export default {
  components: {Header},
  data() {
    return {
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
      reserver: "",
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
    };
  },
  mounted() {
    this.storename = this.$route.query.storename;
  },
  methods: {
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
            alert("예약이 완료되었습니다.")
            router.push({path: "/reserve_usercheck"});
          })
          .catch((error) => {
            console.error("Error inserting data", error);
            // Handle error as needed
            alert("현재 예약 인원이 가득찼습니다.");
            window.location.reload();
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
  created() {
    this.fetchData();
  },
  watch: {
    date: function () {
      this.fetchData();
    },
  },
};
</script>

<style scoped>
.memberform{
  padding : 0 30px 30px 30px;
}
.fieldbook div{
  display: flex;
  gap:10px;
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
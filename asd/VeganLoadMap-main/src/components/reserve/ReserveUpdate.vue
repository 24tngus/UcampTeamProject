<template>
  <Header2/>
  <div>

    <div v-if="this.selectedReserve.seq === 0">
      예약 등록 정보가 없습니다.
    </div>
        max 테이블 개수 <input type="number" v-model="this.selectedReserve.team"><br>
        max 인원 수 <input type="number" v-model="this.selectedReserve.people"><br>
        예약 날짜 <input type="date" v-model="reserve.date"><br><br>
        08:00 ~ 10:00 <button @click="toggleTime(reserve, 'time0810')">{{ reserve.time0810 === 1 ? '해제' : '선택' }}</button>{{ reserve.time0810 }}<br>
        10:00 ~ 12:00 <button @click="toggleTime(reserve, 'time1012')">{{ reserve.time1012 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1012 }}<br>
        12:00 ~ 14:00 <button @click="toggleTime(reserve, 'time1214')">{{ reserve.time1214 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1214 }}<br>
        14:00 ~ 16:00 <button @click="toggleTime(reserve, 'time1416')">{{ reserve.time1416 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1416 }}<br>
        16:00 ~ 18:00 <button @click="toggleTime(reserve, 'time1618')">{{ reserve.time1618 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1618 }}<br>
        18:00 ~ 20:00 <button @click="toggleTime(reserve, 'time1820')">{{ reserve.time1820 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1820 }}<br>
        20:00 ~ 22:00 <button @click="toggleTime(reserve, 'time2022')">{{ reserve.time2022 === 1 ? '해제' : '선택' }}</button>{{ reserve.time2022 }}<br>
        <button @click="updateReserve(reserve)">수정하기</button>
  </div>
</template>

<script>
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";
import router from "@/scripts/router";

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
      router.push({path: "/"});
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

#wrapper {
  background: #f1f1f1;
}
#container{
  position: relative;
  max-width: 90%;
  min-width: 60%;
  margin: 0 0 0 10%;
}

.form-group {
  display: flex;
  align-items: center; /* 세로 중앙 정렬 */
}

.input-button-container {
  display: flex;
  width: 100%;
  align-items: center; /* 세로 중앙 정렬 */
}

.double {
  background-color: darkolivegreen;
  color: white;
  padding: 15px;
  width: 30%;
  margin-left: 10px;
  margin-bottom: 5px;
  border-radius: 6px;
  font-weight: 700;
  font-size: 15px;
  border : 1px solid white;
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
</style>
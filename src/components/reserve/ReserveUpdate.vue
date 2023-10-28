<template>
  <Header2/>
  <div>
    <ul>
      <li v-for="reserve in reserves" :key="reserve.seq">
        예약 세팅 고유 번호 {{reserve.seq}}<br>
        가게고유번호 {{ reserve.shopseq }}<br>
        max 테이블 개수 <input type="number" v-model="reserve.team"><br>
        max 인원 수 <input type="number" v-model="reserve.people"><br>
        예약 날짜 <input type="date" v-model="reserve.date"><br>
        08:00 ~ 10:00 <button @click="toggleTime(reserve, 'time0810')">{{ reserve.time0810 === 1 ? '해제' : '선택' }}</button>{{ reserve.time0810 }}<br>
        10:00 ~ 12:00 <button @click="toggleTime(reserve, 'time1012')">{{ reserve.time1012 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1012 }}<br>
        12:00 ~ 14:00 <button @click="toggleTime(reserve, 'time1214')">{{ reserve.time1214 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1214 }}<br>
        14:00 ~ 16:00 <button @click="toggleTime(reserve, 'time1416')">{{ reserve.time1416 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1416 }}<br>
        16:00 ~ 18:00 <button @click="toggleTime(reserve, 'time1618')">{{ reserve.time1618 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1618 }}<br>
        18:00 ~ 20:00 <button @click="toggleTime(reserve, 'time1820')">{{ reserve.time1820 === 1 ? '해제' : '선택' }}</button>{{ reserve.time1820 }}<br>
        20:00 ~ 22:00 <button @click="toggleTime(reserve, 'time2022')">{{ reserve.time2022 === 1 ? '해제' : '선택' }}</button>{{ reserve.time2022 }}<br>
        <button @click="updateReserve(reserve)">수정하기</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";
// import {reactive} from "vue";

export default {
  components: {Header2},
  data() {
    return {
      reserves: [],
    };
  },
  created() {
    this.fetchReserves();
  },
  methods: {
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
          .put(`/api/reserve/set/update/${reserve.seq}`, reserve)
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
          .get("/api/reserve")
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
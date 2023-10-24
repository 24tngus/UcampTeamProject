<template>
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

export default {
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
          .put(`/api/reservetest/update/${reserve.seq}`, reserve)
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
          .get("/api/reservetest")
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
</style>
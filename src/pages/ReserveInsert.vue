<template>
  <div>
    <ul>
      max 테이블 개수 <input type="number" v-model="team">{{team}}<br>
      max 인원 수 <input type="number" v-model="people">{{people}}<br>
      예약 날짜 <input type="date" v-model="date">{{date}}<br>
      08:00 ~ 10:00 <button @click="handleInsert('time0810')">{{ time0810 === 1 ? '해제' : '선택' }}</button>{{time0810}}<br>
      10:00 ~ 12:00 <button @click="handleInsert('time1012')">{{ time1012 === 1 ? '해제' : '선택' }}</button>{{time1012}}<br>
      12:00 ~ 14:00 <button @click="handleInsert('time1214')">{{ time1214 === 1 ? '해제' : '선택' }}</button>{{time1214}}<br>
      14:00 ~ 16:00 <button @click="handleInsert('time1416')">{{ time1416 === 1 ? '해제' : '선택' }}</button>{{time1416}}<br>
      16:00 ~ 18:00 <button @click="handleInsert('time1618')">{{ time1618 === 1 ? '해제' : '선택' }}</button>{{time1618}}<br>
      18:00 ~ 20:00 <button @click="handleInsert('time1820')">{{ time1820 === 1 ? '해제' : '선택' }}</button>{{time1820}}<br>
      20:00 ~ 22:00 <button @click="handleInsert('time2022')">{{ time2022 === 1 ? '해제' : '선택' }}</button>{{time2022}}<br>
      <button @click="insertReserve">추가하기</button>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
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
      time2022: 0
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
        date: this.date,
        time0810: this.time0810,
        time1012: this.time1012,
        time1214: this.time1214,
        time1416: this.time1416,
        time1618: this.time1618,
        time1820: this.time1820,
        time2022: this.time2022
      };
      axios
          .post('/api/reservetest/insert', data)
          .then((response) => {
            console.log('Data inserted successfully', response.data);
            // Handle success as needed
          })
          .catch((error) => {
            console.error('Error inserting data', error);
            // Handle error as needed
          });
    }
  }
};
</script>

<style scoped>
</style>
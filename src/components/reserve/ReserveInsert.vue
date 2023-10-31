<template>
  <Header2 />
  <div class="card shadow-sm" id="cat">
    <div class="card-body" >
      <div><h2 class="cattitle">reserve_insert</h2></div>
      <div>
        <ul>
          <hr>
          <div  class="memberform">
            <b>테이블 개수</b> <input type="number" v-model="team">{{team}}<br>
            <b>최대 인원 수</b> <input type="number" v-model="people">{{people}}<br><hr>
            <div class="fieldbook">
              <div class="field">
                <div class="datepicker-container">
                  <div class="datepicker">
                    <Datepicker
                        v-model="pickerDate"
                        @open="clearpickerDate"
                        :text-color="style['--vdp-text-color']"
                        :background-color="style['--vdp-bg-color']"
                        :style="{
                            'border-radius': '8px',
                            'padding': '15px 5px',
                            'text-weight': '600px',
                            'margin-top': '30px',
                            'text-align' : 'center'
                          }"
                        input-format="yyyy-MM-dd"
                    />

                  </div>
                  <div class="formatDate">
                    {{formattedPickerDate}}
                  </div>
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
            <hr>
            <button @click="insertReserve" class="bookbtn">추가하기</button>
          </div>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Header2 from "@/components/header/Header2.vue";
import Datepicker from 'vue3-datepicker';


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
            alert("예약 설정이 완료되었습니다.")
            // Handle success as needed
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
  }
};

</script>

<style scoped>
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
<template>
  <Header />
  <div id="form-main">
    <div id="form-div">
      <div v-for="reserve in reserves" :key="reserve.seq">
        <form class="form" id="form1">
          식당 이름 : {{ reserve.storename }}
          <p class="text">
            예약자 : <input name="name" type="text" v-model="reserve.reserver" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p class="text">
            예약 인원 : <input name="name" type="text" v-model="reserve.people" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p class="text">
            예약 날짜 : <input name="name" type="text" :value="reserve.newdate" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-if="reserve.time0810 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="08:00 - 10:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-else-if="reserve.time1012 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="10:00 - 12:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-else-if="reserve.time1214 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="12:00 - 14:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-else-if="reserve.time1416 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="14:00 - 16:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-else-if="reserve.time1618 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="16:00 - 18:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-else-if="reserve.time1820 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="18:00 - 20:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p v-else-if="reserve.time2022 === 1" class="text">
            예약 시간 : <input name="name" type="text" value="20:00 - 22:00" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>
          <p class="text">
            추가 내용 : <input name="name" type="text" v-model="reserve.comment" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" readonly/>
          </p>


          <div v-if="isFutureDate(reserve.newdate)" class="submit">
           <button type="submit">리뷰 쓰기</button>
<!--          <router-link :to="{ name: 'review_insert', params: { value: reserve.storename } }"><button type="submit">리뷰 쓰기</button></router-link>&ndash;&gt;-->
            <div class="ease"></div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/header/Header.vue";
import axios from "axios";

export default {
  name: "ReserveTest",
  components: {Header},
  data(){
    return {
      newdate: null,
      reserves: [],
    };
  },
  created(){
    this.fetchReserve();
  },
  methods:{
    isFutureDate(date) {
      const today = new Date();
      const newDate = new Date(date);
      return newDate < today;
    },
    fetchReserve() {
      axios
          .get("/api/myreserve")
          .then((response) => {
            this.reserves = response.data.map((reserve) => {
              const timestamp = reserve.date;
              const formattedDate = new Date(timestamp).toISOString().split('T')[0];
              return {
                ...reserve,
                newdate: formattedDate,
              };
            });
          })
          .catch((error) => {
            console.error("리뷰 업데이트 중 오류 발생", error);
          });
    }


  }
}
</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Montserrat:400,700);

html {
  background: url(http://thekitemap.com/images/feedback-img.jpg) no-repeat;
  background-size: cover;
  height: 100%;
}

#feedback-page {
  text-align: center;
}


.feedback-input {
  color: #3c3c3c;
  font-family: Helvetica, Arial, sans-serif;
  font-weight: 500;
  font-size: 18px;
  border-radius: 0;
  line-height: 22px;
  background-color: #fbfbfb;
  padding: 13px 13px 13px 54px;
  margin-bottom: 10px;
  width: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -ms-box-sizing: border-box;
  box-sizing: border-box;
  border: 3px solid rgba(0, 0, 0, 0);
}

.feedback-input:focus {
  background: #fff;
  box-shadow: 0;
  border: 3px solid #3498db;
  color: #3498db;
  outline: none;
  padding: 13px 13px 13px 54px;
}

.focused {
  color: #30aed6;
  border: #30aed6 solid 3px;
}

/* Icons ---------------------------------- */
#name {
  background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
  background-size: 30px 30px;
  background-position: 11px 8px;
  background-repeat: no-repeat;
}

#name:focus {
  background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
  background-size: 30px 30px;
  background-position: 8px 5px;
  background-position: 11px 8px;
  background-repeat: no-repeat;
}

#email {
  background-image: url(http://rexkirby.com/kirbyandson/images/email.svg);
  background-size: 30px 30px;
  background-position: 11px 8px;
  background-repeat: no-repeat;
}

#email:focus {
  background-image: url(http://rexkirby.com/kirbyandson/images/email.svg);
  background-size: 30px 30px;
  background-position: 11px 8px;
  background-repeat: no-repeat;
}

#comment {
  background-image: url(http://rexkirby.com/kirbyandson/images/comment.svg);
  background-size: 30px 30px;
  background-position: 11px 8px;
  background-repeat: no-repeat;
}

textarea {
  width: 100%;
  height: 150px;
  line-height: 150%;
  resize: vertical;
}

input:hover, textarea:hover,
input:focus, textarea:focus {
  background-color: white;
}

#button-blue {
  font-family: 'Montserrat', Arial, Helvetica, sans-serif;
  float: left;
  width: 100%;
  border: #fbfbfb solid 4px;
  cursor: pointer;
  background-color: #3498db;
  color: white;
  font-size: 24px;
  padding-top: 22px;
  padding-bottom: 22px;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  transition: all 0.3s;
  margin-top: -4px;
  font-weight: 700;
}

#button-blue:hover {
  background-color: rgba(0, 0, 0, 0);
  color: #0493bd;
}

.submit:hover {
  color: #3498db;
}

.ease {
  width: 0px;
  height: 74px;
  background-color: #fbfbfb;
  -webkit-transition: .3s ease;
  -moz-transition: .3s ease;
  -o-transition: .3s ease;
  -ms-transition: .3s ease;
  transition: .3s ease;
}

.submit:hover .ease {
  width: 100%;
  background-color: white;
}

@media only screen and (max-width: 580px) {
  #form-div {
    left: 3%;
    margin-right: 3%;
    width: 88%;
    margin-left: 0;
    padding-left: 3%;
    padding-right: 3%;
  }
}
</style>
<script setup>
</script>
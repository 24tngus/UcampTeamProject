<template>
  <!-- data 객체 내용을 출력 -->
  <ul>
    <li><p>Payment ID : {{ paymentData.paymentid }}</p></li>
    <li><p>StoreName : {{ paymentData.storename }}</p></li>
    <li><p>User ID : {{ paymentData.userid }}</p></li>
    <li><p>Price : {{ paymentData.price }}</p></li>
    <li><p>Status : {{ paymentData.status }}</p></li>
    <li><p>formatTime : {{ formattedDate }}</p></li>
  </ul>
</template>

<script>
import router from "@/scripts/router";
import axios from "axios";

export default {
  data() {
    return {
      currentTime: new Date(),
      paymentid : null,
      paymentData : {},
      timeArr : [],
      createdAt : '',

    };
  },
  async mounted() {
    this.paymentid = router.currentRoute.value.params.value;
    console.log('Received Payment Data:', this.paymentid);

    try {
      const response = await axios.get(`/api/paymentSuccess/${this.paymentid}`, this.paymentid);


      this.paymentData = response.data;

      let combined_date = '';

      console.log(this.paymentData.paymentid);
      console.log(this.paymentData.storename);
      console.log(this.paymentData.userid);
      console.log(this.paymentData.price);
      console.log(this.paymentData.status);
      console.log(this.paymentData.created_at);
      for(let i=0; i<this.paymentData.created_at.length; i++) {
        combined_date += this.paymentData.created_at[i];
      }
      console.log("combined => " + combined_date);
      this.createdAt = combined_date;
      this.timeArr = this.paymentData.created_at;

    } catch (error) {
      console.error('Error while fetching data:', error);
    }
  },
  computed: {
    formattedDate() {
      const [year, month, day, hour, minute, second] = this.timeArr;
      const date = new Date(year, month - 1, day, hour, minute, second);
      return this.formatDate(date);
    }
  },
  methods: {
    formatDate(date) {
      const year = date.getFullYear();
      const month = (date.getMonth() + 1).toString().padStart(2, '0');
      const day = date.getDate().toString().padStart(2, '0');
      const hours = date.getHours().toString().padStart(2, '0');
      const minutes = date.getMinutes().toString().padStart(2, '0');
      const seconds = date.getSeconds().toString().padStart(2, '0');

      return `${year}년 ${month}월 ${day}일 ${hours}:${minutes}:${seconds}`;
    }
  },
};
</script>

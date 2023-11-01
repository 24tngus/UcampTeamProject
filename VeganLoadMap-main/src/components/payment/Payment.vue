<template>
  <div>
    <button @click="requestPay">결제하기</button>
    <!-- 결제하기 버튼 생성 -->
  </div>
  <p>{{ mUidDate }}</p>
</template>


<script>
import axios from "axios";
import router from "@/scripts/router";

export default {
  data() {
    return {
      currentTime : new Date(),
      mUidDate : '',  // merchant_uid에 붙일 값. 현재시간을 yyMMdd_HHmmss식으로 가져와서 중복 방지
    }
  },
  methods: {
    // 결제
    requestPay: function () {
      const { IMP } = window;

      IMP.init('imp70364071');
      // https://developers.portone.io/docs/ko/sdk/javascript-sdk/payrq >> 파라미터 정리 되어있음.
      IMP.request_pay({ // param
        pg: "kcp.INIBillTst_inicis",  // pg사 구분코드
        pay_method: "card", // 결제수단 구분코드
        merchant_uid: "vrm_wando_" + this.mUidDate,  // 가맹점 주문번호. 40bytes 이하. 매 거래시 다 달라야함. 거래고유코드라고 생각해도 될듯?
        name: "wando 결제테스트",  // 결제대상 제품명 (상품명) > 상점명(storename + 예약) 으로 바꿔야할듯
        amount: 50, // 결제 금액@@@@
        buyer_email: '', // 주문자 이메일  > default로 저게 박힘
        buyer_name: "김도완",  // 주문자 이름@@@@ > 김 * 완 으로 박혀있음
      }, rsp => { // callback
        if (rsp.success) {  // 결제 성공
          console.log("rsp.success => " + rsp)

          const paymentData = {
            paymentid: "wando_" + rsp.imp_uid,  // 포트원 고유 결제번호. success가 false이고 사전 validation에 실패한 경우, imp_uid는 null일 수 있음
            storename: rsp.merchant_uid,
            userid: '김도오오옹완',
            price: rsp.paid_amount,
            status: rsp.status, // 결제 성공 시에는 status
            /* 결제상태
                ready(브라우저 창 이탈, 가상계좌 발급 완료 등 미결제 상태)
                paid(결제완료)
                failed(신용카드 한도 초과, 체크카드 잔액 부족, 브라우저 창 종료 또는 취소 버튼 클릭 등 결제실패 상태) */
          };

          console.log("before post")
          console.log(paymentData.paymentid)
          console.log(paymentData.storename)
          console.log(paymentData.userid)
          console.log(paymentData.price)
          console.log(paymentData.status)

              axios.post("/api/payment", paymentData)
              .then((data) => {
                // 서버 결제 API 성공시 로직
                console.log(data)
                alert("결제 성공!");

                router.push({ name: "PaymentSuccess", params: { value : paymentData.paymentid } })
              })
              .catch((error) => {
                // 서버 결제 API 실패 시 로직
                console.log(error)
                alert("DB 입력 API 요청 실패");
              });

        } else {  // 결제 실패
          const paymentData = {
            paymentid: "wando_" + rsp.imp_uid,  // 포트원 고유 결제번호. success가 false이고 사전 validation에 실패한 경우, imp_uid는 null일 수 있음
            storename: rsp.merchant_uid,
            userid: "김완도도도독",
            price: "500000",
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
                alert("DB 입력 API 요청 실패");
              });

        }
      });
    }
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
    this.mUidDate = this.formattedCurrentTime
  }
}
</script>
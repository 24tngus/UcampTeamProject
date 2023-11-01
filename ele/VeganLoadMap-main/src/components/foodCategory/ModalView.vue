<template>
  <div class="modal">
    <div class="modal-background"></div>
    <div class="modal-content">
      <h2 class="cattitle">Details</h2>
      <div>
        <slot name="modalText">
          default modalText
        </slot>
        <button class="mreserve" @click="$router.push('/reserve')">예약하기</button>
      </div>
    </div>
  </div>
</template>

<script>

export default {

};
</script>

<style scoped>
.mreserve{
  margin-top : 10px;
  border : 2px solid darkolivegreen;
  padding : 8px 20px;
  background: darkolivegreen;
  border-radius: 7px;
  color : white;
  font-weight: 600;
}
.mreserve:hover{
  background: olive;
  border : 2px solid olive;
  padding : 8px 20px;
  border-radius: 7px;
  color : whitesmoke;
}
.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(0, 0, 0, 0.7); /* 배경에 어두운 투명 레이어 추가 */
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  z-index: 999; /* 다른 요소 위에 보이도록 설정 */
}

.modal-content {
  background-color: #fff; /* 모달 내용 배경색 지정 */
  max-width: 70%; /* 모달 내용의 최대 너비를 설정 (원하는 너비로 조절) */
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  text-align: center;
  margin: 0 40px; /* 양 옆의 공백을 설정 (원하는 간격으로 조절) */
}

.modal-background {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.cattitle{
  padding : 20px;
  font-weight: 700;
}
</style>
<template>
  <div class="modal">
    <div class="modal-background"></div>
    <div class="modal-content">
      <h1>Hello Modal!! I'm wando!!</h1>
      <div>
        <slot name="modalText">
          default modalText
        </slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
};
</script>

<style scoped>
.modal {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  position: absolute;
  top: 300px; /* 원하는 위치로 설정 */
//left:1300px; /* 원하는 위치로 설정 */
  background-color: white;
  padding: 20px;
}
</style>
// import { createApp } from 'vue'
// import store from "@/scripts/store"
// import router from "@/scripts/router";
// import App from './App.vue'
//
// createApp(App).use(store).use(router).mount('#app')

import { createApp } from 'vue'
import App from './App.vue'
import store from "@/scripts/store"
import router from "@/scripts/router";

// 에러 핸들러 함수를 정의합니다.
/* eslint-disable no-unused-vars */
function handleWindowError(msg, url, line, col, error) {
    // 에러가 발생하면 아무 작업도 하지 않도록 합니다.
    return true; // true 반환하여 기본 동작을 중단시킵니다.
}

// window.onerror 이벤트에 에러 핸들러 함수를 할당합니다.
window.onerror = handleWindowError;

createApp(App).use(store).use(router).mount('#app')

window.Kakao.init("e414a6a9edeb28b6fd8271889f51e77c");


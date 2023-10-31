import { createApp } from 'vue'
import store from "@/scripts/store"
import router from "@/scripts/router";
import App from './App.vue'

createApp(App).use(store).use(router).mount('#app')

window.Kakao.init("a536c370d613ee0cc23595cfd056bf8a");

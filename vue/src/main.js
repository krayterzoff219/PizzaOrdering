import Vue from "vue";
import App from "./App.vue";
import router from "./router/index";
import store from "./store/index";
import axios from "axios";

// import "@fortawesome/fontawesome-free/css/all.css";
// import "@fortawesome/fontawesome-free/js/all.js";
// import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome"
// Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false;

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
	router,
	store,
	render: (h) => h(App),
}).$mount("#app");

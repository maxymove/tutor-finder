import Vue from 'vue'
import App from './App.vue'
import router from './routes';
import store from './store';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import * as VeeValidate from 'vee-validate';
import Vuex from 'vuex';
Vue.config.productionTip = false

Vue.use(VeeValidate);
Vue.use(Vuex);
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
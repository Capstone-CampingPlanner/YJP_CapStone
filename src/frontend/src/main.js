import {createApp} from 'vue'
import axios from 'axios'
import {router} from './router'
import App from './App.vue'
import store from './store';

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.css'
import '@fortawesome/fontawesome-free'
import 'bootstrap/dist/js/bootstrap.js'
import 'bootstrap/js/dist/dropdown';

import Datepicker from '@vuepic/vue-datepicker'
import '@vuepic/vue-datepicker/dist/main.css'

axios.defaults.headers.common['Access-Controle_Allow-Origin'] = '*'
axios.defaults.headers.get['Content-Type'] = 'application/json;charset=utf-8'

const app = createApp(App)
app.use(router)
app.use(store);
app.component('Datepicker', Datepicker)
app.mount('#app')
app.config.globalProperties.axios = axios

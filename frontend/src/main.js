import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

//引入element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

//引入分离的api接口
import api from './api'
Vue.use(api)

//引入vue-i18n语言插件
import VueI18n from 'vue-i18n'
Vue.use(VueI18n)

//引入Echarts
// import echarts from 'echarts'
const echarts = require('echarts')
Vue.prototype.$echarts = echarts

//配置语言插件
import i18n_option from './language'
const i18n = new VueI18n(i18n_option)
Vue.prototype.$languageConfig = i18n

Vue.config.productionTip = false

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount('#app')
import Vue from 'vue'
import App from './App.vue'
import router from './router'

import '@babel/polyfill'
import 'mutationobserver-shim'
import 'jquery'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap'
import VueResource from 'vue-resource'
import 'font-awesome/css/font-awesome.min.css'
import Video from 'video.js'
import 'video.js/dist/video-js.css'
import video_zhCN from 'video.js/dist/lang/zh-CN.json'
import video_en from 'video.js/dist/lang/en.json'
import 'bootstrap-fileinput'

Video.addLanguage('zh-CN', video_zhCN)
Video.addLanguage('en', video_en)

Vue.use(VueResource)
Vue.prototype.$video = Video

Vue.config.productionTip = false

new Vue({
  router: router,
  render: h => h(App)
}).$mount('#app')

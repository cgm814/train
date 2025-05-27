import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd, { notification } from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import * as Icons from '@ant-design/icons-vue';
import axios from 'axios';
import './assets/js/enums'; // 引入枚举文件

const app = createApp(App);
app.use(Antd).use(store).use(router).mount('#app');

// 全局使用图标
const icons = Icons;
for (const i in icons) {
  app.component(i, icons[i]);
}

/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
  console.log('请求参数：', config);
  const _token = store.state.member.token;
  if (_token) {
    config.headers.token = _token;
    console.log('请求头headers增加token：', _token);
  }
  return config;
}, error => {
  return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
  console.log('返回结果：', response);
  return response;
}, error => {
  console.log('返回错误：', error);
  const response = error.response;
  const status = response.status;
  if (status === 401) {
    // 判断状态码是401，token过期，跳转到登录页
    // 401状态码是token过期，清除token和用户信息
    console.log('未登录或登录超时，跳转到登录页');
    store.commit('setMember', {});
    notification.error({ message: '未登录或登录超时，请重新登录' });
    router.push('/login');
  }
  return Promise.reject(error);
});

axios.defaults.baseURL = process.env.VUE_APP_SERVER;
console.log('环境：', process.env.NODE_ENV);
console.log('服务端：', process.env.VUE_APP_SERVER);
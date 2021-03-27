import Vue from 'vue'
import VueRouter from 'vue-router'

import user from './user';
import admin from './admin';


Vue.use(VueRouter)

const routes = [
  //主页
  {
    path: '/',
    name: 'Index',
    component: () => import("@/views/index")
  },
  user,
  admin
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

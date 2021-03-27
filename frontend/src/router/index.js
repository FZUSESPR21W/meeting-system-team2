import Vue from 'vue'
import VueRouter from 'vue-router'

import user from './user';
import admin from './admin';
import secretary from './secretary';


Vue.use(VueRouter)

const routes = [
    //主页
    {
        path: '/',
        name: 'Index',
        component: () =>
            import ("@/views/index")
    },
    {
        path: '/login',
        name: 'Login',
        component: () =>
            import ("@/views/login")
    },
    {
        path: '/register',
        name: 'Register',
        component: () =>
            import ("@/views/register")
    },
    user,
    admin,
    secretary,
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
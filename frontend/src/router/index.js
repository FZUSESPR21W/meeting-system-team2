import Vue from 'vue'
import VueRouter from 'vue-router'

import user from './user';
import admin from './admin';
import secretary from './secretary';
import chairman from './chairman';
import detail from './detail';


Vue.use(VueRouter)

const routes = [
    //主页
    {
        path: '/',
        name: 'Index',
        component: () =>
            import ("@/views/index"),
        meta: {
            title: '首页'
        }
    },
    {
        path: '/login',
        name: 'Login',
        component: () =>
            import ("@/views/login"),
        meta: {
            title: '登录'
        }
    },
    {
        path: '/register',
        name: 'Register',
        component: () =>
            import ("@/views/register"),
        meta: {
            title: '注册'
        }
    },
    user,
    admin,
    secretary,
    chairman,
    detail
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
        document.title = to.meta.title
    }
    next()
})

export default router
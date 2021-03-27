export default {
    path: "/user",
    redirect: '/user/center',
    component: () => import ("@/views/user/index"),


    children: [
        {
            path: 'center',
            component: () => import ("@/views/user/center"),
            meta: {
                title: '用户中心'
            }
        },
        {
            path: 'message',
            component: () => import ("@/views/user/message"),
            meta: {
                title: '消息中心'
            }
        },
        {
            path: 'logout',
            component: () => import ("@/views/user/logout"),
        }
    ]
}
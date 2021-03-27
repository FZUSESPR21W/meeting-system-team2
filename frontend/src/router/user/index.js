export default {
    path: "/user",
    redirect: '/user/center',
    component: () => import ("@/views/user/index"),

    children: [
        {
            path: 'center',
            component: () => import ("@/views/user/center"),
        },
        {
            path: 'message',
            component: () => import ("@/views/user/message"),
        },
        {
            path: 'logout',
            component: () => import ("@/views/user/logout"),
        }
    ]
}
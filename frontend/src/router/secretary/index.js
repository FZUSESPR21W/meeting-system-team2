export default {
    path: "/admin/secretary",
    component: () => import("@/views/secretary/userList"),
    meta: {
        title: '秘书管理页面'
    },
    children: [

    ]
}
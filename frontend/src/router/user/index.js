export default {
    path: "/user",
    component: () =>
        import ("@/views/user/index"),

    children: [{
        path: 'center',
        component: () =>
            import ("@/views/user/center"),
    }]
}
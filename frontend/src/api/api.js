import axios from './axios'


/**
 * 用户api
 */
export class User {
    /**
     * 登录
     * @param username
     * @param password
     * @returns {*}
     */
    static login(username, password) {
        return axios.post("/login", {
            username: username,
            password: password
        })
    }

    /**
     * 登出
     * @returns {*}
     */
    static logout(username, password) {
        return axios.get("/logout")
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param rePassword
     * @returns
     */
    static register(username, password) {
        return axios.post("/register", {
            username: username,
            password: password,
            meetIdArray: [1, 2, 3],
        })
    }

    /**
     * 获取用户信息
     * @param username
     * @returns {*}
     */
    static getUserInfo() {
        return axios.post("/user_info", {})
    }

    /**
     * 修改用户参加分论坛情况
     * @param {*} interest
     * @returns {*}
     */
    static modifyUserInterest(interest) {
        return axios.post("", {
            interest: interest
        })
    }
    static getJointMeet(username) {
        return axios.post("", {

        })
    }
    static modifyUserInterest(meetList) {
        return axios.post("", {

        })
    }
}

/**
 * 会议api
 */
export class Meeting {
    /**
     * 获取会议列表
     * @param 无
     * @returns {*}
     */
    static getMeetingList() {
        return axios.post('/meeting_list', {})
    }
}

export class Echarts {
    static getSubNum() {
         return axios.get("/bar_graph")}
        
}
export class Secretary{
    static getUserList(){
        return axios.post('uesr_list');
    }
}
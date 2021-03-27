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
    static getUserDetail(username) {
            return axios.post("", {
                username: username
            })
        }
        /**
         * 修改用户参加分论坛情况
         * @param {*} interest
         * @returns {*}
         */
    static modifyUserInterest(interest) {
        return axiox.post("", {
            interest: interest
        })
    }

}
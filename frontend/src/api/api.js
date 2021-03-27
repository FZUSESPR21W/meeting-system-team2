import axios from './axios'




/**
 * 用户api
 */
export class User {
    /**
     * 登录
     * @param email
     * @param password
     * @returns {*}
     */
    static login(email, password) {
            return axios.post("", {
                email: email,
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
    static register(username, password, rePassword) {
            return axios.post("", {
                username: username,
                password: password,
                rePassword: rePassword,
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
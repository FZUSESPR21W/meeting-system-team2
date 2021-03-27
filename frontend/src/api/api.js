import axios from './axios'




/**
 * 用户api
 */
export class User{
  /**
   * 登录
   * @param email
   * @param password
   * @returns {*}
   */
  static login(email,password){
    return axios.post("",{
      email: email,
      password: password
    })
  }


}

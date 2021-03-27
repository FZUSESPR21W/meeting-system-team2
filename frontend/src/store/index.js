import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userData: {}
  },
  mutations: {
    setUserData(state, payload) {
      state.userData = payload
      localStorage.setItem('userData', JSON.stringify(state.userData))
    },
    getLocalUserData(state){
      let data = localStorage.getItem('userData')
      state.userData = JSON.parse(data)
    },
    clearUserData(state) {
      state.userData = {}
      localStorage.removeItem('userData')
    }
  },
  actions: {
  },
  modules: {
  }
})

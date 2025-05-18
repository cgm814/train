import { createStore } from 'vuex'

const MEMBER = "MEMBER";

export default createStore({
  state: {
    // member: window.sessionStorage.get(MEMBER) || {}
    // 从sessionStorage读取数据（需解析JSON字符串，若不存在则初始化为空对象）
    member: JSON.parse(window.sessionStorage.getItem(MEMBER)) || {}
  },
  getters: {
  },
  mutations: {
    setMember(state, _member) {
      state.member = _member;
      // window.sessionStorage.set(MEMBER, _member);
      // 保存到sessionStorage（需将对象序列化为JSON字符串）
      window.sessionStorage.setItem(MEMBER, JSON.stringify(_member));
    }
  },
  actions: {
  },
  modules: {
  }
})

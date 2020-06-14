export default {

    baseURL: 'http://39.106.160.119:8080/',//后端地址
    method: 'post',
    //登录模块接口
    userLogin: {url: 'user/login'},
    allTask:{url:'task/list'},
    allRecord:{url:'rcd/list'},

    // 接口
    register: {url: 'user/reg'},
    userInfo: {url: 'user/info'},
    updateUserInfo: {url: 'user/infoupd'},

    taskDetail:{url:'task/view'},


}

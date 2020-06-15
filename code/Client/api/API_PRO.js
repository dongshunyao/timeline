export default {

    baseURL: 'http://39.106.160.119:8080/',//后端地址
    method: 'post',
    //登录模块接口
    userLogin: {url: 'user/login'},

    allRecord: {url: 'rcd/list'},

    // 接口
    register: {url: 'user/reg'},
    userInfo: {url: 'user/info'},
    updateUserInfo: {url: 'user/infoupd'},

    // 任务接口
    allTask: {url: 'task/list'},
    taskDetail: {url: 'task/view'},
    addTask: {url: 'task/add'},
    updateTask: {url: 'task/upd'},
    deleteTask: {url: 'task/del'},

}

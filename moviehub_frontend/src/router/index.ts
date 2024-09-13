import { createRouter, createWebHashHistory } from 'vue-router'
const routes = [
  { path: '/', redirect: '/Moviehub/mainpage/visitor' },
  {
    path: '/Moviehub/loginpage',
    name: 'login',
    meta: {
      title: '登录界面',
      needLogin: true,
    },
    component: () => import('@/views/LoginPage.vue'),
  },
  {
    path: '/Moviehub/mainpage/visitor',
    name: 'MoviemainPage',
    meta: {
      index: true,
      title: '电影主页面',
    },
    component: () => import('@/views/MainPageVisitor.vue'),
  },
  {
    path: '/Moviehub/mainpageuser/:userID',
    name: 'MoviemainPage2',
    meta: {
      index: true,
      title: '电影主页面2',
    },
    component: () => import('@/views/MainPageUser.vue'),
  },
  {
    path: '/Moviehub/dashboard/:userID',
    name: 'MovieDashbord',
    meta: {
      index: true,
      title: '用户主界面',
    },
    component: () => import('@/views/DashBoard.vue'),
  },
  {
    path: '/Moviehub/dashboard/edit/:userID',
    name: 'MovieDashbordedit',
    meta: {
      index: true,
      title: '编辑',
    },
    component: () => import('@/views/EditPage.vue'),
  },
  {
    path: '/Moviehub/dashboard/post/:userID',
    name: 'MovieDashbordpost',
    meta: {
      index: true,
      title: '发布',
    },
    component: () => import('@/views/PostPage.vue'),
  },

  {
    path: '/Moviehub/registerpage',
    name: 'Register',
    meta: {
      title: '注册界面',
      needLogin: true,
    },
    component: () => import('@/views/RegisterPage.vue'),
  },
  {
    path: '/Moviehub/forgetpassword',
    name: 'forgetpassword',
    meta: {
      title: '忘记密码',
      needLogin: true,
    },
    component: () => import('@/views/ForgetPassword.vue'),
  },
  {
    path: '/Moviehub/changepassword/:userID',
    name: 'changepassword',
    meta: {
      title: '改变密码',
      needLogin: true,
    },
    component: () => import('@/views/ChangePassword.vue'),
  },

  {
    path: '/Moviehub/contentpage',
    name: 'ContentPage',
    meta: {
      index: true,
      title: '内容',
    },
    component: () => import('@/views/ContentVisitor.vue'),
  },
  {
    path: '/Moviehub/contentpage/:userID',
    name: 'ContentPageUser',
    meta: {
      index: true,
      title: '登录内容',
    },
    component: () => import('@/views/ContentUser.vue'),
  },
  {
    path: '/Moviehub/dashboard/setting/:userID',
    name: 'SettingPage',
    meta: {
      index: true,
      title: '设置',
    },
    component: () => import('@/views/SettingPage.vue'),
  },

  {
    path: '/:path(.*)*',
    name: '找不到页面',
    meta: {
      title: '忘记密码',
      needLogin: true,
    },
    component: () => import('@/views/PageNotFound.vue'),
  },
]
const router = createRouter({
  history: createWebHashHistory(),
  routes,
})
export default router

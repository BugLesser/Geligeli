import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from './components/Home.vue'
import About from './components/About.vue'
import HelloWorld from './components/HelloWorld.vue'
import Submit from './components/Submit.vue'
import Video from './components/Video'
import Search from './components/Search'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/home/:s?',
        name:'Home',
        component: Home
    },
    {
        path: '/search/:s?',
        name:'Search',
        component: Search
    },
    {
        path: '/about',
        component: About
    },
    {
        path: '/submit',
        component: Submit
    },{
        path: '/hello',
        component: HelloWorld
    },{
        path: '/video',
        name: 'Video',
        component: Video
    }
]

var router = new VueRouter({
    routes,
    mode: 'hash'
})

router.beforeEach((to,from,next)=>{
    next()
})

export default router
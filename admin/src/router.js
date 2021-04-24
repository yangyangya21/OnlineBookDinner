import Vue from "vue"
import Router from "vue-router"
import Login from "./views/common/login.vue"
import Register from "./views/common/register.vue"

Vue.use(Router);

export default new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [{
        path: "*",
        redirect: "/login",
    }, {
        path: "/login",
        component: Login
    }, {
        path: "/register",
        component: Register
    }]
})
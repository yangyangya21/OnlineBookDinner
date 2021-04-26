import Vue from "vue"
import Router from "vue-router"
import Login from "./views/login.vue"
import Register from "./views/register.vue"
import Dinner from "./views/dinner.vue"

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
    }, {
        path: "/dinner",
        component: Dinner
    }]
})
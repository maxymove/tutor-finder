import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: 'history', // Use browser history
    routes: [
        {
            path: "/",
            name: "Welcome",
            component: () => import("./components/Welcome"),
        },
        {
            path: "/login",
            name: "Login",
            component: () => import("./components/Login"),
        },
        {
            path: "/register",
            name: "Register",
            component: () => import("./components/Register"),
        },{
            path: "/profile/:Username",
            name: "Profile",
            component: () => import("./components/Profile"),
        }

        // {
        //     path: "/course/:id",
        //     name: "Courses",
        //     component: () => import("./components/Course"),
        // },
    ]
});

export default router;
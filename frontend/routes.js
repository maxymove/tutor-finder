import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: "history", // Use browser history
    routes: [
        {
            path: "/",
            name: "Home",
            component: () => import("./components/Courses")
        },
        {
            path: "/courses",
            name: "Courses",
            component: () => import("./components/Courses")
        },
        {
            path: "/courses/:id",
            name: "Course Details",
            component: () => import("./components/Course")
        }
    ]
});

export default router;
<template>
    <div class="container">
        <br>
        <br>
        <h3>Current Available Courses</h3>
        <div v-if="message" class="alert alert-success">
            {{message}}
        </div>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Course Name</th>
                    <th>Course Category</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="course in courses" v-bind:key="course.id">
                    <td>{{course.courseId}}</td>
                    <td>{{course.courseName}}</td>
                    <td>{{course.category}}</td>
                    <td><button class="btn btn-warning"
                                v-on:click="addCourse(course.courseId)">
                        ADD
                    </button></td>
                    <td>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <!--        <p>-->
        <!--            <strong>Token:</strong>-->
        <!--            {{currentUser.accessToken.substring(0, 20)}} ...-->
        <!--            {{currentUser.accessToken.substr(currentUser.accessToken.length - 20)}}-->
        <!--        </p>-->
        <!--        <p>-->
        <!--            <strong>Id:</strong>-->
        <!--            {{currentUser.id}}-->
        <!--        </p>-->
        <!--        <p>-->
        <!--            <strong>Email:</strong>-->
        <!--            {{currentUser.email}}-->
        <!--        </p>-->
        <!--        <strong>Authorities:</strong>-->
        <!--        <ul>-->
        <!--            <li v-for="(role,index) in currentUser.roles" :key="index">{{role}}</li>-->
        <!--        </ul>-->
    </div>
</template>

<script>
    import UserService from '../services/user.service';

    export default {
        name: 'Search',
        data(){
            return{
                courses:[]
            };
        },
        methods:{
            addCourse(id){
                // axios.post .....
            }
        },
        computed: {
            currentUser() {
                return this.$store.state.auth.user;
            }
        },
        mounted() {
            UserService.getAllCourse().then(
                response => {
                    this.courses = response.data;
                }
            )
            if (!this.currentUser) {
                this.$router.push('/login');
            }
        }
    };
</script>
<style lang="scss">

    .container {
        display: flex;
        width: 100%;
        height: 100%;
        align-items: center;
        text-align: center;
        flex-direction: column;
        font-family: 'Open Sans', sans-serif;
        font-size: 16px;
        cursor: default;
    }


    body {
        height: 100%;
        width: 100%;
        font-family: 'Open Sans', sans-serif;
        font-size: 16px;
        background-image: url('../assets/background.jpg');
        background-size: cover;
        cursor: default;
        background-position: center;
        background-repeat: no-repeat;
        background-attachment: fixed;
    }

    a {
        text-decoration: none;
        cursor: pointer;
    }

    ::selection {
        background-color: #F5617A;
        color: #fff;
    }

    ::-moz-selection {
        background-color: #F5617A;
        color: #fff;

    }

    .typewriter h1 {
        overflow: hidden; /* Ensures the content is not revealed until the animation */
        border-right: .15em solid orange; /* The typwriter cursor */
        white-space: nowrap; /* Keeps the content on a single line */
        margin: 0 auto; /* Gives that scrolling effect as the typing happens */
        letter-spacing: .10em; /* Adjust as needed */
        animation: typing 3.5s steps(40, end),
        blink-caret .75s step-end infinite;
    }

    /* The typing effect */
    @keyframes typing {
        from {
            width: 0
        }
        to {
            width: 100%
        }
    }

    /* The typewriter cursor effect */
    @keyframes blink-caret {
        from, to {
            border-color: transparent
        }
        50% {
            border-color: orange;
        }
    }
</style>
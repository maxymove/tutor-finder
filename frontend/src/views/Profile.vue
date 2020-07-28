<template>
    <div class="container">
        <br>
        <div class="typewriter">
            <h1>Welcome, {{currentUser.username}} </h1>
        </div>
        <div class="blue-frame">
        <div class="blue-button-copy" @click="$router.push('/search')" >Add</div>
    </div>
        <br>
        <h3>Current Courses</h3>
        <div v-if="err" class="alert alert-success" alert-dismissible fade show >
            {{err}}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Course Name</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="course in courses" v-bind:key="course.id">
                    <td>{{course.courseId}}</td>
                    <td>{{course.courseName}}</td>
                    <td><button class="btn btn-warning"  v-on:click="deleteCourse(course.courseId)">DELETE</button></td>
                    <td>
                    <td><button class="btn btn-warning"  v-on:click="viewCourse(course.courseId)">View Details</button></td>
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
    // import UserService from '../services/user.service';
    import axios from 'axios';

    export default {
        name: 'Profile',
        data(){
            return{
                courses:[],
                err: ''
            };
        },
        methods:{
            refresh() {
                axios
                    .get('http://localhost:8080/api/test/' + this.currentUser.username + '/course')
                    .then(
                        response => {
                            this.courses = response.data;
                        }
                    )
            },

            deleteCourse(id){
                axios
                    .post('http://localhost:8080/api/test/delete/course/' + this.currentUser.username + '.' + id)
                    .then(
                        response => {
                            this.err = response.data;
                            this.refresh();
                        }
                    )
            },
            viewCourse(id){
                axios
                .post('http://localhost:8080/api/test/view/course/' + id)
                .then(
                    response => {
                        this.err = response.data;
                    },
                    this.$router.push('/view/'+id)

                )
            }

        },
        computed: {
            currentUser() {
                return this.$store.state.auth.user;
            }
        },
        mounted() {
            axios
                .get('http://localhost:8080/api/test/' + this.currentUser.username + '/course')
                .then(
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
<style scoped lang="scss">

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
    .blue-frame{
        transition: all 0.3s ease;
        background-color: darken(#3498DB, 10%);
        height: 100px;
        width: 100px;
        border-radius: 72px;
        box-shadow: 0 4px 16px 0 rgba(0, 0, 0, .07);
        cursor: pointer;
        text-align: center;
        position: absolute;
        top:80px;
        right:10px;
        .blue-button-copy {
            text-align: center;
            line-height: 100px;
            text-transform: uppercase;
            font-weight: bold;
            color: #f7f7f7;
            text-align: center;

        }
    }

</style>
<template>
    <div class="container">
        <!--      <h3>{{content}}</h3>-->
        <img :src="require('../assets/Tutor_Finder_Logo.png')"/>
        <div class="typewriter">
            <h1>Welcome to Tutor Finder</h1>
        </div>
        <br>
        <div class="blue-frame" >
            <div class="blue-button-copy" @click="$router.push('/login')" >Login</div>
    </div>
        <br>
        <div class="blue-frame" >
            <div class="blue-button-copy" @click="$router.push('/register')" >Register</div>
        </div>
    </div>
</template>

<script>
    import UserService from '../services/user.service';

    export default {
        name: 'Home',
        data() {
            return {
                content: ''
            };
        },
        mounted() {
            UserService.getPublicContent().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content =
                        (error.response && error.response.data) ||
                        error.message ||
                        error.toString();
                }
            );
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
    .blue-frame{
        transition: all 0.3s ease;
        background-color: darken(#3498DB, 10%);
        height: 144px;
        width: 144px;
        border-radius: 72px;
        box-shadow: 0 4px 16px 0 rgba(0, 0, 0, .07);
        cursor: pointer;
        text-align: center;
        .blue-button-copy {
            text-align: center;
            line-height: 144px;
            text-transform: uppercase;
            font-weight: bold;
            color: #f7f7f7;
            text-align: center;
        }
    }



</style>



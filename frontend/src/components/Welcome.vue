<template>

<!--        <button v-bind:style="Prettybutton" v-on:click="goToLoginPage()">Tutor</button>-->

    <div class="container">
        <img :src="require('../assets/Tutor_Finder_Logo.png')" />
        <div class="typewriter">
                <h1>Welcome to Tutor Finder</h1>
        </div>
        <br>
        <div class="add-product" :class="{'open': loginFormOpen}">
            <div class="button-copy" v-show="!loginFormOpen" @click="loginFormOpen = true">Login</div>
            <form @submit="cancelLogin()">
                <div class="form--field">
                    <input type="text" class="form--element" name="Username" v-model="loginData.username" placeholder="Username" required="">
                    <input type="password" class="form--element" name="password" v-model="loginData.password" placeholder="password" required="">
                </div>
                <label class="emoji">
                    press me
                    <input type="checkbox" name="is_featured" v-bind="loginData.is_featured">
                    <span></span>
                </label>
                <p class="featured-note">Forget your password?.</p>
                <button type="submit" class="submit-button">Forget Password</button><br>
                <button type="submit" class="submit-button">Login</button><br>
                <div class="cancel"><span @click="cancelLogin()">Back</span></div>
            </form>
        </div>
        <br>
        <div class="add-product" :class="{'open': registerFormOpen}">
            <div class="button-copy" v-show="!registerFormOpen" @click="registerFormOpen = true">Register</div>
            <form @submit="cancelRegister()">
                <div class="form--field">
                    <h1>Register</h1>
                    <input type="text" class="form--element" name="username" v-model="registerData.username" placeholder="Username" required="true">
                    <input type="password" class="form--element" name="password" v-model="registerData.password" placeholder="Password" required="true">
                    <input type="password" class="form--element" name="retype" v-model="registerData.retype" placeholder="Retype Password" required="true">
                    <input type="text" class="form--element" name="email" v-model="registerData.email" placeholder="Email" required="">
                    <input type="date" class="form--element" name="dob" v-model="registerData.dob" placeholder="DOB" required="">
                </div>
                <p class="featured-note">You cannot change username later.</p>
                <button type="submit" class="submit-button">Register</button>
                <div class="cancel"><span @click="cancelRegister()">Back</span></div>
            </form>
        </div>
        <br>

        <div class="add-product" :class="{'open': aboutFormOpen}">
            <div class="button-copy" v-show="!aboutFormOpen" @click="aboutFormOpen = true">About Us</div>
            <form @submit="cancelAbout()">
                <div class="form--field">
                    <h1>More About Us</h1>
                </div>
                <div class="cancel"><span @click="cancelAbout()">Back</span></div>
            </form>
        </div>
        <br>
        <br>
        <br>
    </div>
</template>
<script>
    export default {
        name:"Welcome",
        data(){
            return{
                message:"",
                loginFormOpen: false,
                registerFormOpen:false,
                aboutFormOpen:false,
                loginData: {
                    username: '',
                    password:''},
                registerData:{
                    username: '',
                    password:'',
                    retype:'',
                    email:'',
                    dob:''}
            }
        },
        methods:{
            resetForm: function () {
                this.loginData = {
                    username: '',
                    password:'',

                },
                    this.registerData={
                    username: '',
                        password:'',
                        retype:'',
                        email:'',
                        dob:''}
            },
            cancelLogin: function() {
                this.loginFormOpen = false;
                this.resetForm();
            },  cancelRegister: function() {
                this.registerFormOpen= false;
                this.resetForm();
            },  cancelAbout: function() {
                this.aboutFormOpen=false;
                this.resetForm();
            }
        }
    }

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

    .add-product {
        &.open {
            background-color: #FAFAFA;
            padding: 18px 32px;
            border-radius: 5px;
            width: 420px;
            height: 398px;
            cursor: default;
            text-align: center;
            form {
                opacity: 1;
                transition: opacity 0.1s ease;
                transition-delay: 0.3s;
                height: auto;
                text-align: center;
            }
        }
        transition: all 0.3s ease;
        background-color: darken(#3498DB, 10%);
        height: 144px;
        width: 144px;
        border-radius: 72px;
        box-shadow: 0 4px 16px 0 rgba(0, 0, 0, .07);
        cursor: pointer;
        text-align: center;
        .button-copy {
            text-align: center;
            line-height: 144px;
            text-transform: uppercase;
            font-weight: bold;
            color: #f7f7f7;
            text-align: center;
        }
        form {
            transition: none;
            opacity: 0;
            height: 0;
            overflow: hidden;
            text-align: center;
        }
        .cancel {
            font-size: 12px;
            text-align: center;
            margin-top: 1em;
            span {
                cursor: pointer;
                &:hover {
                    text-decoration: underline;
                }
            }
        }
    }

    .submit-button {
        display: block;
        background-color: #3498DB;
        height: 40px;
        border-radius: 20px;
        line-height: 36px;
        text-align: center;
        color: #fff;
        text-transform: uppercase;
        font-size: 0.875em;
        border: none;
        font-weight: 700;
        padding: 0 34px;
        margin: 0 auto;
        img {
            position: relative;
            top: 3px;
            right: 6px;
        }
        &:hover {
            background-color: darken(#3498DB, 10%);
            cursor: pointer;
        }
    }

    .featured-note {
        color: #949494;
        font-size: 12px;
        margin: 4px 0px;
        line-height: 18px;
        font-style: italic;
    }

    form * {
        outline: none;

    }

    label {
        display: block;
        font-size: 14px;
        font-weight: bold;
        user-select: none;

        &.emoji {
            input {
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                height: 21px;
                margin: 0;
                display: none;
                &+span:after {
                    content: "😶";
                    font-size: 18px;
                    top: 2px;
                    left: 2px;
                    position: relative;
                    height: 18px;
                    display: inline-block;
                }
                &:checked+span:after {
                    content: "😀";
                }
            }
        }
    }

    .form--field {
        width: 400px;
        margin: 10px 0;
    }

    .form--price {
        position: absolute;
        line-height: 38px;
        width: 16px;
        color: #C7C7C7;
        text-align: center;
        & + input {
            padding-left: 14px;
        }
    }

    .form--container {
        width: 420px;
        display: flex;
        &.-inline {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin-bottom: -12px;
            text-align: center;

        }
    }

    .form--element {

        background-color: #fff;
        border: 1px solid #ECECEC;
        border-radius: 3px;
        font-size: 14px;
        line-height: 28px;
        padding: 0 4px;
        color: #3D3D3D;
        width: 100%;
        margin: 4px 0;
        box-sizing: border-box;
        font-family: 'Open Sans', sans-serif;
        &:focus {
            border: 1px solid #FFC145;
            border-radius: 2px;
        }
        &:not(.textarea) {
            height: 30px;
        }
        &.textarea {
            height: 80px;
            resize: none;
        }
    }


    html,


    body {
        height: 100%;
        width: 100%;
        font-family: 'Open Sans', sans-serif;
        font-size: 16px;
        background-image: url('../assets/background.jpg');
        background-size:cover;
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
        animation:
                typing 3.5s steps(40, end),
                blink-caret .75s step-end infinite;
    }

    /* The typing effect */
    @keyframes typing {
        from { width: 0 }
        to { width: 100% }
    }

    /* The typewriter cursor effect */
    @keyframes blink-caret {
        from, to { border-color: transparent }
        50% { border-color: orange; }
    }
</style>


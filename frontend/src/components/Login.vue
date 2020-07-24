<template>
    <div class="container">
        <h1>Login Page</h1>
        <button class="btn btn-success" v-on:click="goToRegisterPage()">Register</button>
        <button class="btn btn-success" v-on:click="goToProfilePage()">Login</button>
    </div>
</template>
<script>

export default {
name: "Login",
    data(){
    return{
        Username:"chakeera",
        Password:"",

    }
    },
    methods:{
        goToRegisterPage(){
            this.$router.push(`/register`);
        },
        goToProfilePage(){
            this.$router.push(`/profile/`+this.Username);
        }
}
};
</script>

<style>
</style>
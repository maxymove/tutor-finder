<template>
    <div class="container">
        <img :src="require('../assets/Tutor_Finder_Logo.png')" />
        <h1>Welcome to Tutor Finder</h1>
        <button class="btn btn-success" v-on:click="goToLoginPage()">Student</button>
        <button class="btn btn-success" v-on:click="goToLoginPage()">Tutor</button>
    </div>
</template>
<script>
    export default {
        name:"Welcome",
        data(){
            return{
                message:"",
            }
        },
        methods:{
            goToLoginPage(){
                this.$router.push(`/login`);
            }
        }
    }
</script>
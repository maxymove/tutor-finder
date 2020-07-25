<template>
    <div class="container">
        <h3>All Courses</h3>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="student in students" v-bind:key="student.id">
                    <td>{{student.id}}</td>
                    <td>{{student.username}}</td>
                    <td>{{student.password}}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    import DataService from '../service/DataService';
    export default {
        name: "UserList",
        data() {
            return {
                students: [],
                message: null,
            };}
    ,
        methods: {
            refreshCourses() {
                DataService.getUserList()
                    .then(response => {
                        this.students = response.data;
                    });
            }
        },
        created() {
            this.refreshCourses();
        }
    };
</script>

<style>
</style>
<template>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>User Id</th>
          <th>User Name</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="user in users" v-bind:key="user.id">
          <td>{{user.id}}</td>
          <td>{{user.username}}</td>
          <td>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
</template>

<script>
import UserService from '../services/user.service';

export default {
  name: 'Admin',
  data() {
    return {
      users: [],
      message:''
    };
  },
  mounted() {
    UserService.getAllUser().then(
      response => {
        this.users = response.data;
      },
      error => {
        this.message = error.response.data
      }
    );
  }
};
</script>

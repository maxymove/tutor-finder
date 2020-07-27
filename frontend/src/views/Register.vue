<template>
        <div class="login-box">
          <h2>Register</h2>
            <form name="form" @submit.prevent="handleRegister">
                <div v-if="!successful">
                    <div class="user-box">
                        <input
                                v-model="user.username"
                                v-validate="'required|min:3|max:20'"
                                type="text"
                                name="username"
                                required=""
                        />
                        <label for="username">Username</label>
                        <div
                                v-if="submitted && errors.has('username')"
                                class="alert-danger"
                        >{{errors.first('username')}}
                        </div>
                    </div>
                    <div class="user-box">
                        <input
                                v-model="user.email"
                                v-validate="'required|email|max:50'"
                                type="email"
                                name="email"
                                required=""
                        />
                        <label for="email">Email</label>
                        <div
                                v-if="submitted && errors.has('email')"
                                class="alert-danger"
                        >{{errors.first('email')}}
                        </div>

                    </div>
                    <div class="user-box">
                        <input
                                v-model="user.password"
                                v-validate="'required|min:6|max:40'"
                                type="password"
                                name="password"
                                required=""
                        />
                        <label for="password">Password</label>
                        <div
                                v-if="submitted && errors.has('password')"
                                class="alert-danger"
                        >{{errors.first('password')}}
                        </div>
                    </div>
                    <div class="user-box">
                        <button class="btn btn-primary btn-block">Sign Up</button>
                    </div>
                </div>
            </form>
            <div
                    v-if="message"
                    class="alert"
                    :class="successful ? 'alert-success' : 'alert-danger'"
            >{{message}}
            </div>
        </div>
</template>

<script>
    import User from '../models/user';

    export default {
        name: 'Register',
        data() {
            return {
                user: new User('', '', ''),
                submitted: false,
                successful: false,
                message: ''
            };
        },
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn;
            }
        },
        mounted() {
            if (this.loggedIn) {
                this.$router.push('/profile');
            }

        },
        methods: {
            handleRegister() {
                this.message = '';
                this.submitted = true;
                this.$validator.validate().then(isValid => {
                    if (isValid) {
                        this.$store.dispatch('auth/register', this.user).then(
                            data => {
                                this.message = data.message;
                                this.successful = true;
                            },
                            error => {
                                this.message =
                                    (error.response && error.response.data) ||
                                    error.message ||
                                    error.toString();
                                this.successful = false;
                            }
                        );
                    }
                });
            }
        }
    };
</script>

<style lang="scss">
    label {
        display: block;
        margin-top: 10px;
    }

    .card-container.card {
        max-width: 350px !important;
        padding: 40px 40px;
    }

    .card {
        background-color: #f7f7f7;
        padding: 20px 25px 30px;
        margin: 0 auto 25px;
        margin-top: 50px;
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    }

    .profile-img-card {
        width: 96px;
        height: 96px;
        margin: 0 auto 10px;
        display: block;
        -moz-border-radius: 50%;
        -webkit-border-radius: 50%;
        border-radius: 50%;
    }
    html {
      height: 100%;
    }
    body {
      margin: 0;
      padding: 0;
      font-family: sans-serif;

    }
    .login-box {
      position: absolute;
      top: 50%;
      left: 50%;
      width: 400px;
      padding: 40px;
      transform: translate(-50%, -50%);
      background: rgba(0,0,0,.5);
      box-sizing: border-box;
      box-shadow: 0 15px 25px rgba(0,0,0,.6);
      border-radius: 10px;
      h2 {
        margin: 0 0 30px;
        padding: 0;
        color: #fff;
        text-align: center;
      }
      .user-box {
        position: relative;
        input {
          width: 100%;
          padding: 10px 0;
          font-size: 16px;
          color: #fff;
          margin-bottom: 30px;
          border: none;
          border-bottom: 1px solid #fff;
          outline: none;
          background: transparent;
          &:focus {
            ~ {
              label {
                top: -20px;
                left: 0;
                color: #03e9f4;
                font-size: 12px;
              }
            }
          }
          &:valid {
            ~ {
              label {
                top: -20px;
                left: 0;
                color: #03e9f4;
                font-size: 12px;
              }
            }
          }
        }
        label {
          position: absolute;
          top: 0;
          left: 0;
          padding: 10px 0;
          font-size: 16px;
          color: #fff;
          pointer-events: none;
          transition: .5s;
        }
      }

    }
</style>
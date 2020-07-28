import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/test/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAllUser() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }

  getAllCourse() {
    return axios.get(API_URL + 'search', { headers: authHeader()})
  }

  getStudentCourseList(){
  return axios.get(API_URL +'profile',{headers:authHeader()});

  }

}

export default new UserService();

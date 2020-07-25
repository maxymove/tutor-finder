import axios from "axios";

// const ROLE = "admin";// admin
const URL = "http://localhost:9090";

class DataService {
getUserList(){
  return axios.get(`${URL}/userlist`)
}
  registerInfo(username,password,email,dob) {
    return axios.post(`${URL}/registerInfo`,username,password,email,dob);
  }
  deleteCourse(name, id) {
      return axios.delete(`${URL}/courses/${id}`);
  }


}

export default new DataService();

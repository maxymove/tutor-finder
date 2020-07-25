import axios from "axios";

const ROLE = "admin";// admin
const PASSWORD = "admin";
const URL = "http://localhost:9090";
const ROLE_API_URL = '${URL}/${ROLE}';

class DataService {
  checkIfAdmin() {
    return axios.get(`${ROLE_API_URL}/login/${ROLE}`);
  }
  deleteCourse(name, id) {
      return axios.delete(`${URL}/courses/${id}`);
  }

}

export default new DataService();
//
// retrieveAllCourses() {
//   return axios.get(`${ROLE_API_URL}/login`,
//       { headers: { authorization: 'Basic ' + window.btoa(ROLE + ":" + PASSWORD) } }
//   );
// }
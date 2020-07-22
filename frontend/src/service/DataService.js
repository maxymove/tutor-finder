import axios from "axios";

const ROLE = "admin";// admin
const COURSE_API_URL = "http://localhost:9090";
const ROLE_API_URL = `${COURSE_API_URL}/${ROLE}`;

class CourseDataService {
  retrieveAllCourses() {
    return axios.get(`${INSTRUCTOR_API_URL}/courses`);
  }
  deleteCourse(name, id) {
      return axios.delete(`${INSTRUCTOR_API_URL}/courses/${id}`);
  }

}

export default new CourseDataService();

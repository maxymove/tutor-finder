package app.tutorfinder;

import app.tutorfinder.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080"}) // port of vue
@RestController
public class LoginController {
    @Autowired
    private CoursesHardCodedService courseManagementService;

    @GetMapping("/login/{username}")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseManagementService.findAll();
    }


}

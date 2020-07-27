package app.tutorfinder.controller;

import app.tutorfinder.MySql;
import app.tutorfinder.models.Course;
import app.tutorfinder.models.User;
import app.tutorfinder.repository.CourseRepository;
import app.tutorfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MySql mySql;

    @GetMapping("/search")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Course> getCourseList() {
        List<Course> courses = new ArrayList<>();
        return courseRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return mySql.getUser(username);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return mySql.getUsers();
    }

    @PostMapping("/add/course/{username}.{courseId}")
    public String addCourse(@PathVariable String username, @PathVariable String courseId) {
        mySql.insertCourse(username, courseId);
        return "successfully added the course.";
    }
}

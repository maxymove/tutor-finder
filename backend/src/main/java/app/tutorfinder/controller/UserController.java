package app.tutorfinder.controller;

import app.tutorfinder.models.Course;
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

    @GetMapping("/course/all")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Course> getCourseList() {
        List<Course> courses = new ArrayList<>();
        return courseRepository.findAll();
    }
//
//    @GetMapping(path = "profile/{id}")
//    public ResponseEntity displayUser(@PathVariable String id){
//        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id));
//    }
}

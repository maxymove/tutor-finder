package app.tutorfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

   @GetMapping("/userlist")
    public List<Student> showAll() {
        List<Student> users = new ArrayList<>();
        Iterable<Student> students = studentRepository.findAll();
       for (Student student : students) {
           users.add(student);
       }
        return users;
    }

    @RequestMapping(value = "/userlist/all", method = RequestMethod.GET)
    public List<String> showUserInfo(@PathVariable(name = "username", required = true) String username) {
        List<String> studentInfo = new ArrayList<>();
        Student student = studentRepository.findByUsername(username);
        studentInfo.add(student.getUsername());
        studentInfo.add(student.getEmail());
        studentInfo.add(student.getDob());
        return studentInfo;
    }
}
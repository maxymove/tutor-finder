package app.tutorfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static List<Student> students = new ArrayList<>();
    private static long idCounter = 0;


    public List<Student> findAll() {
        return students;
    }

}

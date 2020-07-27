package app.tutorfinder.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_taken")
public class CourseTaken {

    @Id
    private String username;
    private String courseId;
}

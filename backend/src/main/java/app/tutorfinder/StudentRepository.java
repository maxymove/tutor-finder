package app.tutorfinder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByUsername(String username);

    boolean existsByUsername(String username);
}
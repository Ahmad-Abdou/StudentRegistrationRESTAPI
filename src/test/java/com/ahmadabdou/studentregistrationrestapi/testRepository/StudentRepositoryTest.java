package com.ahmadabdou.studentregistrationrestapi.testRepository;

import com.ahmadabdou.studentregistrationrestapi.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositoryTest extends CrudRepository<Student,Integer> {

    public Student findByEmailIgnoreCase (String email);

    public Student findByFirstName(String firstName);

    public Student findByLastName(String lastName);


}

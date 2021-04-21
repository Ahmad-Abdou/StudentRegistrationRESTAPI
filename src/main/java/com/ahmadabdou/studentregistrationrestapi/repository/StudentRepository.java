package com.ahmadabdou.studentregistrationrestapi.repository;

import com.ahmadabdou.studentregistrationrestapi.entity.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student,String> {


    public Student findByEmailIgnoreCase (String email);

    public Student findByFirstName(String firstName);

    public Student findByLastName(String lastName);

}

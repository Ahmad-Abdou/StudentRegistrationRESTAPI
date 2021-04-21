package com.ahmadabdou.studentregistrationrestapi.studentTest;

import com.ahmadabdou.studentregistrationrestapi.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;


@SpringBootTest
public class StudentTest {
    private Student student;

    @BeforeEach
    public void setup(){
        student = new Student();


        student.setFirstName("Mehrdad");
        student.setLastName(("Javan"));
        student.setAge(34);
        student.setEmail("test@gmail.com");
        student.setGender("male");
        student.setPhoneNumber("345345252");
        student.setStatus(true);
        student.setRegisterDate(LocalDate.now());
    }

    @Test
    public void save_Student(){

        Assertions.assertEquals("Mehrdad",student.getFirstName());
        Assertions.assertEquals("Javan",student.getLastName());
        Assertions.assertEquals(34,student.getAge());
        Assertions.assertEquals("test@gmail.com",student.getEmail());
        Assertions.assertEquals("male",student.getGender());
        Assertions.assertEquals("345345252",student.getPhoneNumber());
        Assertions.assertEquals(true,student.isStatus());
        Assertions.assertEquals(LocalDate.now(),student.getRegisterDate());

    }


}

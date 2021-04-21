package com.ahmadabdou.studentregistrationrestapi.controller;

import com.ahmadabdou.studentregistrationrestapi.entity.Student;
import com.ahmadabdou.studentregistrationrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") String id){
       Optional <Student> studentOptional = studentRepository.findById(id);

       if(studentOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.OK).body(studentOptional.get());
       }
       else
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")String id){
       Optional <Student> student = studentRepository.findById(id);

       if(student.isPresent()){
           studentRepository.deleteById(id);
           return ResponseEntity.status(HttpStatus.OK).build();
       }
       else {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
    }
    @PostMapping("/")
    public ResponseEntity<Student> save(@RequestBody Student student){
       Student student1 = studentRepository.save(student);
       return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }
    @PutMapping("/")
    public ResponseEntity<Student> update(@RequestBody Student student){

         Student student1 = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(student1);
    }
}

package com.swapnil.PetCare_System.controller;


import com.swapnil.PetCare_System.model.Student;
import com.swapnil.PetCare_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@Controller
@RequestMapping("/api/student")
public class StudentController {

    private  StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        try {
            System.out.println("Received student: " + student);
            studentService.addStudent(student);
            return ResponseEntity.ok("Student added successfully!");
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add student: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentBYId(id), HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) throws Exception {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){

        System.out.println("Student with id to be deleted: "+id);
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}

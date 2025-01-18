package com.swapnil.PetCare_System.service;

import com.swapnil.PetCare_System.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getStudents();

    public Optional<Student> getStudentBYId(Long id);

    public Student updateStudent(Long id, Student student) throws Exception;

    void deleteStudent(Long id);
}

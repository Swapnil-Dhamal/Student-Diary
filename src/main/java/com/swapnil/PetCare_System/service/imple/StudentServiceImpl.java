package com.swapnil.PetCare_System.service.imple;

import com.swapnil.PetCare_System.model.Student;
import com.swapnil.PetCare_System.repo.StudentRepo;
import com.swapnil.PetCare_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentBYId(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) throws Exception {

        Optional<Student> existStudent = studentRepo.findById(id);

        if (existStudent.isPresent()) {

            Student existing = existStudent.get();

            existing.setFirstName(student.getFirstName());
            existing.setLastName(student.getLastName());
            existing.setEmail(student.getEmail());
            existing.setDepartment(student.getDepartment());
            return studentRepo.save(existing);
        } else {
            throw new Exception("Student with id: "+id+" not found");
        }
    }


    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}

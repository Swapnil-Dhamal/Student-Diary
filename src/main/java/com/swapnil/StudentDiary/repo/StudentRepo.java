package com.swapnil.StudentDiary.repo;

import com.swapnil.StudentDiary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long > {

}

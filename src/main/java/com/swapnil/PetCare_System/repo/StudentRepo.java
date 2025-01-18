package com.swapnil.PetCare_System.repo;

import com.swapnil.PetCare_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long > {

}

package com.example.SpringCRUD.Repository;

import com.example.SpringCRUD.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Student,Long> {
}

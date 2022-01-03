package com.example.SpringCRUD.Service;

import com.example.SpringCRUD.Domain.Student;
import com.example.SpringCRUD.Model.StudentReq;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {

    Student saveStudent(StudentReq studentReq);

    Optional<Student> getStudent(Long id);

    List<Student> getStudentList();

    Boolean deleteStudent(Long id);

}

package com.example.SpringCRUD.Service.Impl;

import com.example.SpringCRUD.Domain.Student;
import com.example.SpringCRUD.Model.CommonUtils;
import com.example.SpringCRUD.Model.StudentReq;
import com.example.SpringCRUD.Repository.RegistrationRepo;
import com.example.SpringCRUD.Service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Override
    public Student saveStudent(StudentReq studentReq) {
        Student student = new Student();
        if(!CommonUtils.isObjectNullOrEmpty(studentReq.getId()) && studentReq.getId() != 0){
            student = registrationRepo.getOne(studentReq.getId());
        }
        BeanUtils.copyProperties(studentReq,student);
        return registrationRepo.save(student);
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        Optional<Student> student = registrationRepo.findById(id);
        if (!CommonUtils.isObjectNullOrEmpty(student)) {
            return student;
        } else {
            return null;
        }

    }

    @Override
    public List<Student> getStudentList() {
        return registrationRepo.findAll();
    }

    @Override
    public Boolean deleteStudent(Long id) {
        registrationRepo.deleteById(id);
        return true;
    }


}

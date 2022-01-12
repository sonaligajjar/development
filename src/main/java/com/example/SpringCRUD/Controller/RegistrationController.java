package com.example.SpringCRUD.Controller;

import com.example.SpringCRUD.Domain.Student;
import com.example.SpringCRUD.Model.CommonResponse;
import com.example.SpringCRUD.Model.CommonUtils;
import com.example.SpringCRUD.Model.StudentReq;
import com.example.SpringCRUD.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value =  "/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommonResponse> save(@RequestBody StudentReq student) throws Exception {
        if (!CommonUtils.isObjectNullOrEmpty(student)) {
            return new ResponseEntity<>(
                    new CommonResponse("Save data successfully", registrationService.saveStudent(student),HttpStatus.OK.value()), HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new CommonResponse("There is an error to save data.Please try again", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping(value = "/getStudent/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommonResponse> getStudentDetails(@PathVariable("id") Long id) {
        try {
            Optional<Student> student = registrationService.getStudent(id);
            if(!CommonUtils.isObjectNullOrEmpty(student)) {
                return new ResponseEntity<CommonResponse>(
                        new CommonResponse("Get data successfully", student,HttpStatus.OK.value()), HttpStatus.OK);
            }
            return new ResponseEntity<CommonResponse>(
                    new CommonResponse("There is an error to get data", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CommonResponse("There is an error to save get data", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @GetMapping(value = "/getStudentList")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommonResponse> getStudentList() {
        try {
            List<Student> studentList = registrationService.getStudentList();
            if (!CommonUtils.isListNullOrEmpty(studentList)) {
                return new ResponseEntity<CommonResponse>(
                        new CommonResponse("Get data successfully", registrationService.getStudentList(), HttpStatus.OK.value()), HttpStatus.OK);
            }
            return new ResponseEntity<CommonResponse>(
                    new CommonResponse("There is an error to get data", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CommonResponse("There is an error to get data", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping(value = "/deleteStudent/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommonResponse> deleteStudent(@PathVariable("id") Long id) {
        try {
            Boolean isDeleted = registrationService.deleteStudent(id);
            if (isDeleted) {
                return new ResponseEntity<CommonResponse>(
                        new CommonResponse("Delete record successfully", isDeleted, HttpStatus.OK.value()), HttpStatus.OK);
            }
            return new ResponseEntity<CommonResponse>(
                    new CommonResponse("There is an error to Delete record", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CommonResponse("There is an error to Delete record", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
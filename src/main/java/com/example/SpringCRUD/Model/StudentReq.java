package com.example.SpringCRUD.Model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentReq {

    private Long id;

    private String firstName;

    private String lastName;

    private String courseName;

    private Date birthDate;

    private String gender;

    private String mobile;

    private String address;
}

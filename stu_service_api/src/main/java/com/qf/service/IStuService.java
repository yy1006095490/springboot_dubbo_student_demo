package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {
    List<Student> lsit();
    Student queryById(Integer id);
    int delById(Integer id);
    int insertBy(Student student);
}

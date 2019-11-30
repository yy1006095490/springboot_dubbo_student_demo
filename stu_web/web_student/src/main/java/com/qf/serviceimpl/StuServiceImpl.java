package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClsService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Reference
    private IClsService clsService;


    @Override
    public List<Student> lsit() {
        List<Student> students = stuMapper.selectList(null);
        for(Student student:students){
            Integer cid=student.getCid();
            Classes classes = clsService.queryById(cid);
            student.setCls(classes);
        }
        return students;
    }

    @Override
    public Student queryById(Integer id) {
        return stuMapper.selectById(id);
    }

    @Override
    public int delById(Integer id) {
        return stuMapper.deleteById(id);
    }

    @Override
    public int insertBy(Student student) {
        return stuMapper.insert(student);
    }


}

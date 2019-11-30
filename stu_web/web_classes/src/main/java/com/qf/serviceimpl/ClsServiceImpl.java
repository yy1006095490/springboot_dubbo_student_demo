package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClsMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClsService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClsServiceImpl implements IClsService {

    @Autowired
    private ClsMapper clsMapper;

    @Reference
    private IStuService stuService;

    @Override
    public List<Classes> list() {
        List<Classes> classes = clsMapper.selectList(null);
        for (Classes classes1:classes){
            Student student = stuService.queryById(classes1.getId());
            int a=0;
            if (student!=null){
                a++;
                classes1.setCnum(a);
            }
        }

        return classes;
    }

    @Override
    public Classes queryById(Integer id) {

        return clsMapper.selectById(id);
    }
}

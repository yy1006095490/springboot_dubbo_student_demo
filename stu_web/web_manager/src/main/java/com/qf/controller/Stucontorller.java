package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class Stucontorller {


    @Reference
    private IStuService stuService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Student> lsit = stuService.lsit();
        model.addAttribute("stu",lsit);
        return "stulist";
    }

    @RequestMapping("/del")
    public String del(Integer id){
        int i = stuService.delById(id);
        return "redirect:/stu/list";
    }
    @RequestMapping("/tiaozhuan")
    public String tiaozhuan(){
        return "insert";
    }

    @RequestMapping("/inserts")
    public String inserts(Student student){
        int i = stuService.insertBy(student);

            return "redirect:/stu/list";
    }
}

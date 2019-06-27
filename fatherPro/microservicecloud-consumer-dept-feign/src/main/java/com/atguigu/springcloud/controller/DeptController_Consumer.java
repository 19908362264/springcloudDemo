package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @PostMapping("/consumer/dept/add")
    public boolean add(@RequestParam Dept dept){
        return service.add(dept);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return service.list();
    }

}

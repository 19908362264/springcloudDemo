package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean add(@RequestParam Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

}

package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID：" + id + "没有对应信息");
        }
        return deptService.get(id);
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应信息").setDb_source("no db");
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

}

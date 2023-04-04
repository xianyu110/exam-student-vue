package com.czxy.ssm.controller;

import com.czxy.ssm.domain.Student;
import com.czxy.ssm.service.StudentService;
import com.czxy.ssm.vo.BaseResult;
import com.czxy.ssm.vo.studentVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * http://localhost:8080/student/condition/3/1
     *
     * @return
     */

    @PostMapping("/condition/{pageSize}/{pageNum}")
    public BaseResult condition(
            @PathVariable("pageSize") Integer pageSize,
            @PathVariable("pageNum") Integer pageNum,
            @RequestBody studentVo studentVo) {
        //查询
        PageInfo<Student> pageInfo = studentService.condition(pageSize, pageNum, studentVo);
        //返回结果
        return BaseResult.ok("查询成功", pageInfo);

    }
}

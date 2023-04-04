package com.czxy.ssm.service;

import com.czxy.ssm.domain.Student;
import com.czxy.ssm.vo.studentVo;
import com.github.pagehelper.PageInfo;

public interface StudentService {

    PageInfo<Student> condition(Integer pageSize, Integer pageNum, studentVo studentVo);
}

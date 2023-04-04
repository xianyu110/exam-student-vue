package com.czxy.ssm.service.impl;

import com.czxy.ssm.domain.Classes;
import com.czxy.ssm.domain.Student;
import com.czxy.ssm.mapper.ClassesMapper;
import com.czxy.ssm.mapper.StudentMapper;
import com.czxy.ssm.service.StudentService;
import com.czxy.ssm.vo.studentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@CrossOrigin
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private ClassesMapper classesMapper;

    @Override
    public PageInfo<Student> condition(Integer pageSize, Integer pageNum, studentVo studentVo) {
        // 1 拼凑条件
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        if (studentVo.getCid() != null && !"".equals(studentVo.getCid())) {
            criteria.andEqualTo("cid", studentVo.getCid());
        }
        if (studentVo.getStudentName() != null && !"".equals(studentVo.getStudentName())) {
            criteria.andLike("sname", "%" + studentVo.getStudentName() + "%");
        }
        if (studentVo.getStartAge() != null && !"".equals(studentVo.getStartAge())) {
            criteria.andGreaterThanOrEqualTo("age", studentVo.getStartAge());
        }
        if (studentVo.getEndAge() != null && !"".equals(studentVo.getEndAge())) {
            criteria.andLessThanOrEqualTo("age", studentVo.getEndAge());
        }

        // 2 分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 3 查询
        List<Student> list = studentMapper.selectByExample(example);

        // 4 处理管理数据
        for (Student student : list) {
            Classes classes = classesMapper.selectByPrimaryKey(student.getCid());
            student.setClasses(classes);
        }
        // 5 返回
        return new PageInfo<>(list);
    }
}

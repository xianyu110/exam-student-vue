package com.czxy.ssm.service.impl;

import com.czxy.ssm.domain.Classes;
import com.czxy.ssm.domain.Student;
import com.czxy.ssm.mapper.ClassesMapper;
import com.czxy.ssm.mapper.StudentMapper;
import com.czxy.ssm.service.ClassesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {

    @Resource
    private ClassesMapper classesMapper;

    @Resource
    private StudentMapper studentMapper;

    /**
     * 查询所有
     *
     * @return
     */

    @Override
    public List<Classes> selectAll() {
        List<Classes> List = classesMapper.selectAll();
        return List;
    }

    /**
     * 添加
     *
     * @param classes
     * @return
     */
    @Override
    public boolean save(Classes classes) {
        // 校验
        Classes find = classesMapper.selectByPrimaryKey(classes.getCid());
        if (find != null) {
            throw new RuntimeException("ID已存在");
        }
        // 添加
        int count = classesMapper.insert(classes);
        return count == 1;
    }

    /**
     * 修改
     *
     * @param classes
     * @return
     */

/*    @Override
    public boolean update(Classes classes){
        // 校验
        Classes find = classesMapper.selectByPrimaryKey(classes.getCid());
        if(find == null){
            throw new RuntimeException("ID不存在");
        }
        // 更新非空项
        int count = classesMapper.updateByPrimaryKeySelective(classes);
        return count == 1;
    }*/
    /**
     * 删除
     * @param classId
     * @return
     */
    @Override
    public boolean deleteById(String classId) {
        // 查询指定班级id的学生数
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid", classId);
        int studentCount = studentMapper.selectCountByExample(example);
        if(studentCount > 0) {
            throw new RuntimeException("班级已关联学生，不能删除");
        }

        int count = classesMapper.deleteByPrimaryKey(classId);
        return count == 1;
    }
}

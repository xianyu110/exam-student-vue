package com.czxy.ssm.service;

import com.czxy.ssm.domain.Classes;

import java.util.List;

public interface ClassesService {
    /**
     * 查询所有
     *
     * @return
     */
    public List<Classes> selectAll();

    /**
     * 添加班级
     */
    public boolean save(Classes classes);

    /**
     * 修改
     *
     * @param classes
     * @return
     */
//    public boolean update(Classes classes);

    /**
     * 删除
     *
     * @param classId
     * @return
     */
    public boolean deleteById(String classId);
}

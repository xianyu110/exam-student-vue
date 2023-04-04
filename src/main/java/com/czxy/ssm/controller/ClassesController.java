package com.czxy.ssm.controller;

import com.czxy.ssm.domain.Classes;
import com.czxy.ssm.service.ClassesService;
import com.czxy.ssm.vo.BaseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/classes")
@CrossOrigin
public class ClassesController {

    @Resource
    private ClassesService classesService;

    /**
     * 查询所有
     *
     * @return
     */

    @GetMapping
    public BaseResult<List<Classes>> list() {
        List<Classes> List = classesService.selectAll();
        return BaseResult.ok("查询成功", List);
    }

    /**
     * 添加班级
     */

    @PostMapping
    public BaseResult save(@RequestBody Classes classes) {
        try {
            // 添加
            boolean result = classesService.save(classes);
            // 返回
            if (result) {
                return BaseResult.ok("添加成功");
            } else {
                return BaseResult.error("添加失败");
            }
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }

    /**
     * 修改
     *
     * @param classes
     * @return
     */
/*
    @PutMapping
    public BaseResult update(@RequestBody Classes classes) {
        try {
            // 添加
            boolean result = classesService.update(classes);
            // 返回
            if (result) {
                return BaseResult.ok("更新成功");
            } else {
                return BaseResult.error("更新失败");
            }
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }
*/

    /**
     * 删除
     *
     * @param classId
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult deleteById(@PathVariable("id") String classId) {
        try {
            // 查询
            boolean result = classesService.deleteById(classId);
            // 返回
            if (result) {
                return BaseResult.ok("删除成功");
            } else {
                return BaseResult.error("删除失败");
            }
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }
}

package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDepartmentService {
    /**
     * 查询所有部门信息
     */
    List<Department> selectAll();

    /**
     * 保存部门信息
     */
    void save(Department department);

    /**
     * 修改部门信息
     */
    void update(Department department);

    /**
     * 根据部门id查找部门信息
     */
    Department selectById(Long id);

    /**
     * 根据部门id删除部门信息
     */
    void delete(Long id);

    /**
     * 查询部门分页数据
     */
    PageInfo<Department> selectForList(QueryObject qo);
}

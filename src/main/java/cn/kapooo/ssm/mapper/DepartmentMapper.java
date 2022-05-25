package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.qo.QueryObject;

import java.util.List;

public interface DepartmentMapper {
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
     * 查询部门数据的总条数
     */
    int selectForCount(QueryObject qo);

    /**
     * 每个部门分页的数据
     */
    List<Department> selectForList(QueryObject qo);
}

package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.qo.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询所有员工信息
     */
    List<Employee> selectAll();

    /**
     * 保存员工信息
     */
    void save(Employee employee);

    /**
     * 保存员工和角色的信息
     */
    void saveRelation(@Param("employeeId") Long employeeId, @Param("roleIds") Long[] roleIds);

    /**
     * 修改员工信息
     */
    void update(Employee employee);

    /**
     * 根据员工id查找员工信息
     */
    Employee selectById(Long id);

    /**
     * 根据员工id删除员工信息
     */
    void delete(Long id);

    /**
     * 根据员工id删除员工和角色的关系
     */
    void deleteByEmployeeId(Long id);

    /**
     * 查询员工数据的总条数
     */
    int selectForCount(QueryObject qo);

    /**
     * 每个员工分页的数据
     */
    List<Employee> selectForList(QueryObject qo);

    /**
     * 通过账号查账号密码数据
     */
    Employee selectLoginByUsername(@Param("username") String username);

    /**
     * 根据员工id修改登录尝试次数
     */
    void updateTestNumByEmployeeId(@Param("id") Long id, @Param("testNum") int testNum);


}

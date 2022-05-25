package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeService {
    /**
     * 查询所有员工信息
     */
    List<Employee> selectAll();

    /**
     * 保存员工信息
     */
    void save(Employee employee,Long[] roleIds);

    /**
     * 修改员工信息
     */
    void update(Employee employee,Long[] roleIds);

    /**
     * 根据员工id查找员工信息
     */
    Employee selectById(Long id);

    /**
     * 根据员工id删除员工信息
     */
    void delete(Long id);

    /**
     * 查员工分页数据
     */
    PageInfo<Employee> selectForList(QueryObject qo);

    /**
     * 通过账号查登录数据
     */
    Employee selectLoginByUsername(String username);

    /**
     * 根据员工id修改登录尝试次数
     */
    void updateTestNumByEmployeeId(Long id, int testNum);

}

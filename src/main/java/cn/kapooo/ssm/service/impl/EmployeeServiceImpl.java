package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.mapper.EmployeeMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public void save(Employee employee, Long[] roleIds) {
        //保存员工的数据
        employeeMapper.save(employee);
        //保存员工和角色关系数据
        employeeMapper.saveRelation(employee.getId(), roleIds);
    }

    @Override
    public void update(Employee employee, Long[] roleIds) {
        //修改员工的数据
        employeeMapper.update(employee);
        //删除员工和角色的关系
        employeeMapper.deleteByEmployeeId(employee.getId());
        //添加新的员工和角色的关系
        employeeMapper.saveRelation(employee.getId(), roleIds);
    }

    @Override
    public Employee selectById(Long id) {
        return employeeMapper.selectById(id);
    }


    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }

    @Override
    public PageInfo<Employee> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询员工分页数据
        List<Employee> employeeList = employeeMapper.selectForList(qo);
        return new PageInfo<>(employeeList);
    }

    @Override
    public Employee selectLoginByUsername(String username) {
        return employeeMapper.selectLoginByUsername(username);
    }


    @Override
    public void updateTestNumByEmployeeId(Long id, int testNum) {
        employeeMapper.updateTestNumByEmployeeId(id, testNum);
    }



}

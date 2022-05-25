package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.mapper.DepartmentMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public void save(Department department) {
        departmentMapper.save(department);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public Department selectById(Long id) {
        return departmentMapper.selectById(id);
    }


    @Override
    public void delete(Long id) {
        departmentMapper.delete(id);
    }

    @Override
    public PageInfo<Department> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询部门分页数据
        List<Department> departmentList = departmentMapper.selectForList(qo);
        return new PageInfo<>(departmentList);
    }
}

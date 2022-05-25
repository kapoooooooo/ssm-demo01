package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Role;
import cn.kapooo.ssm.mapper.DepartmentMapper;
import cn.kapooo.ssm.mapper.RoleMapper;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> selectAllByEmployeeId(Long employeeId) {
        return roleMapper.selectAllByEmployeeId(employeeId);
    }

    @Override
    public void save(Role role, Long[] permissionIds) {
        //保存角色信息
        roleMapper.save(role);
        //保存角色与权限的关系
        roleMapper.saveRelation(role.getId(),permissionIds);
    }

    @Override
    public void update(Role role, Long[] permissionIds) {
        //修改角色信息
        roleMapper.update(role);
        //删除角色与权限的关系
        roleMapper.deleteByRoleId(role.getId());
        //添加新的关系
        roleMapper.saveRelation(role.getId(), permissionIds);
    }

    @Override
    public Role selectById(Long id) {
        return roleMapper.selectById(id);
    }


    @Override
    public void delete(Long id) {
        //删除角色数据
        roleMapper.delete(id);
        //删除角色与权限的关系
        roleMapper.deleteByRoleId(id);
    }

    @Override
    public PageInfo<Role> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询角色分页数据
        List<Role> roleList = roleMapper.selectForList(qo);
        return new PageInfo<>(roleList);
    }
}

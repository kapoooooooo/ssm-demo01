package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.mapper.PermissionMapper;
import cn.kapooo.ssm.mapper.RoleMapper;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public PageInfo<Permission> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询权限分页数据
        List<Permission> permissionList = permissionMapper.selectForList(qo);
        return new PageInfo<>(permissionList);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> selectAllByRoleId(Long roleId) {
        return permissionMapper.selectAllByRoleId(roleId);
    }

    @Override
    public void save(List<Permission> permissionList) {
        if (permissionList != null && permissionList.size() > 0){
            permissionMapper.save(permissionList);
        }

    }

    @Override
    public boolean selectByNameExpression(String name, String expression) {
        return permissionMapper.selectByNameExpression(name, expression);
    }

    @Override
    public List<String> selectAllExpression() {
        return permissionMapper.selectAllExpression();
    }

    @Override
    public List<String> selectExpressionByEmployeeId(Long id) {
        return permissionMapper.selectExpressionByEmployeeId(id);
    }
}

package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPermissionService {
    /**
     * 查权限分页数据
     */
    PageInfo<Permission> selectForList(QueryObject qo);

    /**
     * 查询全部权限
     */
    List<Permission> selectAll();

    /**
     * 根据角色id查询角色拥有的权限
     */
    List<Permission> selectAllByRoleId(Long roleId);

    /**
     * 保存权限到数据库中
     */
    void save(List<Permission> permissionList);

    /**
     * 根据权限名称和表达式查权限
     */
    boolean selectByNameExpression(String name, String expression);

    /**
     * 查询全部权限表达式
     */
    List<String> selectAllExpression();

    /**
     * 根据员工id查询员工拥有的权限
     */
    List<String> selectExpressionByEmployeeId(Long id);
}

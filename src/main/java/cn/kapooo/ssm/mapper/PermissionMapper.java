package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.qo.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {

    /**
     * 每个权限分页的数据
     */
    List<Permission> selectForList(QueryObject qo);

    /**
     * 查询全部权限
     */
    List<Permission> selectAll();

    /**
     * 根据角色id查询角色拥有的权限
     */
    List<Permission> selectAllByRoleId(@Param("roleId") Long roleId);

    /**
     * 保存权限到数据库中
     */
    void save(@Param("permissionList") List<Permission> permissionList);

    /**
     * 根据权限名称和表达式查权限是否存在
     */
    boolean selectByNameExpression(@Param("name") String name, @Param("expression") String expression);

    /**
     * 查询全部权限表达式
     */
    List<String> selectAllExpression();

    /**
     * 根据员工id查询员工拥有的权限
     */
    List<String> selectExpressionByEmployeeId(Long id);
}

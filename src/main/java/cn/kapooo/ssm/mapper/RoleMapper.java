package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.domain.Role;
import cn.kapooo.ssm.qo.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有角色信息
     */
    List<Role> selectAll();

    /**
     * 根据员工id查询员工拥有的角色
     */
    List<Role> selectAllByEmployeeId(@Param("employeeId") Long employeeId);

    /**
     * 保存角色信息
     */
    void save(Role role);

    /**
     * 保存角色和权限关系
     */
    void saveRelation(@Param("roleId") Long roleId, @Param("permissionIds") Long[] permissionIds);

    /**
     * 修改角色信息
     */
    void update(Role role);

    /**
     * 根据角色id查找角色信息
     */
    Role selectById(Long id);

    /**
     * 根据角色id删除角色信息
     */
    void delete(Long id);

    /**
     * 根据角色id删除角色与全部权限的关系
     */
    void deleteByRoleId(Long id);

    /**
     * 查询角色数据的总条数
     */
    int selectForCount(QueryObject qo);

    /**
     * 每个角色分页的数据
     */
    List<Role> selectForList(QueryObject qo);
}

package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.domain.Role;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleService {
    /**
     * 查询所有角色信息
     */
    List<Role> selectAll();

    /**
     * 根据员工id查询员工拥有的角色
     */
    List<Role> selectAllByEmployeeId(Long employeeId);

    /**
     * 保存角色信息，角色与权限的关系
     */
    void save(Role role, Long[] permissionIds);

    /**
     * 修改角色信息，角色与权限的关系
     */
    void update(Role role, Long[] permissionIds);

    /**
     * 根据角色id查找角色信息
     */
    Role selectById(Long id);

    /**
     * 根据角色id删除角色信息
     */
    void delete(Long id);

    /**
     * 查角色分页数据
     */
    PageInfo<Role> selectForList(QueryObject qo);
}

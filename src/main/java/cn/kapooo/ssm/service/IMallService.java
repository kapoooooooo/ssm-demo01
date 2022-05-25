package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Mall;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMallService {
    /**
     * 查询所有商城信息
     */
    List<Mall> selectAll();

    /**
     * 保存商城信息
     */
    void save(Mall mall);

    /**
     * 修改商城信息
     */
    void update(Mall mall);

    /**
     * 根据商城id查找商城信息
     */
    Mall selectById(Long id);

    /**
     * 根据商城id删除商城信息
     */
    void delete(Long id);

    /**
     * 查商城分页数据
     */
    PageInfo<Mall> selectForList(QueryObject qo);
}

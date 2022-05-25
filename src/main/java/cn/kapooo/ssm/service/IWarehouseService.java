package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IWarehouseService {
    /**
     * 查询所有库存信息
     */
    List<Warehouse> selectAll();

    /**
     * 保存库存信息
     */
    void save(Warehouse warehouse);

    /**
     * 修改库存信息
     */
    void update(Warehouse warehouse);

    /**
     * 根据库存id查找库存信息
     */
    Warehouse selectById(Long id);

    /**
     * 根据库存id删除库存信息
     */
    void delete(Long id);

    /**
     * 查库存分页的数据
     */
    PageInfo<Warehouse> selectForList(QueryObject qo);
}

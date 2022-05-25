package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;

import java.util.List;

public interface WarehouseMapper {
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
     * 查询库存数据的总条数
     */
    int selectForCount(QueryObject qo);

    /**
     * 查询库存分页数据
     */
    List<Warehouse> selectForList(QueryObject qo);
}

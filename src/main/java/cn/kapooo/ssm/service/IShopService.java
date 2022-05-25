package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Shop;
import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IShopService {
    /**
     * 查询所有商店信息
     */
    List<Shop> selectAll();

    /**
     * 保存商店信息
     */
    void save(Shop shop);

    /**
     * 修改商店信息
     */
    void update(Shop shop);

    /**
     * 根据商店id查找商店信息
     */
    Shop selectById(Long id);

    /**
     * 根据商店id删除商店信息
     */
    void delete(Long id);

    /**
     * 查商店分页的数据
     */
    PageInfo<Shop> selectForList(QueryObject qo);

    /**
     * 根据商店id获取推荐货物(销量最高)
     */
    Goods getBestGoods(Long id);
}

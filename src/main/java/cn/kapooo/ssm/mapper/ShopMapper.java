package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Shop;
import cn.kapooo.ssm.qo.QueryObject;

import java.util.List;

public interface ShopMapper {
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
     * 查询商店数据的总条数
     */
    int selectForCount(QueryObject qo);

    /**
     * 每个商店分页的数据
     */
    List<Shop> selectForList(QueryObject qo);


    /**
     * 根据商店id获取推荐商品(销量最高)
     */
    Goods getBestGoods(Long id);


}

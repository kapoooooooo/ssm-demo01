package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Mall;
import cn.kapooo.ssm.qo.QueryObject;

import java.util.List;

public interface MallMapper {
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
     * 查询商城数据的总条数
     */
    int selectForCount(QueryObject qo);

    /**
     * 每个商城分页的数据
     */
    List<Mall> selectForList(QueryObject qo);

    /**
     * 根据商城id获取商城拥有的商品数量
     */
    Integer getMallGoodsNum(Long id);

    /**
     * 根据商城id获取销量最高商品的
     */
    List<Goods> getMostNumGoods(Long id);
}

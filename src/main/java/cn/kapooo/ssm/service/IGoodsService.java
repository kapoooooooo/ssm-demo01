package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IGoodsService {
    /**
     * 查询所有商品信息
     */
    List<Goods> selectAll();

    /**
     * 保存商品信息
     */
    void save(Goods goods);

    /**
     * 修改商品信息
     */
    void update(Goods goods);

    /**
     * 根据商品id查找商品信息
     */
    Goods selectById(Long id);

    /**
     * 根据商品id删除商品信息
     */
    void delete(Long id);

    /**
     * 查商品分页数据
     */
    PageInfo<Goods> selectForList(QueryObject qo);

    /**
     * 根据商店的id获取商店拥有商品的数量
     */
    Integer getGoodsNum(Long id);
}

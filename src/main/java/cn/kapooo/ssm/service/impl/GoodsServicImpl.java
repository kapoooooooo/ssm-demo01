package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.mapper.GoodsMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServicImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public void save(Goods goods) {
        goodsMapper.save(goods);
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public Goods selectById(Long id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public void delete(Long id) {
        goodsMapper.delete(id);
    }

    @Override
    public PageInfo<Goods> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询商品分页数据
        List<Goods> goodsList = goodsMapper.selectForList(qo);
        return new PageInfo<>(goodsList);
    }

    @Override
    public Integer getGoodsNum(Long id) {
        return goodsMapper.getGoodsNum(id);
    }
}

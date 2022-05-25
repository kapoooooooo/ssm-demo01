package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Mall;
import cn.kapooo.ssm.domain.Shop;
import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.mapper.ShopMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }

    @Override
    public void save(Shop shop) {
        shopMapper.save(shop);
    }

    @Override
    public void update(Shop shop) {
        shopMapper.update(shop);
    }

    @Override
    public Shop selectById(Long id) {
        return shopMapper.selectById(id);
    }

    @Override
    public void delete(Long id) {
        shopMapper.delete(id);
    }

    @Override
    public PageInfo<Shop> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询商店分页数据
        List<Shop> shopList = shopMapper.selectForList(qo);
        return new PageInfo<>(shopList);

    }

    @Override
    public Goods getBestGoods(Long id) {
        return shopMapper.getBestGoods(id);
    }
}

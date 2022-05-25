package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Shop;
import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.mapper.WarehouseMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IWarehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> selectAll() {
        return warehouseMapper.selectAll();
    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseMapper.save(warehouse);
    }

    @Override
    public void update(Warehouse warehouse) {
        warehouseMapper.update(warehouse);
    }

    @Override
    public Warehouse selectById(Long id) {
        return warehouseMapper.selectById(id);
    }

    @Override
    public void delete(Long id) {
        warehouseMapper.delete(id);
    }

    @Override
    public PageInfo<Warehouse> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询库存分页数据
        List<Warehouse> warehouseList = warehouseMapper.selectForList(qo);
        return new PageInfo<>(warehouseList);
    }
}

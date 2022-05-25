package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Mall;
import cn.kapooo.ssm.mapper.GoodsMapper;
import cn.kapooo.ssm.mapper.MallMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IMallService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MallServiceImpl implements IMallService {

    @Autowired
    private MallMapper mallMapper;

    @Override
    public List<Mall> selectAll() {
        return mallMapper.selectAll();
    }

    @Override
    public void save(Mall mall) {
        mallMapper.save(mall);
    }

    @Override
    public void update(Mall mall) {
        mallMapper.update(mall);
    }

    @Override
    public Mall selectById(Long id) {
        return mallMapper.selectById(id);
    }

    @Override
    public void delete(Long id) {
        mallMapper.delete(id);
    }

    @Override
    public PageInfo<Mall> selectForList(QueryObject qo) {
        //设置分页参数
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //查询商城分页数据
        List<Mall> mallList = mallMapper.selectForList(qo);
        return new PageInfo<>(mallList);
    }
}

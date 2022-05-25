package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Shop;
import cn.kapooo.ssm.mapper.DepartmentMapper;
import cn.kapooo.ssm.mapper.EmployeeMapper;
import cn.kapooo.ssm.mapper.ShopMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    public void test(){
        QueryObject qo = new QueryObject();
        PageHelper.startPage(1,3);
        PageInfo<Department> pageInfo = new PageInfo<>(departmentMapper.selectForList(qo));
        System.out.println(pageInfo);
    }

}
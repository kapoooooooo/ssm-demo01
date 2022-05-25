package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        System.out.println(departmentList);
    }
    @Test
    public void save(){
        Department department = new Department();
        department.setName("小卖部");
        department.setSn("X101");
        departmentService.save(department);
    }
    @Test
    public void update(){
        Department department = new Department();
        department.setId(10L);
        department.setName("小卖部");
        department.setSn("010");
        departmentService.update(department);
    }
    @Test
    public void selectOne(){
        Department department = departmentService.selectById(10L);
        System.out.println(department);
    }
}
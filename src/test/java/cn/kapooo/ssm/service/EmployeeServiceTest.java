package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void selectAll() {
        List<Employee> emloyeeList = employeeService.selectAll();
        System.out.println(emloyeeList);
    }

    @Test
    public void save() {
        Department department = new Department(1L,"测试","123");
//        Employee employee = new Employee(null,"测试", "测试", 19, "123", true ,department);
//        employeeService.save(employee);
    }

    @Test
    public void update() {
        Department department = new Department(10L,"测试","123");
//        Employee employee = new Employee(2L,"测123试", "测123试", 19, "123", true ,department);
//        employeeService.update(employee);
    }

    @Test
    public void selectById() {
    }

    @Test
    public void delete() {
        employeeService.delete(2L);
    }
}
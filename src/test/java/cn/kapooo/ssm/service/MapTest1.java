package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapTest1 {


    /**
     * 学号对应一个学生
     *
     */
    @Test
    public void testMap1() {
        Map<String, String> map = new HashMap<>();
        map.put("001", "小红");
        map.put("002", "小黄");
        System.out.println(map);
    }

    /**
     * 教室编号对应多个学生
     *
     */
    @Test
    public void testMap2() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> studentList1 = new ArrayList<>();
        studentList1.add("小红");
        studentList1.add("小黄");
        map.put("101", studentList1);

        List<String> studentList2 = new ArrayList<>();
        studentList2.add("小张");
        studentList2.add("小王");
        map.put("102", studentList2);

        System.out.println(map);
    }

    /**
     * 办公室编号对应多个员工
     *  101   e1,e2
     *  102   e3,e4
     */
    @Test
    public void testMap3() {
        Map<String, List<Employee>> map = new HashMap<>();
        Employee e1 = new Employee();
        e1.setId(1L);
        e1.setName("张三");
        Employee e2 = new Employee();
        e2.setId(2L);
        e2.setName("李四");
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(e1);
        employeeList1.add(e2);


        Employee e3 = new Employee();
        e3.setId(3L);
        e3.setName("王五");
        Employee e4 = new Employee();
        e4.setId(4L);
        e4.setName("赵六");
        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(e3);
        employeeList2.add(e4);


        map.put("101", employeeList1);
        map.put("102", employeeList2);

        System.out.println(employeeList1);
        System.out.println(employeeList2);
        System.out.println(map);
    }

    /**
     *  计算字符串中每个字符出现的次数
     *  String str= “abcabcasdasffffdaewre”
     *  结果 ： {a=5, b=2, r=1, c=2, s=2, d=2, e=2, f=4, w=1}
     */
    @Test
    public void testStaticLetterCount() {
        Map<String, Integer> map = new HashMap<>();
        String str= "abcabcasdasffffdaewre";
        String[] letters = str.split("");
        System.out.println(Arrays.toString(letters));

        for (int i = 0; i < letters.length; i++){
            if(!map.containsKey(letters[i])){
                map.put(letters[i], 1);
            } else {
                map.put(letters[i], map.get(letters[i])+1);

            }
        }
        System.out.println(map);
    }

    /**
     *  集合转map
     *  商品[goods1, goods2, goods3]
     *  map key:shopId
     *      value:goods
     */
    @Test
    public void testStaticGoodsCount() {
        //华为旗舰店。两个商品 。
        Shop hwShop = new Shop();
        hwShop.setId(1L);

        Goods hwGoods1 = new Goods();
        hwGoods1.setId(1L);
        hwGoods1.setName("hw手机");
        hwGoods1.setShop(hwShop);

        Goods hwGoods2 = new Goods();
        hwGoods2.setId(2L);
        hwGoods2.setName("hw手机");
        hwGoods2.setShop(hwShop);

        //小米旗舰店。两个商品。
        Shop xmShop = new Shop();
        xmShop.setId(2L);

        Goods xmGoods1 = new Goods();
        xmGoods1.setId(3L);
        xmGoods1.setName("xm手机1");
        xmGoods1.setShop(xmShop);

        Goods xmGoods2 = new Goods();
        xmGoods2.setId(4L);
        xmGoods2.setName("xm手机2");
        xmGoods2.setShop(xmShop);

        //添加到集合中
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(hwGoods1);
        goodsList.add(hwGoods2);
        goodsList.add(xmGoods1);
        goodsList.add(xmGoods2);


        Map<Long, List<Goods>> map = new HashMap<>();

        for (Goods goods : goodsList) {
            Long shopId = goods.getShop().getId();
            if (!map.containsKey(shopId)) {
                List<Goods> tempList = new ArrayList<Goods>();
                tempList.add(goods);
                map.put(shopId, tempList);
            } else {
                List<Goods> tempList = map.get(shopId);
                tempList.add(goods);
                map.put(shopId, tempList);
            }
        }
        System.out.println(map);
    }
}
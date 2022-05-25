package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.*;
import cn.kapooo.ssm.qo.JsonResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class TestController {

    @Autowired
    private HttpSession session;

    @RequestMapping("/test1")
    @ResponseBody
    public JsonResult test1(){
        Mall mall = new Mall();
        mall.setId(1L);
        mall.setName("jd商城");

        ArrayList<Shop> shopList = new ArrayList<>();
        Shop shop1 = new Shop();
        shop1.setId(1L);
        shop1.setName("小米旗舰店");

        Shop shop2 = new Shop();
        shop2.setId(2L);
        shop2.setName("华为旗舰店");

        shopList.add(shop1);
        shopList.add(shop2);

        mall.setShopList(shopList);

        return JsonResult.success("成功", mall);
    }

    @RequestMapping("/test2")
    @ResponseBody
    public JsonResult test2(){
        User user = new User();
        ArrayList<Group> groupList = new ArrayList<>();
        ArrayList<Head> headList1 = new ArrayList<>();
        ArrayList<Head> headList2 = new ArrayList<>();

        Head head1 = new Head();
        Head head2 = new Head();
        Head head3 = new Head();
        Head head4 = new Head();
        Head head5 = new Head();
        head1.setId(1L);
        head1.setUrl("xxx");
        head2.setId(2L);
        head2.setUrl("xxx");
        head3.setId(3L);
        head3.setUrl("xxx");
        head4.setId(4L);
        head4.setUrl("xxx");
        head5.setId(5L);
        head5.setUrl("xxx");

        headList1.add(head1);
        headList1.add(head2);
        headList1.add(head3);

        headList2.add(head4);
        headList2.add(head5);

        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Group group1 = new Group();
        Group group2 = new Group();
        group1.setId(1L);
        group1.setName("相亲相爱一家人");
        group1.setNewMsg("最新一条消息");
        group1.setTime(time.format(formatter));
        group1.setHeadList(headList1);
        group2.setId(2L);
        group2.setName("班级群");
        group2.setNewMsg("最新一条消息");
        group2.setTime(time.format(formatter));
        group2.setHeadList(headList2);

        groupList.add(group1);
        groupList.add(group2);

        user.setId(1L);
        user.setName("小康");
        user.setImg("xxxxx");
        user.setState("在线");
        user.setGourpList(groupList);

        return JsonResult.success("成功", user);
    }
    @RequestMapping("/test3")
    @ResponseBody
    public JsonResult test3(){
        //首次选没有数据
        Integer count = (Integer) session.getAttribute("count");
        if(count == null){
            //初始值 1
            count = 1;
            session.setAttribute("count", count);
        }else {
            count = (Integer) session.getAttribute("count");
            count++;
            session.setAttribute("count", count);
        }
        return JsonResult.success("成功", count);
    }

}

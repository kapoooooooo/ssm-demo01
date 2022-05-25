package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.*;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IEmployeeService;
import cn.kapooo.ssm.service.IMallService;
import cn.kapooo.ssm.service.IShopService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IMallService mallService;

    // 处理查询所有商店请求
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查商店数据
        PageInfo<Shop> pageInfo = shopService.selectForList(qo);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("shop/list");
        return mv; // 找视图 /WEB-INF/views/shop/list.jsp
    }

    // 判断添加/修改商店
    @RequestMapping("/input")
    public String input(Long id, Model model){
        //查全部商城信息
        List<Mall> mallList = mallService.selectAll();
        //查全部员工信息
        List<Employee> employeeList = employeeService.selectAll();
        //提供数据，让商店添加/修改时显出商城和员工来以供用户选择
        model.addAttribute("mallList", mallList);
        model.addAttribute("employeeList", employeeList);
        if (id != null) { // 有id => 表示去修改
            //根据商店id查询商店信息
            Shop shop = shopService.selectById(id);
            model.addAttribute("shop", shop);
        }
        return "shop/input"; //完成操作后重新回到list页面
    }

    //处理保存或修改商店的请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Shop shop){
        if (shop.getId() == null){//无id => 保存商店信息
            shopService.save(shop);
        }else{//有id => 修改商店信息
            shopService.update(shop);
        }
        return "redirect:/shop/list"; //完成操作后重新回到list页面
    }

    // 处理删除商店请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据店铺id删除商店信息
            shopService.delete(id);
        }
        return "redirect:/shop/list"; //完成操作后重新回到list页面
    }
}

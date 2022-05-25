package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.mapper.GoodsMapper;
import cn.kapooo.ssm.mapper.WarehouseMapper;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IGoodsService;
import cn.kapooo.ssm.service.IWarehouseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private IGoodsService goodsService;

    // 处理查询所有库存请求
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查库存数据
        PageInfo<Warehouse> pageInfo = warehouseService.selectForList(qo);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("warehouse/list");
        return mv; // 找视图 /WEB-INF/views/warehouse/list.jsp
    }

    // 判断添加/修改库存
    @RequestMapping("/input")
    public String input(Long id, Model model){
        //查所有商品信息
        List<Goods> goodsList = goodsService.selectAll();
        //提供数据，让库存添加/修改时显示出来以供用户选择
        model.addAttribute("goodsList", goodsList);
        if (id != null) { //有id => 表示去修改
            //根据库存id查库存数据
            Warehouse warehouse = warehouseService.selectById(id);
            model.addAttribute("warehouse", warehouse);
        }
        return "warehouse/input"; //完成操作后重新回到list页面
    }

    //处理保存或修改库存的请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Warehouse warehouse){
        if (warehouse.getId() == null){//无id 保存库存信息
            warehouseService.save(warehouse);
        }else{//有id 修改库存信息
            warehouseService.update(warehouse);
        }
        return "redirect:/warehouse/list"; //完成操作后重新回到list页面
    }

    // 处理删除库存请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据库存id删除库存数据
            warehouseService.delete(id);
        }
        return "redirect:/warehouse/list"; //完成操作后重新回到list页面
    }
}

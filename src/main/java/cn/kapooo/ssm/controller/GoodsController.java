package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Shop;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IGoodsService;
import cn.kapooo.ssm.service.IShopService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IShopService shopService;

    // 处理查询所有商品请求
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查商品数据
        PageInfo<Goods> pageInfo = goodsService.selectForList(qo);
        //设置查询结果到作用域
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("goods/list");
        return mv; // 找视图 /WEB-INF/views/goods/list.jsp
    }

    // 判断添加/修改商品请求
    @RequestMapping("/input")
    public String input(Long id, Model model){
        // 查全部店铺的数据
        List<Shop> shopList = shopService.selectAll();
        // 设置到作用域中，让商品添加/修改时显示出来以供用户选择
        model.addAttribute("shopList", shopList);
        if (id != null) { //无id => 表示去修改
            // 根据id查询商品数据
            Goods goods = goodsService.selectById(id);
            //设置查询结果到作用域
            model.addAttribute("goods", goods);
        }
        return "goods/input"; // 完成操作后重新回到list页面
    }

    //处理保存/修改商品的请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Goods goods){
        if (goods.getId() == null){//无id => 保存货物信息
            goodsService.save(goods);
        }else{//有id => 修改货物信息
            goodsService.update(goods);
        }
        return "redirect:/goods/list"; // 完成操作后重新回到list页面
    }

    // 处理删除商品请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据商品id删除商品数据
            goodsService.delete(id);
        }
        return "redirect:/goods/list"; // 完成操作后重新回到list页面
    }
}

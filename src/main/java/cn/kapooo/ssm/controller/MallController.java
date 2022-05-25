package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Goods;
import cn.kapooo.ssm.domain.Mall;
import cn.kapooo.ssm.domain.Warehouse;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IMallService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mall")
public class MallController {

    @Autowired
    private IMallService mallService;

    // 处理查询所有商城请求
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查商城数据
        PageInfo<Mall> pageInfo = mallService.selectForList(qo);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("mall/list");
        return mv; // 找视图 /WEB-INF/views/mall/list.jsp
    }

    // 判断添加/修改商城的请求
    @RequestMapping("/input")
    public String input(Long id, Model model){
        if (id != null) { // 无id => 表示去修改
            // 根据商城id查询商城数据
            Mall mall = mallService.selectById(id);
            model.addAttribute("mall", mall);
        }
        return "mall/input"; // 完成操作后重新回到list页面
    }

    //处理保存/修改商城的请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Mall mall){
        if (mall.getId() == null){//无id => 新增商城信息
            mallService.save(mall);
        }else{//有id => 修改商城信息
            mallService.update(mall);
        }
        return "redirect:/mall/list"; // 完成操作后重新回到list页面
    }

    // 处理删除商城请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据商城id删除商城数据
            mallService.delete(id);
        }
        return "redirect:/mall/list"; // 完成操作后重新回到list页面
    }
}

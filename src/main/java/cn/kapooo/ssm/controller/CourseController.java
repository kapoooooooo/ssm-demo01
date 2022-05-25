package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.Course;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.ICourseService;
import cn.kapooo.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    // 处理查询所有课程请求
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //查询全部课程数据
        List<Course> courseList = courseService.selectAll();
        mv.addObject("courseList", courseList);
        mv.setViewName("course/list");
        return mv; // 找视图 /WEB-INF/views/course/list.jsp
    }

    // 判断添加/修改课程请求
    @RequestMapping("/input")
    public String input(Long id, Model model){
        if (id != null) { // 有id => 修改课程
            //根据学生id查询学生数据
            Course course = courseService.selectByCourseId(id);
            //设置到作用域中
            model.addAttribute("course", course);
        }
        return "/course/input"; //完成操作后重新回到list页面
    }

    //处理保存/修改课程的请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Course course){
        if (course.getId() == null){//无id => 添加课程信息
            //保存课程信息
            courseService.save(course);
        }else{//有id => 修改课程信息
            //修改课程信息
            courseService.update(course);
        }
        return "redirect:/course/list"; //完成操作后重新回到list页面
    }

    // 处理删除课程请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据课程id删除课程信息
            courseService.delete(id);
            //根据课程id删除学生与课程的关系表
            courseService.deleteRelationByCourseId(id);
        }
        return "redirect:/course/list"; //完成操作后重新回到list页面求
    }
}

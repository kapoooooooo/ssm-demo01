package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.*;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.ICourseService;
import cn.kapooo.ssm.service.IStudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    // 处理查询所有学生请求
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        //查询全部学生数据
        List<Student> studentList = studentService.selectAll();
        mv.addObject("studentList", studentList);
        mv.setViewName("student/list");
        return mv; // 找视图 /WEB-INF/views/student/list.jsp
    }
    // 处理查询选了某个课程的学生请求
    @RequestMapping("/xklist")
    public ModelAndView xklist(Long id){
        ModelAndView mv = new ModelAndView();
        //根据课程id查询选了课程的学生信息
        List<Student> studentList = studentService.selectAllByCourseId(id);
        mv.addObject("studentList", studentList);
        mv.setViewName("student/list");
        return mv; // 找视图 /WEB-INF/views/student/list.jsp
    }

    // 判断添加/修改学生请求
    @RequestMapping("/input")
    public String input(Long id, Model model){
        //查询所有课程信息
        List<Course> courseList = courseService.selectAll();

        // 设置到作用域中，让学生添加/修改时显示出来以供用户选择
        model.addAttribute("courseList",courseList);
        if (id != null) { // 有id => 修改学生
            //根据学生id查询学生数据
            Student student = studentService.selectByStudentId(id);
            //根据学生id查学生已选课程数据
            List<Course> ownCourseList = courseService.selectAllByStudentId(id);
            //设置到作用域中
            model.addAttribute("ownCourseList",ownCourseList);
            model.addAttribute("student", student);
        }
        return "student/input"; //完成操作后重新回到list页面
    }

    //处理保存/修改学生的请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Student student,Long[] courseIds){
        if (student.getId() == null){//无id => 添加学生信息
            //保存学生信息
            studentService.save(student);
            //保存学生选课信息
            studentService.saveRelation(student.getId(), courseIds);
        }else{//有id => 修改学生信息
            //修改学生信息
            studentService.update(student);
            //删除学生已选课程
            studentService.deleteRelationByStudentId(student.getId());
            //添加学生新选课程
            studentService.saveRelation(student.getId(), courseIds);
        }
        return "redirect:/student/list"; //完成操作后重新回到list页面
    }

    // 处理删除员工请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据学生id删除学生数据
            studentService.delete(id);
            //根据学生id删除学生已选课程
            studentService.deleteRelationByStudentId(id);
        }
        return "redirect:/student/list"; //完成操作后重新回到list页面求
    }
}

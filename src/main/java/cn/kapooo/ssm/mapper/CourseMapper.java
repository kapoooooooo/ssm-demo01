package cn.kapooo.ssm.mapper;

import cn.kapooo.ssm.domain.Course;
import cn.kapooo.ssm.domain.Student;

import java.util.List;

public interface CourseMapper {
    /**
     * 添加课程
     */
    void save(Course course);

    /**
     * 修改课程信息
     */
    void update(Course course);

    /**
     * 根据课程id查询课程数据
     */
    Course selectByCourseId(Long id);

    /**
     * 根据课程id删除课程信息
     */
    void delete(Long id);

    /**
     * 根据课程id删除学生与课程的关系
     */
    void deleteRelationByCourseId(Long id);

    /**
     * 查询课程信息
     */
    List<Course> selectAll();

    /**
     * 根据学生id查询已选的课程
     */
    List<Course> selectAllByStudentId(Long id);

    /**
     * 根据学生id查询分数前三的课程
     */
    List<Course> selectCourseListByStudentId(Long id);

}

package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Course;
import cn.kapooo.ssm.mapper.CourseMapper;
import cn.kapooo.ssm.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void save(Course course) {
        courseMapper.save(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }

    @Override
    public Course selectByCourseId(Long id) {
        return courseMapper.selectByCourseId(id);
    }

    @Override
    public void delete(Long id) {
        courseMapper.delete(id);
    }

    @Override
    public void deleteRelationByCourseId(Long id) {
        courseMapper.deleteRelationByCourseId(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public List<Course> selectAllByStudentId(Long id) {
        return courseMapper.selectAllByStudentId(id);
    }

    @Override
    public List<Course> selectCourseListByStudentId(Long id) {
        return courseMapper.selectCourseListByStudentId(id);
    }
}

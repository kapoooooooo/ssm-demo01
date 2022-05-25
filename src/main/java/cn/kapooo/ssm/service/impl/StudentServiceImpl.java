package cn.kapooo.ssm.service.impl;

import cn.kapooo.ssm.domain.Student;
import cn.kapooo.ssm.mapper.StudentMapper;
import cn.kapooo.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void saveRelation(Long studentId, Long[] courseIds) {
        if(courseIds != null && courseIds.length > 0){// 课程列表不为空 则执行保存关系sql
            studentMapper.saveRelation(studentId, courseIds);
        }
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public Student selectByStudentId(Long id) {
        return studentMapper.selectByStudentId(id);
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }

    @Override
    public void deleteRelationByStudentId(Long id) {
        studentMapper.deleteRelationByStudentId(id);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> selectAllByCourseId(Long id) {
        return studentMapper.selectAllByCourseId(id);
    }

    @Override
    public Long selectCountByCourseId(Long id) {
        return studentMapper.selectCountByCourseId(id);
    }
}

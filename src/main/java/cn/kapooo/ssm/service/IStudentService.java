package cn.kapooo.ssm.service;

import cn.kapooo.ssm.domain.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 保存学生
     */
    void save(Student student);

    /**
     * 保存学生和课程关系
     */
    void saveRelation(Long studentId, Long[] courseIds);

    /**
     * 修改学生信息
     */
    void update(Student student);

    /**
     * 根据学生id查询学生数据
     */
    Student selectByStudentId(Long id);

    /**
     * 根据学生id删除学生信息
     */
    void delete(Long id);

    /**
     * 根据学生id删除学生与课程的关系
     */
    void deleteRelationByStudentId(Long id);

    /**
     * 查询学生信息
     */
    List<Student> selectAll();

    /**
     * 根据课程id查询对应的学生信息
     */
    List<Student> selectAllByCourseId(Long id);

    /**
     * 根据课程id查询对应的学生数量
     */
    Long selectCountByCourseId(Long id);
}

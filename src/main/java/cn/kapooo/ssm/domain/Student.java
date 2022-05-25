package cn.kapooo.ssm.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student { //学生
    private Long id;
    private String name;
    private Integer age;
    private String email;

    private List<Course> courseList;
}

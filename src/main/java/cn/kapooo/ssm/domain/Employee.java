package cn.kapooo.ssm.domain;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {// 员工
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String email;
    private boolean admin;
    private Integer testNum;
    // 关联属性, 不仅可以封装部门 id 可以封装部门名称
    private Department department;

}

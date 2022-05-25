package cn.kapooo.ssm.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {// 部门
    private Long id;
    private String name;
    private String sn;
}

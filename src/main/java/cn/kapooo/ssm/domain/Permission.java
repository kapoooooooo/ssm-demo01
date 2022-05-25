package cn.kapooo.ssm.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Permission {// 权限
    private Long id;
    private String name;
    private String expression;

}

package cn.kapooo.ssm.domain;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {// 角色
    private Long id;
    private String name;
    private String sn;
}

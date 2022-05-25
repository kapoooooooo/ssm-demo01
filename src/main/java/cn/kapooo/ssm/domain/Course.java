package cn.kapooo.ssm.domain;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course { // 课程
    private Long id;
    private String name;
    private String author;
    private Integer score;
    private Long studentNum;
}

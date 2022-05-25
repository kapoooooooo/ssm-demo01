package cn.kapooo.ssm.domain;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {// 库存
    private Long id;
    private String address;
    private String tel;
    private Integer status;
    private Integer num;
    //关联
    private Goods goods;

}

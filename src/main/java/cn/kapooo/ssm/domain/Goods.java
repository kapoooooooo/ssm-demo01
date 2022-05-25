package cn.kapooo.ssm.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goods {// 商品
    private Long id;
    private String name;
    private String sn;
    private Integer status;
    private Integer num;
    //关联
    private Shop shop;

}

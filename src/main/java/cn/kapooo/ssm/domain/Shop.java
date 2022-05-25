package cn.kapooo.ssm.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Shop {// 商店
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sn;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer shopGoodsNum;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //关联
    private Mall mall;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Employee employee;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Goods goods;
}

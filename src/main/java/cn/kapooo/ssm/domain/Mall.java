package cn.kapooo.ssm.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Mall {// 商城
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sn;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer mallGoodsNum;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Goods> goodsList;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Shop> shopList;
}

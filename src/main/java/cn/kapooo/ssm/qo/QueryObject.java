package cn.kapooo.ssm.qo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//分页参数类
public class QueryObject {
    //当前页
    private Integer currentPage = 1;
    //每页条数
    private Integer pageSize = 8;

    //获取select * from xxx limit ?, ?的起始位置
    public Integer getStart(){
        return (currentPage -1) * pageSize;
    }
}

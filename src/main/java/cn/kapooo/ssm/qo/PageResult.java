package cn.kapooo.ssm.qo;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//查询结果类
public class PageResult<T> {

    private Integer currentPage; // 页面传的当前页
    private Integer pageSize; // 页面传的页数

    private Integer totalCount; // 数据库查询 数据条数
    private List<T> data; // 数据库查询 分页数据


    private Integer totalPage; // 总页数
    private Integer prevPage; // 上一页
    private Integer nextPage; // 下一页


    public PageResult(Integer currentPage, Integer pageSize,  Integer totalCount, List<T> data) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.data = data;

        // 其他是计算出来的
        if(totalCount <= pageSize) {
            this.totalPage = 1;
            this.prevPage = 1;
            this.nextPage = 1;
            return;
        }
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        this.prevPage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1 : this.totalPage;
    }

}

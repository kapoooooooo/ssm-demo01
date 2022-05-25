<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商城管理</title>
    <%@include file="/WEB-INF/views/common/link.jsp"%>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/navbar.jsp"%>
    <!--菜单回显-->
    <c:set var="currentMenu" value="mall"/>
    <%@include file="/WEB-INF/views/common/menu.jsp"%>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>库存管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 10px;">
                    <!--高级查询--->
                    <form class="form-inline" id="searchForm" action="/warehouse/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <a href="/warehouse/input" class="btn btn-success btn_redirect"><span class="glyphicon glyphicon-plus"></span> 添加</a>
                    </form>

                    <table class="table table-striped table-hover" >
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>地址</th>
                            <th>电话</th>
                            <th>商品</th>
                            <th>数量</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <c:forEach items="${warehouses}" var="warehouse" varStatus="vs">
                           <tr>
                               <td>${vs.count}</td>
                               <td>${warehouse.address}</td>
                               <td>${warehouse.tel}</td>
                               <th>${warehouse.goods.name}</th>
                               <th>${warehouse.num}</th>

                               <td>
                                   <a href="/warehouse/input?id=${warehouse.id}" class="btn btn-info btn-xs btn_redirect">
                                       <span class="glyphicon glyphicon-pencil"></span> 编辑
                                   </a>
                                   <a href="/warehouse/delete?id=${warehouse.id}" class="btn btn-danger btn-xs btn_delete" >
                                       <span class="glyphicon glyphicon-trash"></span> 删除
                                   </a>
                               </td>
                           </tr>
                        </c:forEach>
                    </table>
                    <!--分页-->
                    <%@include file="../common/page.jsp"%>
                </div>
            </div>
        </section>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp"%>
</div>
</body>
</html>

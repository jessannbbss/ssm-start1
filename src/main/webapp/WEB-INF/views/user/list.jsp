<%--
  Created by IntelliJ IDEA.
  User: jessann
  Date: 2018/2/26
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    function go(index) {
        if(index>0){
           $("#currentPage").val(index) ;
           $("form").submit();
        }
    }
    $(function () {
        $("#sousuo").click(function () {
            $("#currentPage").val(1);
            $("form").submit();
        })
        
    })
    <c:if test="${msg!=null}">
        alert("${msg}");
    </c:if>
</script>

<body>
<form action="/user/list" method="post">
    <div style="width: 80% ;margin:0  auto">
        <div>
            <label>用户名：<input type="text" name="userName" value="${u.userName}"></label>
            <input type="button" value="搜索" id="sousuo">
            <input type="button" value="新增" onclick="location.href='/user/add'">
            <input type="hidden" name="currentPage" value="${page.currentPage}" id="currentPage">
        </div>
        <table cellspacing="0" cellpadding="0" border="1"style="width: 100%">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${page.list}" var="list" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${list.userName}</td>
                    <td>${list.userPsw}</td>
                    <td>
                        <a href="/user/update?userId=${list.userId}">修改</a>
                        <a href="/user/delete?userId=${list.userId}">删除</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</form>
<div align="center">
    <a href="javascript:go(1)">首页</a>
    <c:if test="${page.currentPage<=1}">
        <a href="javascript:void(0)" style="color: #cccccc">上一页</a>
    </c:if>
    <c:if test="${page.currentPage>1}">
        <a href="javascript:go(${page.currentPage-1})">上一页</a>
    </c:if>
   [ ${page.currentPage}/${page.pageTotal}]
    <c:if test="${page.currentPage>=page.pageTotal}">
        <a href="javascript:void(0)" style="color: #cccccc">下一页</a>
    </c:if>
    <c:if test="${page.currentPage<page.pageTotal}">
        <a href="javascript:go(${page.currentPage+1})">下一页</a>
    </c:if>
    <a href="javascript:go(${page.pageTotal})">末页</a>
</div>
</body>
</html>

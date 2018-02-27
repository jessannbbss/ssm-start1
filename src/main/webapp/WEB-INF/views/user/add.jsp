<%--
  Created by IntelliJ IDEA.
  User: jessann
  Date: 2018/2/26
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/add" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" value="${user.userName}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="userPsw" value="${user.userPsw}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存"></td>
        </tr>
    </table>
</form>
</body>
</html>

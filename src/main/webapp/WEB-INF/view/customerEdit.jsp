<%--
  Created by IntelliJ IDEA.
  User: yuezhang
  Date: 17/10/28
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>新增客户</title>
</head>
<body>
    <form action="${BASE}/customer_create" method="post">
        name: <input type="text" name="name" value="yue" /><br />
        contact: <input type="text" name="contact" value="zhangyue" /><br />
        telephone: <input type="text" name="telephone" value="13918648199" /><br />
        email: <input type="text" name="email" value="ben1247@163.com" /><br />
        <input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" value="返回" onclick="window.location.href='${BASE}/customer'" />
    </form>
</body>
</html>

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
    <%--<form action="${BASE}/customer_create" method="post" enctype="multipart/form-data">--%>
        <%--name: <input type="text" name="name" value="yue" /><br />--%>
        <%--contact: <input type="text" name="contact" value="zhangyue" /><br />--%>
        <%--telephone: <input type="text" name="telephone" value="13918648199" /><br />--%>
        <%--email: <input type="text" name="email" value="ben1247@163.com" /><br />--%>
        <%--<input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;--%>
        <%--<input type="button" value="返回" onclick="window.location.href='${BASE}/customer'" />--%>
    <%--</form>--%>
    <form id="customer_form" enctype="multipart/form-data">
        <table>
            <tr>
                <td>客户名称：</td>
                <td>
                    <input type="text" name="name" value="${customer.name}">
                </td>
            </tr>
            <tr>
                <td>联系人：</td>
                <td>
                    <input type="text" name="contact" value="${customer.contact}">
                </td>
            </tr>
            <tr>
                <td>电话号码：</td>
                <td>
                    <input type="text" name="telephone" value="${customer.telephone}">
                </td>
            </tr>
            <tr>
                <td>邮箱地址：</td>
                <td>
                    <input type="text" name="email" value="${customer.email}">
                </td>
            </tr>
            <tr>
                <td>照片：</td>
                <td>
                    <input type="file" name="photo" value="${customer.photo}">
                </td>
            </tr>
        </table>
        <button type="submit">保存</button>
    </form>

    <script src="${BASE}/asset/lib/jquery/jquery.min.js"></script>
    <script src="${BASE}/asset/lib/jquery-form/jquery.form.min.js"></script>
    <script>
        $(function () {
            $('#customer_form').ajaxForm({
                type : 'post',
                url: '${BASE}/customer_create',
                success: function (data) {
                    if(data){
                        location.href = '${BASE}/customer';
                    }
                }
            });
        });
    </script>
</body>
</html>

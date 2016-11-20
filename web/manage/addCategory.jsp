<%--
  Created by IntelliJ IDEA.
  User: wshh08
  Date: 16-11-20
  Time: 下午7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--静态包含，在服务器端编译JSP时处理，所以绝对路径'/'相当于应用根目录--%>
<%@include file="/manage/header.jsp"%>
<form action="${pageContext.request.contextPath}/servlet/ControllerServlet?op=addCategory" method="post">
    <table>
        <tr>
            <td>分类名称*</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>分类描述</td>
            <td>
                <textarea rows="3" cols="38" name="description"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="保存">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
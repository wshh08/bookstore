<%--
  Created by IntelliJ IDEA.
  User: wshh08
  Date: 16-11-20
  Time: 下午7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--静态包含，在服务器端编译JSP时处理，所以绝对路径'/'相当于应用根目录--%>
<%@include file="/manage/header.jsp" %>
<br/>
<table border="1" width="438">
    <tr>
        <th>选择</th>
        <th>序号</th>
        <th>类别名称</th>
        <th>类别描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="vs">
        <tr class="${vs.count%2==0?'odd':'even'}">
            <td>
                <input type="checkbox" name="categoryId" value="${c.id}">
            </td>
            <td>${vs.count}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>
                [<a href="">修改</a>]
                [<a href="">删除</a>]
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>View All Posts</title>
        <%--
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
        --%>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Body</th>
                    <th>Posted On</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.getTitle()}</td>
                        <td>${post.getBody()}</td>
                        <td>${post.getDateCreated()}</td>
                        <td><a href="javascript:void(0);">Edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <a href="/logout">Logout</a>
        </div>
    </body>
</html>
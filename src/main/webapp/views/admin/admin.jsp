<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

<table>
    <tr>
        <th>Order Id</th>
        <th>Order Price</th>
        <th></th>
    </tr>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.id}</td>
            <td>${order.price}</td>
            <td>
                <button type="button" name="completeButton">Completed</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Thank you for your purchase

    <form method="get" action="<c:url value='/coffeeList'/>">
        <button type="submit">Proceed to order</button>
    </form>
</body>
</html>

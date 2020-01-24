<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    <%@ include file="../css/coffeelist.css"%>
</style>

<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous">
</script>

<script type="application/javascript">
    <%@ include file="../js/order.js"%>
</script>

<html>
<head>
    <title>Coffee List</title>
</head>
<body>

<form action="<c:url value="/order"/>" method="get">
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th></th>
            <th>TotalQuantity</th>
            <th>TotalPrice</th>
        </tr>

        <c:forEach var="coffee" items="${coffeeList}">
            <tr>
                <td><input readonly type="text" name="coffeeName" value="${coffee.name}"></td>
                <td><input readonly type="text" name="coffeeDescription" value="${coffee.description}"></td>
                <td><input readonly type="text" name="coffeePrice" value="${coffee.price}"></td>
                <td><input type="number" value="0"></td>
                <td>
                    <button type="button" name="addButton">Add</button>
                </td>
                <td><input readonly type="text" name="totalQuantity" value="0"></td>
                <td><input readonly value="0" name="totalPrice"/></td>
                <input type="hidden" name="coffeeId" value="${coffee.id}">
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" class="centered">
                <div>
                    <button type="submit">Confirm Order</button>
                </div>
            </td>
        </tr>

    </table>

</form>

</body>
</html>

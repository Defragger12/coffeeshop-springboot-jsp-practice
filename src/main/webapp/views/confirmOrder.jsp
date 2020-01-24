<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@ include file="../css/confirmorder.css"%>
</style>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="<c:url value="/order"/>" method="post">

    <div style="margin-top: 2%;">
        <input type="text" name="customer_name" placeholder="Your Name">
        <input type="text" name="customer_phone" placeholder="Phone">
        <input type="text" name="customer_address" placeholder="Address">
    </div>

    <table style="margin-top: 2%;">

        <caption>Order Info</caption>

        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>

        <c:forEach var="item" items="${coffeeList}">
            <tr>
                <td>${item.coffeeName}</td>
                <td>${item.coffeeDescription}</td>
                <td>${item.coffeePrice}</td>
                <td>${item.totalQuantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" class="centered top-padded" class="top-padded">
                Final Price: ${finalPrice}
            </td>
        </tr>
        <tr>
            <td colspan="4" class="centered" >
                <button type="submit">Finish Order</button>
            </td>
        </tr>
    </table>


</form>

</body>
</html>

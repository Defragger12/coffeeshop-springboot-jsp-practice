$(document).ready(function () {
    $("button[name='addButton']").click(
        function () {
            let selectedQuantity = +$(this).parent().prev().find('input').val();
            let oldTotalQuantity = +$(this).parent().next().find('input').val();
            let price = +$(this).parent().prev().prev().find('input').val();
            let totalQuantity = oldTotalQuantity + selectedQuantity;
            let totalPrice = totalQuantity * price;

            $(this).parent().next().find('input').val(totalQuantity);
            $(this).parent().next().next().find('input').val(totalPrice);
        })
});
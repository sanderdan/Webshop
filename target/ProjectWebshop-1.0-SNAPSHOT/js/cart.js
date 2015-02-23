// CLEAR CART
window.onload = function () {
    $('#clear-button').click(function () {
        $.ajax({
            type: "GET",
            url: "cart/clear",
            dataType: "json",
            contentType: "application/json",
            success: clearCart
        });
    });
    $('.sub-button').click(function () {
        var id = $(this).parent().attr("id");
        $.ajax({
            type: "GET",
            url: "cart/remove",
            dataType: "json",
            contentType: "application/json",
            data: {"productID": id},
            success: removedFromCart
        });
    });
};
function clearCart() {
    console.log("Cart was cleared!");
    window.location.reload();
}
// REMOVE ITEM
function removedFromCart(response) {
    $('#counter').html(response.itemsInCart);
    window.location.reload();
}
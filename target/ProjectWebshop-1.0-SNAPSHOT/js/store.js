// FILTER
$('#skateboards').prop('checked', true);
$('#wheels').prop('checked', true);
$('input[type="checkbox"]').click(function () {
    if ($(this).attr("value") === "skateboards") {
        $("#deckGrid").toggle();
    }
    if ($(this).attr("value") === "wheels") {
        $("#wheelGrid").toggle();
    }
});
//  CART COUNTER
$('.buy-button').click(function () {
    var id = $(this).parent().attr("id");
    $.ajax({
        type: "GET",
        url: "cart/add",
        dataType: "json",
        contentType: "application/json",
        async: false,
        data: {"productID": id},
        success: addedToCart
    });
});
function addedToCart(response) {
    $('#counter').html(response.itemsInCart);
    console.log(response);
}
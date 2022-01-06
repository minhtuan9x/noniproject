<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 03/01/2022
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li><a href="/product/list">Sản Phẩm</a></li>
                <li id="liL">Chi Tiết Sản Phẩm</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5">
            <img style="width: 100%;height: 450px" src="${product.imgTitle}">
        </div>
        <div class="col-md-7">
            <h1>[${product.mass}]${product.name}</h1>
            <hr>
            <h5>${product.priceStr}đ</h5>
            <div class="row">
                <div class="col-md-3">
                    <div class="input-group">
                        <span class="input-group-btn">
                            <button type="button" class="quantity-left-minus btn btn-danger btn-number"
                                    data-type="minus" data-field="">
                                <i class="fa fa-minus"></i>
                            </button>
                        </span>
                        <input type="text" id="quantity" name="quantity" class="form-control input-number"
                               min="1" max="100">
                        <span class="input-group-btn">
                            <button type="button" class="quantity-right-plus btn btn-success btn-number"
                                    data-type="plus" data-field="">
                                <i class="fa fa-plus"></i>
                            </button>
                        </span>
                    </div>
                </div>
                <div class="col-md-9">
                    <button type="button" class="btn btn-danger" id="addCart" value="${product.id}">Thêm vào giỏ hàng
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#quantity').val("1")
    let quantity123 = parseInt($('#quantity').val());
    $('.quantity-right-plus').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('#quantity').val());
        // If is not undefined
        $('#quantity').val(quantity + 1);
        quantity123 = parseInt($('#quantity').val());
        // Increment

    });

    $('.quantity-left-minus').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('#quantity').val());

        // If is not undefined

        // Increment
        if (quantity > 0) {
            $('#quantity').val(quantity - 1);
        }

        quantity123 = parseInt($('#quantity').val());
    });

    let cart = {};

    $("#addCart").click(function () {
        if (JSON.parse(localStorage.getItem("myCart")) != null){
            cart = JSON.parse(localStorage.getItem("myCart"));
        }
        let cartRS = JSON.parse(localStorage.getItem("myCart"));
        for (let x in cartRS) {
            if(x==$(this).val()){
                alert("Sản Phẩm Này Đã Có Trong Giỏ Hàng !!!")
                return;
            }
        }
        cart[$(this).val()] = quantity123;
        localStorage.setItem("myCart", JSON.stringify(cart))
        alert("Đã Thêm Sản Phẩm Vào Giỏ Hàng!!!")
        window.location.reload()
    })

</script>
</body>
</html>

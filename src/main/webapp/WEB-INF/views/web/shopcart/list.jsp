<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 03/01/2022
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Giỏ Hàng</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9">
            <table class="table">
                <thead>
                <tr>
                    <th><button type="button" class="btn btn-default" onclick="removeAllItem()"> <i class="fa fa-trash" aria-hidden="true"></i></button></th>
                    <th>SẢN PHẨM</th>
                    <th>GIÁ</th>
                    <th>SỐ LƯỢNG</th>
                    <th>TẠM TÍNH</th>
                </tr>
                </thead>
                <tbody id="bd">

                </tbody>
            </table>
        </div>
        <div class="col-md-3">
            <h5>CỘNG GIỎ HÀNG</h5>
            <hr>
            <p><i>* Tổng tiền bao gồm phí ship, khi bạn đặt hàng sẽ có nhân viên liên hệ để xác nhận</i></p>
            <p id="tamtinh"></p>
            <div class="row">
                <div class="col-md-12">
                    <button type="button" id="dathang" class="btn btn-danger" onclick="window.location.href='/order'">ĐẶT HÀNG</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    let cart = JSON.parse(localStorage.getItem("myCart"));
    $("#bd").empty()
    let content = '';
    let priceTotal=0 ;
    let a = "Không có sản phẩm nào trong giỏ hàng hết !!!"
    for (let key in cart) {
        a = ""
        let id = key; //B
        let quantity = cart[key];	 //15
        let imgTitle = "";
        let title = "";
        $.ajax({
            url: "/api/product/" + id,
            type: "get",
            datatype: "json",
            success: function (res) {
                imgTitle = "<img src=res.imgTitle>";
                title = res.name;
                priceStr123 = res.priceStr;
                price123 = res.price;
                priceTotal+=parseInt(price123);
                content = '<tr>' +
                    '<td><button type="button" class="btn btn-default" onclick="removeItem('+id+')"> <i class="fa fa-times" aria-hidden="true"></i></button></td>' +
                    '<td style="color:red;"> ' +''+
                    '<img src="'+res.imgTitle+'">&nbsp&nbsp['+res.mass+']'+ title + '</td>' +
                    '<td >' + priceStr123 + ' VND</td>' +
                    '<td>x' + quantity + '<button onclick="cong('+id+','+quantity+')" class="btn btn-default">+</button><button onclick="tru('+id+','+quantity+')" class="btn btn-default">-</button></td>' +
                    '<td>' + (price123*quantity).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}) + '</td>' +
                    '</tr>';
                $("#bd").append(content)
                $("#tamtinh").empty()
                // $("#tong").empty()
                $("#tamtinh").append("<b>Tổng Tạm Tính:</b>"+priceTotal.toLocaleString('it-IT', {style : 'currency', currency : 'VND'}))
                // $("#tong").append("Tổng Cộng: "+priceTotal.toLocaleString('it-IT', {style : 'currency', currency : 'VND'}))
            },
            error: function () {
                alert("error")
            }
        })
    }
    $("#bd").append(a)
    if(a!="")
        $("#dathang").prop('disabled', true);
    function removeItem(value123){
        delete cart[value123]
        localStorage.setItem("myCart", JSON.stringify(cart))
        window.location.reload()
    }

    function cong(id,quantity){
        let cartCong = JSON.parse(localStorage.getItem("myCart"));
        cartCong[id]=quantity+1
        localStorage.setItem("myCart", JSON.stringify(cartCong))
        window.location.reload()
    }
    function tru(id,quantity){
        let cartTru = JSON.parse(localStorage.getItem("myCart"));
        cartTru[id]=quantity-1
        localStorage.setItem("myCart", JSON.stringify(cartTru))
        window.location.reload()
    }
    function removeAllItem(){
        localStorage.clear()
        window.location.reload()
    }
</script>
<style>
    img{
        width: 50px;
        height: 50px;
    }
</style>
</body>
</html>

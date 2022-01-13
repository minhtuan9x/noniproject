<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 03/01/2022
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <script src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Order</li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8">
            <div class="row" id="head1">
                <div class="col-md-12">
                    <p>LƯU Ý: Vui lòng cung cấp đúng địa chỉ Email và Số điện thoại, để bên mình có thể liên lạc xác
                        nhận đặt
                        hàng được với quý khách ạ!!!</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <br>
                    <br>
                    <form:form commandName="contactDTO" id="formDatHang">
                        <div class="form-group">
                            <label><b>Họ và Tên*: </b></label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="form-group">
                            <label><b>Số Điện Thoại*: </b></label>
                            <input type="number" class="form-control" name="phone">
                        </div>
                        <div class="form-group">
                            <label><b>Email: </b></label>
                            <input type="text" class="form-control" name="email">
                        </div>
                        <div class="form-group">
                            <label><b>Địa Chỉ*: </b></label>
                            <input type="text" class="form-control" name="address">
                        </div>
                        <div class="form-group">
                            <div class="g-recaptcha"
                                 data-sitekey="6LfSpv4dAAAAAO22QDkStgI2uCRNosPVPyAFHEeJ">
                            </div>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-md-4" id="bill">
            <div class="row">
                <div class="col-md-12">
                    <h5>Đơn Hàng Của Bạn</h5>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>SẢN PHẨM</th>
                            <th>TẠM TÍNH</th>
                        </tr>
                        </thead>
                        <tbody id="bd">

                        </tbody>
                        <tbody>

                        </tbody>
                    </table>
                    <hr>
                    <p id="tamtinh"></p>
                    <p><i>* Tổng tiền bao gồm phí ship, khi bạn đặt hàng sẽ có nhân viên liên hệ để xác nhận</i></p>
                    <%--                    <p id="tong"></p>--%>
                    <hr>
                    <b>Phương thức thanh toán mặc định: </b>Thanh toán khi nhận hàng
                    <br>
                    <br>
                    <br>
                    <button type="button" class="btn btn-danger btn-block" id="xndathang">Xác Nhận Đặt Hàng</button>
                </div>
            </div>
        </div>
    </div>

</div>
<style>
    #head1 {
        border: 1px dotted red;
        background-color: rgba(174, 146, 50, 0.19);
    }

    #bill {
        border: 1px solid black;
        padding: 10px 10px;
    }
</style>

<script>
    let cart = JSON.parse(localStorage.getItem("myCart"));
    $("#bd").empty()
    let content = '';
    let priceTotal = 0;
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
                priceTotal += parseInt(price123 * quantity);
                content = '<tr>' +
                    '<td >' + '[' + res.mass + ']' + title + '<p style="color:red;"> x' + quantity + '</p></td>' +
                    '<td>' + (price123 * quantity).toLocaleString('it-IT', {
                        style: 'currency',
                        currency: 'VND'
                    }) + '</td>' +
                    '</tr>';
                $("#bd").append(content)
                $("#tamtinh").empty()
                // $("#tong").empty()
                $("#tamtinh").append("<b>Tổng Tạm Tính:</b> " + priceTotal.toLocaleString('it-IT', {
                    style: 'currency',
                    currency: 'VND'
                }))
                // $("#tong").append("<b>Tổng Cộng:</b> " + priceTotal.toLocaleString('it-IT', {
                //     style: 'currency',
                //     currency: 'VND'
                // }))
            },
            error: function () {
                alert("error")
            }
        })
    }
    $("#bd").append(a)
    if (a != "")
        $("#dathang").prop('disabled', true);

    $("#xndathang").click(function (e) {
        e.preventDefault()
        let dataForm = $("#formDatHang").serializeArray();
        let data = {};
        let productIds = [];
        dataForm.forEach(item => {
            if (item.name == "g-recaptcha-response")
                data["captchaResponse"] = item.value
            data[item.name] = item.value;
        })
        for (let key in cart) {
            productIds.push({
                "productId": key,
                "quantity": cart[key]
            })
        }
        data["productIdRequests"] = productIds;
        console.log(data);
        if(data.name==""){
            alert("Tên Không Được Để Trống !!!")
        }else{
            if(data.phone==""){
                alert("Số Điện Thoại Không Được Để Trống !!!")
            }else{
                if(data.captchaResponse==""){
                    alert("Xác Minh Tôi Không Phải Là Robot!!!")
                }else {
                    $.ajax({
                        url: "/api/contact",
                        type: "post",
                        data: JSON.stringify(data),
                        datatype: "json",
                        contentType: "application/json",
                        success: function (res) {
                            localStorage.clear()
                            alert("Đặt Hàng Thành Công, Nhân Viên Sẽ Liên Hệ Lại Với Bạn Để Xác Nhận!!!")
                            window.location.href="/trang-chu"
                        },
                        error: function () {
                            alert("fail")
                        }
                    })
                }

            }
        }
    })
</script>
</body>
</html>

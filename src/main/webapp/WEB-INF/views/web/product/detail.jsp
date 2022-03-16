<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 03/01/2022
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
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
            <%--            <img style="width: 100%;height: 450px" src="${product.imgTitle}">--%>
            <div class="row" id="showImg">
                <div class="col-md-12">
                    <img id="expandedImg" style="height:300px;width:100%">
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <c:forEach var="itemImg" items="${product.imgLink}">
                        <div class="column">
                            <img src="${itemImg}" style="width:100%" onclick="myFunction(this);">
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
        <div class="col-md-7">
            <h1>[${product.mass}]${product.name}</h1>
            <hr>
            <h5>${product.priceStr}đ</h5>
            <div class="row">
                <div class="col-md-12">
                    <ul style="list-style-type:circle">
                        <li><b>Tên Sản Phẩm: </b>${product.name}</li>
                        <li><b>Khối Lượng: </b>${product.mass}</li>
                        <li><b>Giá: </b>${product.priceStr} VNĐ</li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="input-group">
                        <span class="input-group-btn">
                            <button type="button" class="quantity-left-minus btn btn-danger btn-number"
                                    data-type="minus" data-field="">
                                <i class="fa fa-minus"></i>
                            </button>
                        </span>
                        <label for="quantity"></label><input type="text" id="quantity" name="quantity"
                                                             class="form-control input-number"
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
                    <button type="button" class="btn btn-danger" id="nowCart" value="${product.id}">Mua Ngay
                    </button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <br>
                        <hr>
                        <h2 style="color: black">Mô Tả Sản Phẩm</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        ${product.description}
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <hr>
    <div class="row">
        <h5 style="color: #0c5460">Phản hồi của khách hàng</h5>
        <div class="col-md-12">
            <ul class="list-group" id="list2">
                <c:forEach items="${product.commentProductDTOS}" var="item">
                    <li class="list-group-item list-group-item-light"><b>Tên Khách Hàng: </b>${item.name}
                        - ${item.createDateStr}</li>
                    <li class="list-group-item list-group-item-light"><b>Bình Luận: </b>${item.main}</li>
                    <c:if test="${item.reply!=null}">
                        <li class="list-group-item list-group-item-text"><b>Phản Hồi Từ Admin: </b>${item.reply}
                        </li>
                    </c:if>
                    <br>
                </c:forEach>
            </ul>
        </div>
    </div>
    <br>
    <hr>
    <div class="row">
        <div class="col-md-12">
            <form id="formfeedback">
                <div class="form-group">
                    <div class="form-row">
                        <h1>Trả lời</h1>
                    </div>
                    <div class="form-row">
                        <label style="color: darkslategray;">Email của bạn sẽ không được hiển thị công khai. Các
                            trường bắt buộc
                            được đánh dấu </label>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12">
                            <label>Bình luận</label>
                            <textarea class="form-control" rows="3" name="main" id="main"></textarea>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <label>Tên*</label>
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <div class="col-md-6">
                            <label>Email*</label>
                            <input type="email" class="form-control" name="email" id="email">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12">
                            <label>Số điện thoại</label>
                            <input type="text" class="form-control" name="phone" id="phone">
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col-md-12">
                            <div class="g-recaptcha"
                                 data-sitekey="6LfSpv4dAAAAAO22QDkStgI2uCRNosPVPyAFHEeJ">
                            </div>
                            <div id="tbf">

                            </div>
                        </div>
                    </div>

                </div>
                <button type="submit" class="btn btn-dark">Phản Hồi</button>
            </form>
        </div>
    </div>
    <br>

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
        if (JSON.parse(localStorage.getItem("myCart")) != null) {
            cart = JSON.parse(localStorage.getItem("myCart"));
        }
        let cartRS = JSON.parse(localStorage.getItem("myCart"));
        for (let x in cartRS) {
            if (x == $(this).val()) {
                alert("Sản Phẩm Này Đã Có Trong Giỏ Hàng !!!")
                return;
            }
        }
        cart[$(this).val()] = quantity123;
        localStorage.setItem("myCart", JSON.stringify(cart))
        alert("Đã Thêm Sản Phẩm Vào Giỏ Hàng!!!")
        window.location.reload()
    })
    $("#nowCart").click(function () {
        cart[$(this).val()] = quantity123;
        localStorage.clear()
        localStorage.setItem("myCart", JSON.stringify(cart))
        window.location.href = "/order"
    })

    $(document).ready(function () {

        $("#formfeedback").submit(function (e) {
            e.preventDefault()
            let dataIn = $("#formfeedback").serializeArray()
            let name = $("#name").val()
            let email = $("#email").val()
            let comment = $("#main").val()
            console.log(dataIn)
            let data = {};
            dataIn.forEach(item => {
                if (item.name == "g-recaptcha-response")
                    data["captchaResponse"] = item.value
                data[item.name] = item.value
            })
            if (name == "" || email == "") {
                alert('Tên và email không được để trống');
            } else {
                if (comment.length <= 10) {
                    alert('Bình luận phải dài hơn 10 kí tự');
                } else {
                    if (data.captchaResponse == "") {
                        $("#tbf").html("<p style='color: red'>Vui lòng xác minh rằng bạn không phải robot</p>")
                    } else {
                        $.ajax({
                            url: "/api/commentproduct/" + "${product.id}" + "/product",
                            type: "post",
                            data: JSON.stringify(data),
                            dataType: "json",
                            contentType: "application/json",
                            success: function (res) {
                                window.location.reload()
                            },
                            error: function () {
                                alert("Thất Bại")
                            }
                        })
                    }
                }
            }
        })
    })
    let expandImg = document.getElementById("expandedImg");
    expandImg.src = "${product.imgTitle}";
    expandImg.parentElement.style.display = "block";
    function myFunction(imgs) {
        expandImg.src = imgs.src;
        expandImg.parentElement.style.display = "block";
    }

</script>
<style>
    .column {
        float: left;
        width: 25%;
        padding: 10px;
    }

    /* Style the images inside the grid */
    .column img {
        opacity: 0.8;
        cursor: pointer;
    }

    /*-------------------*/
    form {
        padding: 25px;
        border-radius: 1%;
    }

    h1 {
        font-family: Monospace;
    }

    .list-group {
        height: 420px;
        width: 100%;
    }

    .list-group {
        overflow: hidden;
        overflow-y: scroll;
    }

    #list2 {
        height: 400px;
        width: 100%;
    }

    #list2 {
        overflow: hidden;
        overflow-y: scroll;
    }
</style>
</body>
</html>

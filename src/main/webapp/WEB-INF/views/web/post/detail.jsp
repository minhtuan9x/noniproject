<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 01/01/2022
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${post.title}</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Chi Tiết Bài Đăng</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8" style="border-right: 1px solid rgba(222,222,221,0.38);">
            <div class="row" style="text-align: center">
                <div class="col-md-12">
                    <h1>${post.title}</h1>
                    <br>
                    <p style="font-size: 90%;color: #5a5a5a">Đăng bởi: ${post.createdBy} - Ngày
                        đăng: ${post.createdDate}</p>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    ${post.content}
                </div>
            </div>
            <br>
            <hr>
            <div class="row">
                <h5 style="color: #0c5460">Phản hồi của khách hàng</h5>
                <div class="col-md-12">
                    <ul class="list-group" id="list2">
                        <c:forEach items="${post.commentPostDTOS}" var="item">
                            <li class="list-group-item list-group-item-light"><b>Tên Khách Hàng: </b>${item.name} - ${item.createdDate}</li>
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
                                    <textarea class="form-control" rows="3" name="main"></textarea>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label>Tên*</label>
                                    <input type="text" class="form-control" name="name">
                                </div>
                                <div class="col-md-6">
                                    <label>Email*</label>
                                    <input type="email" class="form-control" name="email">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-12">
                                    <label>Số điện thoại</label>
                                    <input type="text" class="form-control" name="phone">
                                </div>
                            </div>
                        </div>
                        <!-- <div class="form-group form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox"> Remember me
                            </label>
                        </div> -->

                        <button type="submit" class="btn btn-dark">Phản Hồi</button>
                    </form>
                </div>
            </div>
            <br>
        </div>
        <div class="col-md-4">
            <div class="row">
                <div class="col-md-12">
                    <h5>BÀI VIẾT MỚI</h5>
                    <hr>
                    <c:forEach var="item" items="${postByDates}">
                        <a style="color: darkred" href="/post/${item.id}/detail">${item.title}</a>
                        <p style="font-size: 70%;color: #5a5a5a">Đăng bởi: ${post.createdBy} - Ngày
                            đăng: ${post.createdDate}</p>
                        <hr style="width: 30px">
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>



<style>
    form {
        background-color: #ecf2f9;
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

<script>


    $(document).ready(function () {

        $("#formfeedback").submit(function (e) {
            e.preventDefault()
            var dataIn = $("#formfeedback").serializeArray()
            var name = $("input[name='name']").val()
            var email = $("input[name='email']").val()
            var comment = $("textarea[name='main']").val()
            console.log(dataIn)
            let data = {};
            dataIn.forEach(item => {
                data[item.name] = item.value
            })
            if (name == "" || email == "") {
                alert('Tên và email không được để trống');
            } else {
                if (comment.length <= 10) {
                    alert('Bình luận phải dài hơn 10 kí tự');
                } else {
                    $.ajax({
                        url: "/api/commentpost/" + "${post.id}" + "/post",
                        type: "post",
                        data: JSON.stringify(data),
                        dataType: "json",
                        contentType: "application/json",
                        success: function (res) {
                            window.location.reload();
                        },
                        error: function () {
                            alert("error")
                        }
                    })
                }
            }
        })
    })



</script>

</body>
</html>

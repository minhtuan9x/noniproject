<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 07/01/2022
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href='<c:url value="/admin/home"/> '>Trang chủ</a> /
                    <a href='<c:url value="/admin/contact-list"/> '>Danh sách đơn hàng</a>
                </li>
                <li class="active">Chi tiết đơn hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-4" id="ttkh">
                            <h3>Thông Tin Khách Hàng</h3>
                            <div>
                                <b>Họ và tên : </b>${contact.name}
                            </div>
                            <div>
                                <b>Số điện thoại : </b>${contact.phone}
                            </div>
                            <div>
                                <b>Email : </b>${contact.email}
                            </div>
                            <div>
                                <b>Địa Chỉ : </b>${contact.address}
                            </div>
                            <div>
                                <b>Trạng Thái : </b>${contact.process}
                            </div>
                            <br>
                            <div>
                                <form:form id="formPro">
                                    <select name="status">
                                        <option disabled selected>---Chọn Trạng Thái Đơn Hàng---</option>
                                        <option value="0">Đơn Hàng Mới</option>
                                        <option value="1">Đang Xử Lí</option>
                                        <option value="2">Đã Xử Lí</option>
                                    </select>
                                    <button type="submit" class="btn">Xác Nhận</button>
                                </form:form>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Số Lượng</th>
                                    <th>Tạm Tính (VNĐ)</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${contact.productContactResponses}">
                                    <tr>
                                        <td>${item.productName}</td>
                                        <td>${item.productQuantity}</td>
                                        <td>${item.total}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <b>Tổng tiền: </b>${contact.totalPrice} VNĐ
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<style>
    #ttkh {
        border: 1px solid black;
        padding: 10px 10px;
        font-size: larger;
    }
</style>
<script>
    $(document).ready(function () {
        $("#formPro").submit(function (e){
            e.preventDefault()
            let data = {};
            $(this).serializeArray().forEach(item=>{
                data[item.name]=item.value
            })
            $.ajax({
                url: "<c:url value="/api/contact/${contact.id}"/> ",
                type: "put",
                data:JSON.stringify(data),
                datatype: "json",
                contentType:"application/json",
                success: function () {
                    window.location.reload();
                },
                error: function () {
                    alert("fail")
                }
            })
        })
    })
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 24/12/2021
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
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
                    <a href="<c:url value="/admin/home"/> ">Trang chủ</a>
                </li>
                <li class="active">Danh sách Building</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Tìm sản phẩm</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <form:form commandName="modelSearch" id="listForm" method="get">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <!-- PAGE CONTENT BEGIN -->
                                            <div class="col-md-12">
                                                <label><b>Tên sản phẩm</b></label>
                                                <form:input path="name" cssClass="form-control"/>
                                            </div>
                                            <!-- PAGE CONTENT ENDS -->
                                        </div><!-- /.col -->
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <!-- PAGE CONTENT BEGIN -->
                                            <div class="col-md-6">
                                                <label><b>Giá từ</b></label>
                                                <input type="text" name="priceFrom" class="form-control"
                                                       value="${modelSearch.priceFrom}">
                                            </div>
                                            <div class="col-md-6">
                                                <label><b>Giá đến</b></label>
                                                <input type="text" name="priceTo" class="form-control"
                                                       value="${modelSearch.priceTo}">
                                            </div>
                                            <!-- PAGE CONTENT ENDS -->
                                        </div><!-- /.col -->
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-md-3">
                                            <button class="btn btn-primary" id="btnSearch">Tìm Kiếm</button>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div><!-- /.row -->

                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="pull-right">
                        <button id="xoaBuilding" class="btn btn-white btn-warning btn-bold" data-toggle="tooltip,modal"
                                title="Xoá Toà Nhà" onclick="openModal()">
                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                        </button>
                    </div>

                    <div class="pull-right">
                        <button class="btn btn-white btn-info btn-bold " data-toggle="tooltip"
                                title="Thêm Toà Nhà"
                                onclick="window.location.href='<c:url value="/admin/product-edit"/>'">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                        </button>
                    </div>

                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-xs-12">
                    <table id="simple-table" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" id="selectAll" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Tên Sản Phẩm</th>
                            <th>Giá sản phẩm</th>
                            <th>Thông tin sản phẩm</th>
                            <th>Ảnh đại diện</th>
                            <th>Link Ảnh</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${modelProduct}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkProducts[]" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${item.name}</td>
                                <td>[${item.mass}]${item.priceStr}đ</td>
                                <td>${item.description}</td>
                                <td><img src="${item.imgTitle}"></td>
                                <td>${item.imgLink}</td>
                                <td style="width: 150px">
                                    <button class="btn btn-xs btn-dark" data-toggle="tooltip"
                                            title="Sửa thông tin sản phẩm" value="${item.id}"
                                            onclick="window.location.href='<c:url
                                                    value="/admin/product-edit?id="/>'+${item.id}">
                                        <i class="fa fa-edit" aria-hidden="true"></i>
                                    </button>
                                    <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                            title="Xoá sản phẩm" value="${item.id}" onclick="xoaPro(value)">
                                        <i class="fa fa-remove" aria-hidden="true"></i>
                                    </button>
                                    <button class="btn btn-xs btn-default" data-toggle="tooltip"
                                            title="Xem comment" value="${item.id}" onclick="openModalComment(value)">
                                        <i class="fa fa-comment" aria-hidden="true"></i>
                                    </button>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div>


        </div><!-- /.page-content -->
    </div>

    <!-- Modal Xac Nhan xoa-->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Xác nhận xoá</h4>
                </div>
                <div class="modal-body">
                    <p>Bạn có muốn xoá Building đã chọn ????</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" id="btnXoa" class="btn btn-default" onclick="xoaPro(null)">Xoá</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Comment-->
    <div class="modal fade" id="commentModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Danh sách comment</h4>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" id="selectAll2" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Tên</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Comment</th>
                            <th>Reply</th>
                        </tr>
                        </thead>
                        <tbody id="bdTB">

                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-default" onclick="xoa(null)">Xoá</button>
                </div>
            </div>
        </div>
    </div>


</div><!-- /.main-content -->
<style>

    /* Important part */
    .modal-dialog{
        overflow-y: initial !important
    }
    .modal-body{
        height: 450px;
        overflow-y: auto;
    }
</style>
<script>
    function openModal() {
        $("#myModal").modal()
    }

    let productId = "";

    function openModalComment(value) {
        productId = value;
        $.ajax({
            method: "get",
            url: "<c:url value="/api/product/"/>+" + value,
            datatype: "json",
            success: function (res) {
                let cmts = res.commentProductDTOS;
                $("#bdTB").empty();
                cmts.forEach(item => {
                    let moi = "";
                    if (item.status == 0) {
                        moi = '<p style="color:red;float: left" id="' + item.id + "blm" + '">Bình Luận Mới</p>';
                    }
                    let strCheclCmt = '<td class="center">' +
                        '<label class="pos-rel">' +
                        '<input type="checkbox" class="ace" name="checkCmts[]" value="' + item.id + '">' +
                        '<span class="lbl"></span>' +
                        '</label>' +
                        '</td>';
                    let repIn = ""
                    if (item.reply != null)
                        repIn = item.reply;
                    let str = '<tr>' +
                        strCheclCmt
                        + '<td>' + item.name + '</td>'
                        + '<td>' + item.phone + '</td>'
                        + '<td>' + item.email + '</td>'
                        + '<td>' + item.main + '</td>'
                        + '<td>' + '<input id="' + item.id + "inputRep" + '" type="text" class="form-control" value="' + repIn + '">' +
                        moi + '<button value="' + item.id + '" onclick="xoa(this.value)" style="float: right">Del</button> <button id="' + item.id + '" style="float: right"' +
                        'onclick="reply(this.id)">Rep</button></td>'
                        + '</tr>';
                    $("#bdTB").append(str);
                })
            },
            error: function () {
                alert("loi");
            }
        })
        $("#commentModal").modal()
    }

    function reply(value) {
        let data = {};
        data["id"] = value;
        data["reply"] = $("#" + value + "inputRep").val();
        data["status"] = 1;
        console.log(data)
        $.ajax({
            url: "<c:url value="/api/commentproduct/" />" + productId + "/product",
            method: "post",
            data: JSON.stringify(data),
            datatype: "json",
            contentType: "application/json",
            success: function (res) {
                $("#"+value+"blm").empty()
            },
            error: function () {
                alert("fail")
            }
        })
    }

    function xoa(value) {
        let values = [];
        if (value != null)
            values.push(value);
        $.each($("input[name='checkCmts[]']:checked"), function () {
            values.push($(this).val());
        });
        console.log(values)
        values.forEach(item => {
            $.ajax({
                url: "<c:url value="/api/commentproduct/" />" + item,
                method: "delete",
                datatype: "json",
                success: function (res) {

                },
                error: function () {
                    alert("fail")
                }
            })
        })
        alert("Xoa Thanh Cong")
        window.location.reload()
    }


    $("#selectAll").click(function () {
        $("input[name='checkProducts[]']").prop('checked', $(this).prop('checked'));
    });
    $("#selectAll2").click(function () {
        $("input[name='checkCmts[]']").prop('checked', $(this).prop('checked'));
    });
    $("#selectAll3").click(function () {
        $("input[name='checkContacts[]']").prop('checked', $(this).prop('checked'));
    });
    // let values = [];
    // $.each($("input[name='checkStaffs[]']:checked"), function () {
    //     values.push($(this).val());
    // });


    function xoaPro(value) {
        let values = [];
        if (value != null)
            values.push(value);
        $.each($("input[name='checkProducts[]']:checked"), function () {
            values.push($(this).val());
        });
        console.log(values)
        $.ajax({
            url: "<c:url value="/api/product/" />",
            method: "delete",
            datatype: "json",
            contentType: "application/json",
            data: JSON.stringify(values),
            success: function (res) {
                alert("Xoa Thanh Cong")
                window.location.reload()
            },
            error: function () {
                alert("fail")
            }
        })

    }
</script>
</body>
</html>

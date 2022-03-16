<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 07/01/2022
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Danh sách đơn hàng</title>
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
                <li class="active">Danh sách Đơn Hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Lọc Đơn Hàng</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <form:form id="listForm" method="get">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <!-- PAGE CONTENT BEGIN -->
                                            <div class="col-md-10">
                                                <label><b>Tên Đơn Hàng</b></label>
<%--                                                <form:input path="name" cssClass="form-control"/>--%>
                                                <input name="name" class="form-control" value="${name}">
                                            </div>
                                            <div class="col-md-2">
                                                <label><b>Trạng Thái</b></label>
                                                <select name="status" >
                                                    <option disabled selected>----Chọn trạng thái----</option>
                                                    <option value="0">Đơn Hàng Mới</option>
                                                    <option value="1">Đang Xử Lí</option>
                                                    <option value="2">Đã Xử Lí</option>
                                                </select>
                                            </div><!-- /.col -->
                                        </div><!-- /.col -->
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <!-- PAGE CONTENT BEGIN -->
                                            <div class="col-md-12">
                                                <label><b>Ngày Nhận Đơn</b></label>
                                                <input type="date" name="date" value="${date}" class="form-control">
                                            </div>
                                        </div><!-- /.col -->
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-md-3">
                                            <button class="btn btn-primary" id="btnSearch">Lọc</button>
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
                                title="Xoá Toà Nhà" onclick="openModal(null)">
                            <i class="fa fa-trash-o" aria-hidden="true"></i>
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
                            <th>Ngày Nhận Đơn</th>
                            <th>Họ và tên</th>
                            <th>Số Điện Thoại</th>
                            <th>Trạng Thái</th>
                            <th>Tổng Tiền (VNĐ) </th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${contacts.listResult}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkContacts[]" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${item.createDateStr}</td>
                                <td>${item.name}</td>
                                <td>${item.phone}</td>
                                <td>${item.process}</td>
                                <td>${item.totalPrice}</td>
                                <td style="width: 150px">
                                    <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                            title="Xoá sản phẩm" value="${item.id}" onclick="openModal(value)">
                                        <i class="fa fa-remove" aria-hidden="true"></i>
                                    </button>
                                    <button class="btn btn-xs btn-primary" data-toggle="tooltip"
                                            title="Chi Tiết" onclick="window.location.href='/admin/contact-detail?id=${item.id}'">
                                        <i class="fa fa-inbox" aria-hidden="true"></i>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-md-12">
                    <ul class="pagination justify-content-center" id="pagination"></ul>
                </div>
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
                    <button type="button" id="btnXoa" class="btn btn-default" onclick="xoaPro()">Xoá</button>
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
    if("${contacts.page}"=="")
        $('#pagination').remove()
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            startPage: ${contacts.page},
            totalPages:${contacts.totalPage},
            visiblePages: 5,
            first:'Đầu',
            prev:'<<',
            next:'>>',
            last:'Cuối',
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
            window.location.href="<c:url value="/admin/contact-list?page="/>"+page;
        });
    });
    $("#selectAll").click(function () {
        $("input[name='checkContacts[]']").prop('checked', $(this).prop('checked'));
    });
    let idDelOne=null;
    function openModal(value) {
        idDelOne = value;
        $("#myModal").modal()
    }
    function xoaPro() {
        let values = [];
        if (idDelOne != null)
            values.push(idDelOne);
        $.each($("input[name='checkContacts[]']:checked"), function () {
            values.push($(this).val());
        });
        console.log(values)
        $.ajax({
            url: "<c:url value="/api/contact/" />",
            method: "delete",
            datatype: "json",
            contentType: "application/json",
            data: JSON.stringify(values),
            success: function (res) {
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

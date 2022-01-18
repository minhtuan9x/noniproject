<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 28/12/2021
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách bài viết</title>
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
                <li class="active">Danh sách bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Tìm bài viết</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <form:form commandName="modelSearch" id="listForm"
                                       method="get">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <!-- PAGE CONTENT BEGIN -->
                                            <div class="col-md-12">
                                                <label><b>Tên bài viết</b></label>
                                                <form:input path="title" cssClass="form-control"/>
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
                                title="Xoá Toà Nhà" onclick="openModal(null)">
                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                        </button>
                    </div>
                    <div class="pull-right">
                        <button class="btn btn-white btn-info btn-bold " data-toggle="tooltip"
                                title="Thêm Bài viết"
                                onclick="window.location.href='<c:url value="/admin/post-edit"/>'">
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
                            <th>Title</th>
                            <th>Ảnh Bìa</th>
                            <th>Giới Thiệu</th>
                            <th>Tổng Lượt Xem</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${modelPost.listResult}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkPosts[]" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${item.title}</td>
                                <td><img src="${item.imgTitle}" style="width: 200px;height: 200px"></td>
                                <td>${item.sortContent}</td>
                                <td>${item.totalView}</td>
                                <td style="width: 150px">
                                    <button class="btn btn-xs btn-dark" data-toggle="tooltip"
                                            title="Sửa thông tin sản phẩm" value="${item.id}"
                                            onclick="window.location.href='<c:url
                                                    value="/admin/post-edit?id="/>'+${item.id}">
                                        <i class="fa fa-edit" aria-hidden="true"></i>
                                    </button>
                                    <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                            title="Xoá sản phẩm" value="${item.id}" onclick="openModal(value)">
                                        <i class="fa fa-remove" aria-hidden="true"></i>
                                    </button>
                                    <button class="btn btn-xs btn-default" data-toggle="tooltip"
                                            title="Xem comment" value="${item.id}" onclick="openModalComment(value)">
                                        <i class="fa fa-comment" aria-hidden="true"></i></i><span class="badge badge-danger">${item.totalNewComment}</span>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="pagination justify-content-center" id="pagination"></ul>
                </div>
            </div>

        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
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
                <p>Bạn có muốn xoá các bài viết đã chọn ????</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" id="btnXoa" class="btn btn-default" onclick="xoaPost()">Xoá</button>
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
    let idOne = null;

    function openModal(value) {
        idOne = value;
        $("#myModal").modal()
    }

    $("#selectAll").click(function () {
        $("input[name='checkPosts[]']").prop('checked', $(this).prop('checked'));
    });
    $("#selectAll2").click(function () {
        $("input[name='checkCmts[]']").prop('checked', $(this).prop('checked'));
    });


    function xoaPost() {
        let values = [];
        if (idOne != null)
            values.push(idOne);
        $.each($("input[name='checkPosts[]']:checked"), function () {
            values.push($(this).val());
        });
        console.log(values)
        $.ajax({
            url: "<c:url value="/api/post" />",
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

    let postId;

    function openModalComment(value) {
        postId = value;
        $.ajax({
            method: "get",
            url: "<c:url value="/api/post/"/>+" + value,
            datatype: "json",
            success: function (res) {
                let cmts = res.commentPostDTOS;
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
                        + '<td style="width: 100px">' + item.name + '</td>'
                        + '<td style="width: 100px"> ' + item.phone + '</td>'
                        + '<td style="width: 100px">' + item.email + '</td>'
                        + '<td style="width: 200px">' + item.main + '</td>'
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
            url: "<c:url value="/api/commentpost/" />" + postId + "/post",
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
        $.ajax({
            url: "<c:url value="/api/commentpost/" />",
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
        window.location.reload()
    }

    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            startPage: ${modelPost.page},
            totalPages:${modelPost.totalPage},
            visiblePages: 5,
            first:'Đầu',
            prev:'<<',
            next:'>>',
            last:'Cuối',
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
            window.location.href="<c:url value="/admin/post-list?page="/>"+page;

        });
    });
</script>
</body>
</html>

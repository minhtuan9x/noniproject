<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 18/01/2022
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Tìm Hiểu</title>
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
                <li class="active">Danh sách bài tìm hiểu</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="pull-right">
                        <button class="btn btn-white btn-info btn-bold " data-toggle="tooltip"
                                title="Thêm Bài Tìm Hiểu"
                                onclick="window.location.href='<c:url value="/admin/research-edit"/>'">
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
                            <th>Chỉ Mục</th>
                            <th>Tên Bài Tìm Hiểu</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${researches}">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.title}</td>
                                <td style="width: 150px">
                                    <button class="btn btn-xs btn-dark" data-toggle="tooltip"
                                            title="Sửa thông tin bài tìm hiểu" value="${item.id}"
                                            onclick="window.location.href='<c:url value="/admin/research-edit?id="/>'+${item.id}">
                                        <i class="fa fa-edit" aria-hidden="true"></i>
                                    </button>
                                    <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                            title="Xoá bài tìm hiểu" value="${item.id}" onclick="xoaResearch(value)">
                                        <i class="fa fa-remove" aria-hidden="true"></i>
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
</div><!-- /.main-content -->
<script>
    function xoaResearch(value){
        let text = "Bạn Có Muốn Xoá Bài Viết Này ???"
        if(window.confirm(text)===true){
            $.ajax({
                url:"<c:url value="/api/research/"/> "+value,
                type:"delete",
                success:function (e){
                    alert("Xoá Thành Công !!!");
                    window.location.reload()
                },
                error:function (e){
                    alert("Xoá Thất Bại !!!")
                }
            })
        }
    }
</script>
</body>
</html>

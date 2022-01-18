<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 30/12/2021
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết bài viết</title>
</head>
<body>
<%--
Created by IntelliJ IDEA.
User: MinhTuan
Date: 24/12/2021
Time: 20:43
To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
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
                <li class="active">Chi tiết bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form commandName="modelPost" cssClass="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Title</label>
                            <div class="col-sm-9">
                                <form:input path="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Ảnh bìa</label>
                            <div class="col-sm-9">
                                <c:if test="${modelPost.imgTitle!=null}">
                                    <img src="${modelPost.imgTitle}" style="width: 100px;height: 100px">
                                </c:if>
                                <c:if test="${modelPost.imgTitle==null}">
                                    <b>Không Có</b>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Up Ảnh Bìa</label>
                            <div class="col-sm-9">
                                <form:input path="file" type="file" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Nội dung ngắn giới thiệu</label>
                            <div class="col-sm-9">
                                <form:textarea path="sortContent" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Nội dung</label>
                            <div class="col-sm-9">
                                <form:textarea path="content" id="content" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                            </label>
                            <div class="col-sm-9">
                                <c:if test="${modelPost.id!=null}">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Cập nhập bài viết
                                    </button>
                                </c:if>
                                <c:if test="${modelPost.id==null}">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Thêm bài viết mới
                                    </button>
                                </c:if>
                                <button type="button" class="btn btn-primary">Huỷ</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<script>
    let content = "";
    content = CKEDITOR.replace('content');
    $("#formEdit").submit(function (e) {
        e.preventDefault();
        let description = content.getData();
        let formArr = $(this)[0]
        let data = new FormData(formArr);
        data.append("id","${modelPost.id}")
        data.delete("content")
        data.append("content",description)
        console.log(data)
        $.ajax({
            url: "<c:url value="/api/post" />",
            method: "post",
            enctype: 'multipart/form-data',
            data:data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 1000000,
            success: function (res) {
                if (${modelPost.id==null}) {
                    window.location.href = "<c:url value="/admin/post-list"/> "
                } else {
                    window.location.reload()
                }
            },
            error: function () {
                alert("fail")
            }
        })
    })

</script>
</body>
</html>

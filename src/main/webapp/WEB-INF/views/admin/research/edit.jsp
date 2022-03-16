<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 18/01/2022
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chi Tiết Tìm Hiểu</title>
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
                <li class="active">Chi tiết bài tìm hiểu</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form commandName="research" cssClass="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Chỉ Mục</label>
                            <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Tên bài viết</label>
                            <div class="col-sm-9">
                                <form:input path="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Nội Dung</label>
                            <div class="col-sm-9">
                                <form:textarea path="content" id="content" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                            </label>
                            <div class="col-sm-9">
                                <c:if test="${research.id!=null}">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Update bài viết
                                    </button>
                                </c:if>
                                <c:if test="${research.id==null}">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Thêm bài viết
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
    content = CKEDITOR.replace("content");
    $("#formEdit").submit(function (e){
        e.preventDefault();
        let data = {}
        data["id"]="${research.id}"!==""?"${research.id}":null;
        $(this).serializeArray().forEach(item=>{
            data[item.name] = item.value;
        })
        data["content"] = content.getData();
        $.ajax({
            url:"<c:url value="/api/research"/> ",
            type:"post",
            data:JSON.stringify(data),
            datatype:"json",
            contentType:"application/json",
            success:function (){
                alert("Lưu thành công !!")
                window.location.reload()
            },
            error:function (){
                alert("Fail!")
            }
        })
    })
</script>
</body>
</html>

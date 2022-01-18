<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 18/01/2022
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Giới thiệu</title>
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
                <li class="active">Chi Tiết Giới Thiệu</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-md-12">
                    <form:form commandName="introduce" id="formIntro">
                        <div class="row">
                            <div class="col-md-12">
                                <form:textarea path="content" id="content"></form:textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <form:button type="submit">Cập Nhập Nội Dung</form:button>
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
    content = CKEDITOR.replace("content")
    $("#formIntro").submit(function (e){
        e.preventDefault()
        let formData = $(this).serializeArray();
        let data = {};
        formData.forEach(item=>{
            data[item.name] = item.value
        })
        data["content"] = content.getData();
        $.ajax({
            url:"<c:url value="/api/introduce"/> ",
            type:"post",
            data:JSON.stringify(data),
            datatype:"json",
            contentType:"application/json",
            success:function (res){
                window.location.reload()
            },
            error:function (){
                alert("fail")
            }
        })
    })
</script>
</body>
</html>

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
                <li class="active">Chi tiết đơn hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form commandName="modelProduct" cssClass="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Tên sản phẩm</label>
                            <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Giá sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="number" name="price" class="form-control" value="${modelProduct.price}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Khối lượng</label>
                            <div class="col-sm-9">
                                <form:input path="mass" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Mô tả</label>
                            <div class="col-sm-9">
                                <form:input path="description" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Link ảnh title</label>
                            <div class="col-sm-9">
                                <form:input path="imgTitle" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Link ảnh chi tiết</label>
                            <div class="col-sm-9">
                                <form:input path="imgLink" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                            </label>
                            <div class="col-sm-9">
                                <c:if test="${modelProduct.id!=null}">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Update sản phẩm
                                    </button>
                                </c:if>
                                <c:if test="${modelProduct.id==null}">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Thêm sản phẩm
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
    $("#formEdit").submit(function (e){
        e.preventDefault();
        let formArr = $(this).serializeArray();
        let data={}
        formArr.forEach(item=>{
            data[item.name] = item.value
        })
        data["id"]=${modelProduct.id}
        console.log(data)
        $.ajax({
            url:"<c:url value="/api/product" />",
            method:"post",
            data:JSON.stringify(data),
            datatype:"json",
            contentType:"application/json",
            success:function (res){
                if(${modelProduct.id==null}){
                    window.location.href="<c:url value="/admin/product-list"/> "
                }else{
                    window.location.reload()
                }
            },
            error:function (){
                alert("fail")
            }
        })
    })



</script>
</body>
</html>

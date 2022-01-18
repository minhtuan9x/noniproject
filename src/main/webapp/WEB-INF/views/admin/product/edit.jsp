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
                                Ảnh Đại Diện Sản Phẩm</label>
                            <div class="col-sm-9">
                                <c:if test="${modelProduct.imgTitle!=null}">
                                    <img src="${modelProduct.imgTitle}" style="width: 100px;height: 100px">
                                </c:if>
                                <c:if test="${modelProduct.imgTitle==null}">
                                    <b>Không Có</b>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Up ảnh Đại Diện</label>
                            <div class="col-sm-9">
                                <form:input path="fileImgTitle" type="file" id="anh" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Ds ảnh chi tiết</label>
                            <div class="col-sm-9">
                                <c:if test="${modelProduct.imgLink!=null}">
                                    <c:forEach items="${modelProduct.imgLink}" var="itemImg">
                                        <img src="${itemImg}" style="width: 100px;height: 100px">
                                    </c:forEach>
                                </c:if>
                                <c:if test="${modelProduct.imgLink==null}">
                                    <b>Không Có</b>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Up Ảnh Chi Tiết</label>
                            <div class="col-sm-9">
                                <form:input path="fileImgExpands" type="file" cssClass="form-control"/>
                                <form:input path="fileImgExpands" type="file" cssClass="form-control"/>
                                <form:input path="fileImgExpands" type="file" cssClass="form-control"/>
                                <form:input path="fileImgExpands" type="file" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Mô tả</label>
                            <div class="col-sm-9">
                                <form:textarea path="description" id="content" cssClass="form-control"/>
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
    let content = "";
    content = CKEDITOR.replace('content');
    $("#formEdit").submit(function (e) {
        e.preventDefault();
        let description = content.getData();
        let formArr = $(this)[0]
        let data = new FormData(formArr);
        data.append("id","${modelProduct.id}")
        data.delete("description")
        data.append("description",description)
        console.log(data)
        $.ajax({
            url: "<c:url value="/api/product" />",
            method: "post",
            enctype: 'multipart/form-data',
            data:data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 1000000,
            success: function (res) {
                if (${modelProduct.id==null}) {
                    window.location.href = "<c:url value="/admin/product-list"/> "
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

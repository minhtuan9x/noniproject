<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 18/01/2022
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>${research.name}</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Chi Tiết Bài Đăng</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9" style="border-right: 1px solid rgba(222,222,221,0.38);">
            <div class="row" style="text-align: center">
                <div class="col-md-12">
                    <h1>${research.title}</h1>
                    <br>
                    <p style="font-size: 90%;color: #5a5a5a">Đăng bởi: ${research.createdBy} - Ngày
                        đăng: ${research.createDateStr}</p>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    ${research.content}
                </div>
            </div>
            <br>
            <br>
        </div>
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12">
                    <h5>BÀI VIẾT MỚI</h5>
                    <hr>
                    <c:forEach var="item" items="${postByDates}">
                        <a style="color: darkred" href="/post/${item.id}/detail">${item.title}</a>
                        <p style="font-size: 70%;color: #5a5a5a">Đăng bởi: ${research.createdBy} - Ngày
                            đăng: ${item.createDateStr}</p>
                        <hr style="width: 30px">
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

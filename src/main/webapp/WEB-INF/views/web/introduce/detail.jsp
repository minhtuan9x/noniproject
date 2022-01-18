<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 18/01/2022
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giới Thiệu</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Giới Thiệu</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            ${introduce.content}
        </div>
    </div>
    <br>
    <br>
</div>
</body>
</html>

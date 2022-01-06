<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 31/12/2021
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<body>

<div class="container" >
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb" style="background-color: rgba(110,110,109,0.05);">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Blogs</li>
            </ul>
        </div>
    </div>
    <c:forEach items="${posts}" var="item">
        <div class="row" style="margin-left: 15%;margin-right: 15%" id="list123">
            <div class="col-md-4" style="text-align: right">
                <img type="button" onclick="window.location.href='/post/${item.id}/detail'" style="border-radius: 2px" src="${item.imgTitle}" alt="">
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-12">
                        <h5><a style="color: #7b3f25" href="/post/${item.id}/detail">${item.title}</a></h5>
                        <hr style="width: 50px;border-color: darkred">
                    </div>
                </div>
                <div class="row" style="padding-bottom: 70px">
                    <div class="col-md-12">
                        <p style="color: #5a5a5a">${item.sortContent}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <p style="font-size: 90%;color: #5a5a5a">Đăng bởi: ${item.createdBy} - Ngày
                            đăng: ${item.createdDate}</p>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
    </c:forEach>
</div>
<style>
    img {
        width: 200px;
        height: 200px;
    }
    #list123{
        background-color: white;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.12),
        0 2px 2px rgba(0, 0, 0, 0.12),
        0 4px 4px rgba(0, 0, 0, 0.12),
        0 8px 8px rgba(0, 0, 0, 0.12),
        0 16px 16px rgba(0, 0, 0, 0.12);
    }
    .container{
        background-color: rgba(172,174,59,0.03);
    }
    body{
        background-color: rgba(110,110,109,0.05);
    }
</style>
</body>

</html>

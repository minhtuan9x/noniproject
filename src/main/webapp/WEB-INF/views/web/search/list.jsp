<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 04/02/2022
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Tìm Kiếm</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Tìm Kiếm</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <c:forEach items="${product}" var="item">
                <c:if test="${(product.indexOf(item) % 4) == 0}">
                    <div class="row" style="text-align: center">
                </c:if>
                <div class="col-md-3">
                    <div id="sp" onclick="window.location.href='/product/${item.id}/detail'">
                        <div>
                            <img style="border-radius: 5px" src="${item.imgTitle}">
                        </div>
                        <div>
                            <a style="color: #2b542c">[<b>${item.mass}</b>]${item.name}</a>
                        </div>
                        <div>
                            <p style="color: darkred;font-weight: bold;">${item.priceStr}đ</p>
                        </div>
                        <div style="padding-bottom: 5px;color:#7b3f25;">
                            <button class="btn btn-light btn-block"
                                    onclick="window.location.href='/product/${item.id}/detail'">
                                Đặt Hàng
                            </button>
                        </div>
                    </div>
                </div>
                <c:if test="${product.size() < 4 }">
                    </div>
                    <br>
                </c:if>
                <c:if test="${(product.indexOf(item) % 4) == 3}">
                    </div>
                    <br>
                </c:if>

            </c:forEach>
        </div>
    </div>
</div>
<style>
    #sp {
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.12),
        0 2px 2px rgba(0, 0, 0, 0.12),
        0 4px 4px rgba(0, 0, 0, 0.12),
        0 8px 8px rgba(0, 0, 0, 0.12),
        0 16px 16px rgba(0, 0, 0, 0.12);
    }

    #sp:hover {
        -ms-transform: scale(1.1); /* IE 9 */
        -webkit-transform: scale(1.1); /* Safari 3-8 */
        transform: scale(1.1);
    }

    img {
        width: 100%;
        height: 250px;
    }
</style>
</body>
</html>

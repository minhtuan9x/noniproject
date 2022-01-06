<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 02/01/2022
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Sản Phẩm</li>
            </ul>
        </div>
    </div>
    <div class="row" id="head1">
        <div class="col-md-12">
            <h5>Bạn có thể đặt hàng bằng 3 cách:</h5>
            <br>
            <ul>
                <li>Gọi điện hoặc chat Zalo qua hotline: 0367.842.388</li>
                <li>Đặt tại SHOPEE: CLICK VÀO ĐÂY</li>
            </ul>
            <br>
            <p>LƯU Ý: Bên dưới là giá lẻ, nếu bạn cần lấy sỉ (số lượng tối thiểu 10 ký/đơn hàng) vui lòng liên hệ trực
                tiếp
                với mình để có mức giá tốt nhất. Có sẵn túi trơn để bạn tự đóng nhãn mác lên.</p>
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-md-12">
            <c:forEach items="${products}" var="item">
                <c:if test="${(products.indexOf(item) % 4) == 0}">
                    <div class="row" style="text-align: center">
                </c:if>
                <div class="col-md-3">
                    <div id="sp" onclick="window.location.href='/product/${item.id}/detail'   ">
                        <div>
                            <img style="border-radius: 5px" src="${item.imgTitle}">
                        </div>
                        <div>
                            <a style="color: #2b542c">[${item.mass}]${item.name}</a>
                        </div>
                        <div>
                            <p style="color: darkred;font-weight: bold;">${item.priceStr}đ</p>
                        </div>
                    </div>
                </div>
                <c:if test="${(products.indexOf(item) % 4) == 3}">
                    </div>
                    <br>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12" id="head2">
            <br>
            <p>Tất cả các loại cà phê bên mình đều Rang mộc, không trộn hương liệu và không trộn các loại bột khác (Hoàn
                tiền 100% kèm theo phí ship 2 chiều nếu sản phẩm không đúng cam kết).</p>
            <br>
            <p>Bạn là người đã từng dùng cà phê rang mộc và đang muốn tìm loại ngon hơn trong tầm giá tiền? đừng ngần
                ngại hãy đặt hàng ngay trên website để nhận ưu đãi. Nếu bạn còn phân vân chưa biết mua loại nào? dành
                chút thời gian tìm hiểu thêm nhiều thông tin hơn tại trang chủ, có video chia sẻ thực tế.</p>
            <br>
            <button style="margin-left: 40%;margin-right: 40%" type="button" class="btn btn-dark">Tìm Hiểu Thêm
                ...
            </button>
            <br>
            <br>
        </div>
    </div>
    <br>
</div>
</div>
<style>
    #head1 {
        border: 1px dotted red;
        background-color: rgba(174, 146, 50, 0.19);

    }

    #head2 {
        border: 1px dot-dash #0c5460;
        background-color: rgba(172, 174, 59, 0.19);
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.12),
        0 2px 2px rgba(0, 0, 0, 0.12),
        0 4px 4px rgba(0, 0, 0, 0.12),
        0 8px 8px rgba(0, 0, 0, 0.12),
        0 16px 16px rgba(0, 0, 0, 0.12);

    }

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
<script>

</script>
</body>
</html>

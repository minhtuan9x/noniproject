<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<header>
    <div style="background-color: dimgray;">
        <div class="row" id="top">
            <div id="l" class="col-md-6">
                <p style="height: 10px;color: seashell;font-family: monospace;">Thôn 1 - Đăk Mar - Đăk Hà - Kon Tum</p>
            </div>
            <div id="r" class="col-md-6">
                <a href="https://www.facebook.com/profile.php?id=100016751650542" style="color:black;"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="tel:0367842388" style="color:black;"><i class="fa fa-phone" aria-hidden="true"></i></a>
                <a href="mailto:caphenonidakhakt@gmail.com" style="color: black"><i class="fa fa-envelope-o" aria-hidden="true"></i></a>
                <a href="https://www.youtube.com/channel/UCdMfvEqKQTk_QMdrd837XFg" style="color:black;"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                <a href="<c:url value="/login"/>" style="color:black;"><i class="fa fa-user" aria-hidden="true"></i></a>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column flex-md-row align-items-center px-md-4 mb-3 bg-light border-bottom shadow-sm">
        <img type="button" class="my-0 mr-md-auto font-weight-normal" id="logo" src="/img/logo.png"
             style="width: 100px;" onclick="window.location.href='<c:url value="/trang-chu"/>'">
        <nav class="my-2 my-md-0 mr-md-3" id="td123">
            <a class="p-2 text-dark" href="#">GIỚI THIỆU</a>
            <a class="p-2 text-dark" href="<c:url value="/product/list" />">SẢN PHẨM</a>
            <a class="p-2 text-dark dropdown-toggle" href="#"
               id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">TÌM HIỂU</a>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
            </div>
            <a class="p-2 text-dark" href="<c:url value="/post/list" />">BLOGS</a>
            <a class="p-2 text-dark" href="<c:url value="/video" />">VIDEOS</a>
            <a class="p-2 text-dark" href="#lienhe">LIÊN HỆ</a>
            <a class="p-2 text-dark fa fa-shopping-cart" href="<c:url value="/product/shopcart" />">
                <asp:Label ID="lblCartCount" runat="server" CssClass="badge badge-warning"  ForeColor="White"/>
                <span id="lengthItems"></span>
            </a>
        </nav>
        <!-- <a id="cham" class="btn btn-outline-primary" href="#"><i class="fa fa-search" aria-hidden="true"></i></a> -->
        <form id="formsearch" style="padding-right: 10%;float: right;">
            <div class="input-group" style="width: auto">
                <input id="inhien" type="text" class="form-control" placeholder="Tìm kiếm sản phẩm...">
                <div type="button" id="hien" class="input-group-prepend">
                    <span class="input-group-text"><i class="fa fa-search" aria-hidden="true"></i></span>
                </div>
            </div>
        </form>
    </div>
</header>

<script>
    $("#inhien").hide()
    $(document).ready(
        $("#formsearch").click(function (e) {
            e.preventDefault();
            $("#inhien").toggle()
        })
    )
    let size = Object.keys(JSON.parse(localStorage.getItem("myCart"))).length;
    $("#lengthItems").append(size)

</script>
<style>
    #logo {
        width: 10%;
        height: 10%;
        margin-left: 10%;
    }

    nav {
        float: right;
    }

    #top {
        margin-left: 10%;
        margin-right: 10%;
    }

    i {
        margin-left: 1%;
        margin-right: 1%;
    }

    #l {
        text-align: left;
    }

    #r {
        text-align: right;
    }
    #td123 a{
        font-weight: 700;
    }


</style>


<%--<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>--%>
<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">--%>
<%--	<div class="container">--%>
<%--		<a class="navbar-brand" href="#">Start Bootstrap</a>--%>
<%--		<button class="navbar-toggler" type="button" data-toggle="collapse"--%>
<%--			data-target="#navbarResponsive" aria-controls="navbarResponsive"--%>
<%--			aria-expanded="false" aria-label="Toggle navigation">--%>
<%--			<span class="navbar-toggler-icon"></span>--%>
<%--		</button>--%>
<%--		<div class="collapse navbar-collapse" id="navbarResponsive">--%>
<%--			<ul class="navbar-nav ml-auto">--%>
<%--				<li class="nav-item active"><a class="nav-link" href="#">Trang chủ--%>
<%--						<span class="sr-only">(current)</span>--%>
<%--				</a></li>--%>
<%--				<security:authorize access = "isAnonymous()">--%>
<%--					<li class="nav-item"><a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a></li>--%>
<%--					<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>--%>
<%--				</security:authorize>--%>
<%--				<security:authorize access = "isAuthenticated()">--%>
<%--					<li class="nav-item"><a class="nav-link" href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a></li>--%>
<%--					<li class="nav-item"><a class="nav-link" href="<c:url value='/logout'/>">Thoát</a></li>--%>
<%--				</security:authorize>--%>
<%--			</ul>--%>
<%--		</div>--%>
<%--	</div>--%>
<%--</nav>--%>
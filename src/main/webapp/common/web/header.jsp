<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<div style="background-color: dimgray;">
		<div class="row" id="top">
			<div id="l" class="col-md-6">
				<p style="height: 10px;color: seashell;font-family: monospace;">Thôn 1 - Đăk Mar - Đăk Hà - Kon Tum</p>
			</div>
			<div id="r" class="col-md-6">
				<i class="fa fa-facebook" aria-hidden="true"></i>
				<i class="fa fa-phone" aria-hidden="true"></i>
				<i class="fa fa-envelope-o" aria-hidden="true"></i>
				<i class="fa fa-youtube-play" aria-hidden="true"></i>
				<i type="button" class="fa fa-user" aria-hidden="true" onclick="window.location.href='<c:url value="/login"/>'"></i>
			</div>
		</div>
	</div>
	<div class="d-flex flex-column flex-md-row align-items-center px-md-4 mb-3 bg-light border-bottom shadow-sm">
		<img class="my-0 mr-md-auto font-weight-normal" id="logo" src="../assets/img/logo.jpg" onclick="window.location.reload()" style="width: 100px;">
		<nav class="my-2 my-md-0 mr-md-3">
			<div class="dropdown">
				<a class="p-2 text-dark" href="#">Giới thiệu</a>
				<a class="p-2 text-dark" href="#">Sản phẩm</a>
				<a id="drop" type="button" class="p-2 text-dark dropdown-toggle" data-toggle="dropdown">Tìm hiểu</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/views/research/caphenguyenchat.html">Cà Phê Nguyên Chất</a>
					<a class="dropdown-item" href="#">Link 2</a>
					<a class="dropdown-item" href="#">Link 3</a>
				</div>
				<a class="p-2 text-dark" href="#">Blog</a>
				<a class="p-2 text-dark" href="<c:url value="/video" />">Video</a>
				<a class="p-2 text-dark" href="#lienhe">Liên Hệ</a>
			</div>
		</nav>
		<!-- <a id="cham" class="btn btn-outline-primary" href="#"><i class="fa fa-search" aria-hidden="true"></i></a> -->
		<form id="formsearch" style="padding-right: 10%;float: right;">
			<div class="input-group" style="width: auto">
				<input id="inhien" type="text" class="form-control" placeholder="Tìm Kiếm...">
				<div type="button" id="hien" class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-search" aria-hidden="true"></i></span>
				</div>
			</div>
		</form>
	</div>
</header>
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

<script>
	$("#inhien").hide()
	$(document).ready(
			$("#formsearch").hover(function (e) {
				e.preventDefault();
				$("#inhien").toggle("slow")
			})
	)

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
</style>
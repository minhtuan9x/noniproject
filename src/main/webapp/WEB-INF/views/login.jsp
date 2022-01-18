<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <!-- <h1 class="form-heading">login Form</h1> -->
    <div class="login-form">
        <div class="main-div">
            <c:if test="${param.incorrectAccount != null}">
                <div class="alert alert-danger">
                    Tên Tài hoặc mật khẩu sai
                </div>
            </c:if>
            <c:if test="${param.accessDenied != null}">
                <div class="alert alert-danger">
                    you Not authorize
                </div>
            </c:if>
            <c:if test="${param.sessionTimeout != null}">
                <div class="alert alert-danger">
                    session timeout
                </div>
            </c:if>
            <div class="login-box">
                <div class="login-header">Trang quản trị</div>
                <div class="login-body">
                    <form action="j_spring_security_check" id="formLogin" class="form-group" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" id="userName" name="j_username"
                                   placeholder="Tên đăng nhập">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="j_password"
                                   placeholder="Mật khẩu">
                        </div>
                        <button type="submit" class="btn btn-primary">Đăng nhập</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    .login-box {
        height: 50%;
        width: 30%;
        border: 1px solid grey;
        margin-left: 35%;
        margin-top: 10%;
        position: relative;
        box-shadow: 21px 12px 24px 10px rgba(0, 0, 0, .5);
        background: #dadada;
    }

    .login-header {
        text-align: center;
        font-family: "vardhana", cursive;
        font-size: 35px;
        background: linear-gradient(to bottom, #00bfff 0%, #0000ff 100%);
        color: #fff;
        position: relative;
        box-shadow: 1px 3px 14px rgba(0, 0, 0, .5);
    }

    .login-body {
        padding: 20px;
        line-height: 2;
    }
</style>
</body>

</html>
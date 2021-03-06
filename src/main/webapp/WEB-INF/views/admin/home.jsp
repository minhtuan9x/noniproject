<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <title>Trang chủ</title> -->
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row" >
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Thống kê đơn hàng </h3>
                            <p>Tổng số đơn hàng chưa xử lí: ${status.contactNew}</p>
                            <p>Tổng số đơn hàng đang xử lí: ${status.contactProcess}</p>
                            <p>Tổng số đơn hàng đã xử lí: ${status.contactProcessed}</p>
                            <p>Tổng số đơn hàng: ${status.totalProcess}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
</body>
</html>
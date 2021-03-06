<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar ace-save-state">
    <script type="text/javascript">
        try {
            ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button type="button" class="btn btn-success" onclick="window.location.href='/admin/home'">
                <i class="ace-icon fa fa-home"></i>
            </button>
            <button type="button" class="btn btn-info" onclick="window.location.href='/trang-chu'">
                <i class="ace-icon fa fa-rub"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-users"></i>
                <span class="menu-text">QL tài khoản</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/user-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS tài khoản
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-product-hunt"></i>
                <span class="menu-text">QL sản phẩm</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/product-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS sản phẩm
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='<c:url value='/admin/product-edit'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm sản phẩm
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-list"></i>
                <span class="menu-text">QL bài viết</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/post-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS bài viết
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='<c:url value='/admin/post-edit'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm bài viết
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-video-camera"></i>
                <span class="menu-text">QL video</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/video-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS video
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-buysellads"></i>
                <span class="menu-text">QL đơn hàng</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/contact-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS đơn hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-photo"></i>
                <span class="menu-text">QL Hình Ảnh</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/image-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách Hình Ảnh
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-paper-plane"></i>
                <span class="menu-text">QL Giới Thiệu</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/introduce-detail?id=2'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Chi Tiết Bài Giới Thiệu
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='<c:url value='/admin/introduce-detail?id=5'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Bài Giới Thiệu Trang Chủ
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fas fa-plus"></i>
                <span class="menu-text">QL Tìm Hiểu</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value='/admin/research-list'/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách bài tìm hiểu
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left"
           data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>
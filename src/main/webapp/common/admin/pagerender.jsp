<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 14/01/2022
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-md-12">
        <ul class="pagination justify-content-center" id="pagination"></ul>
    </div>
</div>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="<c:url value="/admin/home"/> ">Trang chủ</a>
                </li>
                <li class="active">Chi Tiết Giới Thiệu</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">

        </div>
    </div><!-- /.page-content -->
</div>
</div><!-- /.main-content -->


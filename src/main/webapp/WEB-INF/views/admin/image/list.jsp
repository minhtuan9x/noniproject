<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 17/01/2022
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Danh sách ảnh</title>
</head>
<body>
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
                <li class="active">Danh sách Ảnh</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <button type="button" class="btn btn-danger" onclick="xoa()">Xoá Ảnh</button>
                        <button type="button" class="btn btn-default" onclick="getLink()">Get Link Ảnh</button>
                        <div class="row">
                            <form id="formUp">

                                <div class="col-md-4">
                                    <input name="file" type="file" class="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <input name="text" type="text" placeholder="Tên ảnh (tuỳ chọn)" class="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <button type="submit" class="btn btn-success">Upload</button>
                                </div>

                            </form>
                        </div>


                        <div class="col-md-12">
                            <ul>
                                <c:forEach items="${images}" var="item">
                                    <li>
                                        <input type="checkbox" name="checkDel[]" value="${item.id}"
                                               id="myCheckbox${item.id}"/>
                                        <label for="myCheckbox${item.id}">
                                            <img src="${item.viewLink}" alt="${item.name}"/>
                                            <p>${item.name}</p>
                                        </label>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<script>

    function xoa() {
        let values = [];
        $.each($("input[name='checkDel[]']:checked"), function () {
            values.push($(this).val());
        });
        let text = "Bạn có muốn xoá hình ảnh???";
        if (confirm(text) == true) {
            $.ajax({
                url: "<c:url value="/api/upload" />",
                type: "delete",
                data: JSON.stringify(values),
                datatype: "json",
                contentType: "application/json",
                success: function () {
                    alert("Đã Xoá!")
                    window.location.reload();
                },
                error: function () {
                    alert("that bai")
                }
            });

        } else {
            alert("Đã Huỷ!")
        }
    }

    function copyToClipboard(text) {
        let sampleTextarea = document.createElement("textarea");
        document.body.appendChild(sampleTextarea);
        sampleTextarea.value = text; //save main text in it
        sampleTextarea.select(); //select textarea contenrs
        document.execCommand("copy");
        document.body.removeChild(sampleTextarea);
    }

    function getLink() {
        let values = [];
        $.each($("input[name='checkDel[]']:checked"), function () {
            values.push($(this).val());
        });
        if (values.length == 1) {
            copyToClipboard("https://drive.google.com/uc?export=view&id=" + values[0])
            alert("Đã sao chép url ảnh")
        } else {
            alert("Vui Lòng Chọn 1 Ảnh")
        }
    }

    $("#formUp").submit(function (e) {
        e.preventDefault()
        $.ajax({
            url: "<c:url value="/api/upload/option" />",
            method: "post",
            enctype: 'multipart/form-data',
            data: new FormData($(this)[0]),
            processData: false,
            contentType: false,
            cache: false,
            timeout: 1000000,
            success: function (res) {
                window.location.reload()
            },
            error: function () {
                alert("fail")
            }
        })
    })
</script>
<style>
    ul {
        list-style-type: none;
    }

    li {
        display: inline-block;
    }

    input[type="checkbox"][id^="myCheckbox"] {
        display: none;
    }

    label {
        border: 1px solid #fff;
        padding: 10px;
        display: block;
        position: relative;
        margin: 10px;
        cursor: pointer;
    }

    label:before {
        background-color: white;
        color: white;
        content: " ";
        display: block;
        border-radius: 50%;
        border: 1px solid grey;
        position: absolute;
        top: -5px;
        left: -5px;
        width: 25px;
        height: 25px;
        text-align: center;
        line-height: 28px;
        transition-duration: 0.4s;
        transform: scale(0);
    }

    label img {
        height: 200px;
        width: 200px;
        transition-duration: 0.2s;
        transform-origin: 50% 50%;
    }

    :checked + label {
        border-color: #ddd;
    }

    :checked + label:before {
        content: "✓";
        background-color: grey;
        transform: scale(1);
    }

    :checked + label img {
        transform: scale(0.9);
        /* box-shadow: 0 0 5px #333; */
        z-index: -1;
    }
</style>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
</head>
<!-- Page Content -->
<body>
<div>
    <div class="container">
        <div class="row">
            ${intro.content}
        </div>
        <br>
        <br>
        <div class="row" id="main1">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <h3 style="color: #1a1a1a;margin-left: 10px">Bài Viết Mới Nhất</h3>
                        <br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <c:forEach items="${posts}" var="item">
                            <c:if test="${(posts.indexOf(item) % 4) == 0}">
                                <div class="row" style="text-align: center">
                            </c:if>
                            <div class="col-md-3">
                                <div id="sp" type="button" onclick='window.location.href="/post/${item.id}/detail"'
                                     style="height: 300px">
                                    <div>
                                        <img style="border-radius: 5px" src="${item.imgTitle}">
                                    </div>
                                    <div>
                                        <br>
                                        <p style="color: #1a1a1a;font-weight: bold;">${item.title}</p>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${(products.indexOf(item) % 4) == 3}">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <br>
                        <a href="/post/list">Xem Thêm ...</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <div class="row" id="main2">
        <div class="row">
            <div class="col-md-12">
                <h3 style="color: #1a1a1a;margin-left: 10px">Video Mới Nhất</h3>
                <br>
            </div>
        </div>
        <div class="col-md-12">
            <c:forEach items="${videos}" var="item">
                <c:if test="${(videos.indexOf(item) % 3) == 0}">
                    <div class="row" style="text-align: center">
                </c:if>
                <div class="col-md-4">
            <span type="button" data-toggle="modal" data-src="${item.link}" data-target="#myModal">
<%--                <img src="${item.thumbnail}" style="border-radius: 5px">--%>
                <div class="ytImgContainer">
                        <div class="ytImgThumbBox">
                            <img src="${item.thumbnail}" class="ytImgThumbImg" alt="text">
                            <div class="ytImgThumbPlay">
                                <img src="/img/iconPlay.jpg" class="ytImgThumbPlayButton">
                            </div>
                        </div>
                </div>

                <h5 style="font-size: 15px;padding-left: 20%;padding-right: 20%"> ${item.title}</h5>
            </span>
                </div>
                <c:if test="${(videos.indexOf(item) % 3) == 2}">
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a href="/video">Xem Thêm ...</a>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <!-- 16:9 aspect ratio -->
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="" id="video" allowscriptaccess="always"
                                allow="autoplay" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>

</div>
<!-- /.container -->
<style>
    body {
        background-color: rgba(120, 120, 116, 0.36);
    }

    #main1 {
        background-color: white;
        text-align: center;
        padding: 30px 2%;
    }

    #main2 {
        background-color: white;
        text-align: center;
        padding: 30px 2%;
    }

    #sp {
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.12),
        0 2px 2px rgba(0, 0, 0, 0.12),
        0 4px 4px rgba(0, 0, 0, 0.12),
        0 8px 8px rgba(0, 0, 0, 0.12),
        0 16px 16px rgba(0, 0, 0, 0.12);
    }

    /*#sp:hover {*/
    /*    -ms-transform: scale(1.1); !* IE 9 *!*/
    /*    -webkit-transform: scale(1.1); !* Safari 3-8 *!*/
    /*    transform: scale(1.1);*/
    /*}*/

    img {
        height: 200px;
        width: 80%;
    }


    .ytImgContainer img {
        max-width: 100%;
        height: auto;
    }

    .ytImgContainer {
        margin: 0 auto;
        max-width: 604px;
        width: 100%;
    }

    .ytImgContainer:after {
        clear: both;
    }

    .ytImgContainer:before,
    .ytImgContainer:after {
        content: "";
        display: table;
    }

    div.ytImgThumbBox {
        position: relative !important;
        width: 100% !important;
        height: 100% !important;
        overflow: hidden;
    }

    div.ytImgThumbPlay {
        position: absolute !important;
        top: 50% !important;
        left: 50% !important;
        width: 48px !important;
        height: 48px !important;
        margin: -24px 0 0 -24px !important;
    }

    img.ytImgThumbImg {
        /*width: 100% !important;*/
        /*height: 100% !important;*/
        /*margin: -9.5% 0px -12%;*/
        border-radius: 5px;
    }

    .ytImgThumbPlay:hover {
        -ms-transform: scale(2); /* IE 9 */
        -webkit-transform: scale(2); /* Safari 3-8 */
        transform: scale(2);
    }
</style>
<script>
    $(document).ready(function () {

        let $videoSrc;
        $('span').click(function () {
            $videoSrc = $(this).data("src");
        });
        console.log($videoSrc);

        $('#myModal').on('shown.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
        })
        $('#myModal').on('hide.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc);
        })


    });
</script>
</body>

</html>
<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 24/12/2021
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ul class="breadcrumb">
                <li><a href="/trang-chu">Trang Chủ</a></li>
                <li id="liL">Videos</li>
            </ul>
        </div>
    </div>

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

                <h5 style="padding-left: 20px;padding-right: 20px;font-size: 15px"> ${item.title}</h5>
            </span>
        </div>
        <c:if test="${(videos.indexOf(item) % 3) == 2}">
            </div>
        </c:if>
    </c:forEach>
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
<style>
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

    div.ytImgThumbBox{
        position: relative !important;
        width: 100% !important;
        height: 100% !important;
        overflow: hidden;
    }

    div.ytImgThumbPlay{
        position: absolute !important;
        top: 50% !important;
        left: 50% !important;
        width:48px !important;
        height:48px !important;
        margin: -24px 0 0 -24px !important;
    }

    img.ytImgThumbImg{
        /*width: 100% !important;*/
        /*height: 100% !important;*/
        /*margin: -9.5% 0px -12%;*/
        border-radius: 5px;
    }
    .ytImgThumbPlay:hover{
        -ms-transform: scale(2); /* IE 9 */
        -webkit-transform: scale(2); /* Safari 3-8 */
        transform: scale(2);
    }
</style>

</body>

</html>

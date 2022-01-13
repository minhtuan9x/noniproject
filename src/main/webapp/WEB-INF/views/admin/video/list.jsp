<%--
  Created by IntelliJ IDEA.
  User: MinhTuan
  Date: 31/12/2021
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video</title>
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
                <li class="active">Danh sách Videos</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <button type="button" id="btnUp" class="btn btn-default">Update Video</button>
            <table class="table">
                <tbody id="tbYT">
                </tbody>
            </table>
            <br/>
            <div class="row">
                <div class="col-md-12">
                    <div class="row" id="main2">
                        <div class="row">
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
                        <!-- Modal -->
                        <div class="modal fade " id="myModal" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <!-- 16:9 aspect ratio -->
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <iframe class="embed-responsive-item" src="" id="video"
                                                allowscriptaccess="always"
                                                allow="autoplay" allowfullscreen></iframe>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.page-content -->
    </div>


</div><!-- /.main-content -->


<script>
    $("#btnUp").click(function (e) {
        e.preventDefault();
        let url123 = 'https://www.googleapis.com/youtube/v3/search?key=AIzaSyCUCv-kqTzk3EeRySln9SL9xv4YQiYqJzc&channelId=UCdMfvEqKQTk_QMdrd837XFg&part=snippet,id&order=date&maxResults=50'
        let dataReq = [];
        $.ajax({
            type: "GET",
            url: url123,
            crossDomain: true,
            datatype: "json",
            success: function (res) {
                let arrYou = res.items;
                arrYou.forEach(item => {
                    let itemList = {
                        "title": item.snippet.title,
                        "link": item.id.videoId,
                        "thumbnail": item.snippet.thumbnails.medium.url
                    }
                    dataReq.push(itemList)
                })
                console.log(dataReq)
                $.ajax({
                    url: "<c:url value="/api/video"/>",
                    type: "POST",
                    data: JSON.stringify(dataReq),
                    datatype: "json",
                    contentType: "application/json",
                    success: function () {
                        window.location.reload()
                    },
                    error: function () {
                        alert("fail ahihi")
                    }
                })
            },
            error: function (res) {
                console.log(res)
                alert("loi youtube")
            }
        })
    })
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
</body>
</html>

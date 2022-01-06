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
<div class="container">
    <button type="button" id="btnUp" class="btn btn-default">Update Video</button>
    <table class="table">
        <tbody id="tbYT">
        </tbody>
    </table>
</div>
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
                        alert("done")
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
</body>
</html>

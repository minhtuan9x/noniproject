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
    <table class="table">
        <tbody id="tbYT">
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <p>Some text in the modal.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    let url123 = 'https://www.googleapis.com/youtube/v3/search?key=AIzaSyCUCv-kqTzk3EeRySln9SL9xv4YQiYqJzc&channelId=UCdMfvEqKQTk_QMdrd837XFg&part=snippet,id&order=date&maxResults=20'
    $.ajax({
        type: "GET",
        url: url123,
        crossDomain: true,
        datatype: "json",
        success: function (res) {
            let arrYou = res.items;
            console.log(arrYou);
            let str = '<tr>'
            let flag = 0;
            arrYou.forEach(item => {
                let id = "";
                id+=item.id.videoId;
                str += '<td >' +
                    '<div class="row"> ' +
                    '<img id="'+id+'" type="button" src="' + item.snippet.thumbnails.medium.url + '" style="border-radius: 3px"' +
                    'onclick="onVideo(this.id)" data-toggle="modal"' +
                    '>' +
                    '</div>' +
                    '<div class="row"> ' +
                    '<h5>' + item.snippet.title + '</h5>' +
                    '</div>' +
                    '</td>'
                flag++;
                if (flag == 3) {
                    str += '</tr>'
                    $("#tbYT").append(str);
                    str = '<tr>';
                    flag = 0;
                }
            })
        },
        error: function () {
            alert("loi")
        }
    })

    function onVideo(value) {
        window.location.href="https://www.youtube.com/watch?v="+value
    }

</script>
</body>
<style>
    #tbYT tr td {
        position: center;
    }
</style>
</html>

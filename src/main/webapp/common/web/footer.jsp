<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="bg-dark text-center text-white" id="lienhe">
	<div class="row" style="padding-top: 50px;padding-bottom: 50px;">
		<div class="col-md-6" style="padding-left: 15%;">
			<h1>Cà phê Noni</h1>
			<br />
			<ul style="text-align: left;font-size: large;">
				<li>Giờ làm việc: Thứ 2-CN (7h-16h)</li>
				<li>Địa chỉ: Thôn 1 - Xã Đắk Mar - Huyện Đắk Hà - Tỉnh Kon Tum</li>
				<li>Điện thoại: <a href="tel:0367842388">0367.842.388</a></li>
				<li>Email: <a href="mailto:caphenonidakhakt@gmail.com">caphenonidakhakt@gmail.com</a></li>
			</ul>
			<hr style="border-color: white;" />
			<a href="https://www.facebook.com/profile.php?id=100016751650542" style="color:white;"><i class="fa fa-facebook fa-2x" aria-hidden="true"></i></a>
			<a href="tel:0367842388" style="color:white;"><i class="fa fa-phone fa-2x" aria-hidden="true"></i></a>
			<a href="mailto:caphenonidakhakt@gmail.com" style="color: white"><i class="fa fa-envelope-o fa-2x" aria-hidden="true"></i></a>
			<a href="https://www.youtube.com/channel/UCdMfvEqKQTk_QMdrd837XFg" style="color:white;"><i class="fa fa-youtube-play fa-2x" aria-hidden="true"></i></a>
		</div>
		<div class="col-md-6" style="padding-right: 15%;">
			<div class="iframe-container">
				<iframe style="border-radius: 1%;"
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d341.3563910540524!2d107.92109551001603!3d14.541609265205146!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x316be57d241754cd%3A0xdb0c3ef5e530114d!2zQ8OgIHBow6ogbm8gbmk!5e0!3m2!1svi!2s!4v1638802889310!5m2!1svi!2s"
						width="600" height="300" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
			</div>
		</div>

	</div>
	<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
		2021 © Copyright:
		<a class="text-white" href="https://mdbootstrap.com/">tuandoit.com</a>
	</div>


	<div id="modalLoad" class="modal fade" 	data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-dialog-centered modal-sm">
			<div class="modal-content" style="color: black">
					<i class="fa fa-circle-o-notch fa-spin fa-3x"></i>
			</div>
		</div>
	</div>
	<script>
		$(document).ajaxStart(function (){
			$("#modalLoad").modal("show")
		})
		$(document).ajaxStop(function (e){
			$('#modalLoad').modal('hide');
		});
	</script>
	<style>

		.modal-content
		{
			background-color: rgba(110,110,109,0);
			border-color: rgba(110,110,109,0);
		}

		.iframe-container{
			position: relative;
			width: 100%;
			padding-bottom: 56.25%; /* Ratio 16:9 ( 100%/16*9 = 56.25% ) */
		}
		.iframe-container > *{
			display: block;
			position: absolute;
			top: 0;
			right: 0;
			bottom: 0;
			left: 0;
			margin: 0;
			padding: 0;
			height: 100%;
			width: 100%;
		}


		ul.breadcrumb {
			padding: 10px 16px;
			list-style: none;
			background-color: white;
		}

		/* Display list items side by side */
		ul.breadcrumb li {
			display: inline;
			font-weight: 300;
		}

		/* Add a slash symbol (/) before/behind each list item */
		ul.breadcrumb li+li:before {
			padding: 8px;
			color: black;
			content: "/\00a0";
		}

		/* Add a color to all links inside the list */
		ul.breadcrumb li a {
			color: #5a5a5a;
			text-decoration: none;
		}

		/* Add a color on mouse-over */
		ul.breadcrumb li a:hover {
			color: #01447e;
			text-decoration: underline;
		}
		#liL{
			font-weight: 700;
		}
	</style>
</footer>
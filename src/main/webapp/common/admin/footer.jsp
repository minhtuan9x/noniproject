<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="footer">
    <div class="footer-inner">
        <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">caphenoni.vn</span>
						</span>

            &nbsp; &nbsp;
            <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
        </div>
    </div>

	<div id="modalLoad" class="modal fade" 	data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-dialog-centered modal-sm">
			<div class="modal-content" id="mdct" style="color: black">
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
		#mdct
		{
			background-color: rgba(110,110,109,0);
			border-color: rgba(110,110,109,0);
		}
	</style>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp"%>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<%--left_column.jsp--%>
		<%-- Left side column. contains the logo and sidebar --%>
		<%@ include file="include/left_column.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<%-- Main Header --%>
				<%@ include file="include/main_header.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Content Row -->
					<div class="row">

						<div class="col-md-6 mb-4">
							<div class="card shadow">
								<div class="card-header border-left-primary py-3">
									<h6 class="m-0 font-weight-bold text-primary">
										<a href="/bbs/ci_notice">공지사항</a>
									</h6>
								</div>
								<div id="ci_notice" class="card-body">
									<ul class="list-unstyled mb-0"></ul>
								</div>
							</div>
						</div>
						
						<div class="col-md-6 mb-4">
							<div class="card shadow">
								<div class="card-header border-left-primary py-3">
									<h6 class="m-0 font-weight-bold text-primary">
										<a href="/bbs/gi_notice">게임공지</a>
									</h6>
								</div>
								<div id="gi_notice" class="card-body">
									<ul class="list-unstyled mb-0"></ul>
								</div>
							</div>
						</div>
						
					</div>
					<!-- End Content Row -->
					
					<!-- Content Row -->
					<div class="row">

						<div class="col-md-6 mb-4">
							<div class="card shadow">
								<div class="card-header border-left-primary py-3">
									<h6 class="m-0 font-weight-bold text-primary">
										<a href="/bbs/ci_recruit">친선모집</a>
									</h6>
								</div>
								<div id="ci_recruit" class="card-body">
									<ul class="list-unstyled mb-0"></ul>
								</div>
							</div>
						</div>
						
						<div class="col-md-6 mb-4">
							<div class="card shadow">
								<div class="card-header border-left-primary py-3">
									<h6 class="m-0 font-weight-bold text-primary">
										<a href="/bbs/cmnt_free">자유게시판</a>
									</h6>
								</div>
								<div id="cmnt_free" class="card-body">
									<ul class="list-unstyled mb-0"></ul>
								</div>
							</div>
						</div>
						
					</div>
					<!-- End Content Row -->

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End Main Content -->

			<%-- Main Footer --%>
			<%@ include file="include/main_footer.jsp"%>

		</div>
		<!-- End Content Wrapper -->

	</div>
	<!-- End Page Wrapper -->

	<%--plugin_js.jsp--%>
	<%@ include file="include/plugin_js.jsp"%>

	<script>
	$(document).ready(function() {
		getPostList('ci_notice');
		getPostList('gi_notice');
		getPostList('ci_recruit');
		getPostList('cmnt_free');
	});
	
	function getPostList(menuCd) {
		
		$.ajax({
			/* url : `/getPostList/${menuCd}`, */
			url : "/main/" + menuCd,
			type : "GET",
			dataType : "json",
			success : function(response) {
				/* log */
				console.info(response);
				$('#' + menuCd).children('ul').html('');
				$.each(response, function(index, value) {
					$('#' + menuCd).children('ul').append(
						'<li>' +
							'<a href="/post/' + value.postId + '">' + value.postSubject + '</a>' +
						'</li>'
					);
				});
			}
		});
	}
	</script>
</body>
</html>
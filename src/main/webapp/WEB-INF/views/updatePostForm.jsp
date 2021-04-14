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
						<div class="col-md-12 mb-4">
							<div class="card">
								<div class="card-body">
									<form method="post" action="/updatePost">
										<div class="form-group">
											<input type="hidden" id="postId" name="postId" value="${post.postId}"/>
											<input type="hidden" id="brdCd" name="brdCd" value="${post.brdCd}"/>
											<label>title</label>
											<input class="form-control" type="text" placeholder="title" id="postSubject" name="postSubject" value="${post.postSubject}"/>
											<p />
											<label>contents</label>
											<textarea class="form-control" type="text" placeholder="contents" id="postConts" name="postConts">${post.postConts}</textarea>
											<p />
											<input type="submit" class="btn-sm btn-primary shadow-none" value="수정완료">
											<input type="button" class="btn-sm shadow-none" onclick="history.back();" value="취소">
										</div>
									</form>
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
		function insertPost() {
			$.ajax({
				url : "/insertPost.json",
				type : "POST",
				dataType : "json",
				data : {
					col1 : $('#col1').val(),
					col2 : $('#col2').val(),
					col3 : $('#col3').val(),
					col4 : $('#col4').val()
				},
				success : function(response) {
					console.info(response);
					alert(response.msg);
					getTestTableList();
				}
			});
		}
	</script>
</body>
</html>
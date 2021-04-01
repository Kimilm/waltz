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

						<div class="col-md-12">
							<div class="card">
								<div class="card-body">
									someText
								</div>
							</div>
						</div>
					</div>
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
</body>
</html>
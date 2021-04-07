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
									<!-- title -->
									<div>
										<h5 class="px-2">${post.postSubject}</h5>
									</div>
									<!-- contents -->
									<div>
										<div class="border-top border-bottom">
											<div class="d-flex justify-content-between px-2">
												<div>${post.wrtrId}</div>
												<div>${post.hitCnt} ${post.wrtrDt}</div>
											</div>
										</div>
										<div class="p-2">${post.postConts}</div>
									</div>
									<!-- comment -->
									<div>
										<div class="border-top border-bottom px-2">
											comment
										</div>
										<div class="px-2">
											<div class="border mt-2">
												<div class="border-bottom px-2 bg-gray-200">commentTitle</div>
												<div class="px-2">
													commentContents
												</div>
											</div>
											
											<div class="border mt-2">
												<div class="border-bottom px-2 bg-gray-200">commentTitle</div>
												<div class="px-2">
													commentContents
												</div>
											</div>
											
											<div class="border mt-2">
												<div class="border-bottom px-2 bg-gray-200">commentTitle</div>
												<div class="px-2">
													commentContents
												</div>
											</div>
										</div>
									</div>
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
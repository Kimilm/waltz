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
					<c:if test="${post ne null}">
						<!-- Content Row -->
						<div class="row">
							<div class="col-md-12 mb-4">
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
													<div>${post.hitCnt}${post.wrtrDt}</div>
												</div>
											</div>
											<div class="p-2">${post.postConts}</div>
										</div>
										<!-- comment -->
										<div>
											<div class="border-top border-bottom px-2">comment</div>
											<div class="px-2">
												<div class="border mt-2">
													<div class="border-bottom px-2 bg-gray-200">commentTitle</div>
													<div class="px-2">commentContents</div>
												</div>

												<div class="border mt-2">
													<div class="border-bottom px-2 bg-gray-200">commentTitle</div>
													<div class="px-2">commentContents</div>
												</div>

												<div class="border mt-2">
													<div class="border-bottom px-2 bg-gray-200">commentTitle</div>
													<div class="px-2">commentContents</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End Content Row -->
					</c:if>

					<!-- Content Row -->
					<div class="row">
						<div class="col-md-12 mb-4">
							<div class="card">
								<div class="card-body">
								<!-- Page Heading -->
									<div class="d-sm-flex align-items-center justify-content-between mb-4">
										<p class="h3 mb-0 text-gray-800">${menu.menuNm}</p>
										<input id="menuCd" type="hidden" value="${menu.menuCd}" />
									</div>
									
									<table class="table table-hover table-sm">
										<thead>
											<tr class="d-flex text-center">
												<th class="col-1">번호</th>
												<th class="col-8">제목</th>
												<th class="col-1">작성자</th>
												<th class="col-1">조회수</th>
												<th class="col-1">작성일</th>
											</tr>
										</thead>
										<tbody>
											<tr class="d-flex">
												<td class="col-1 text-center">col 1</td>
												<td class="col-8">col 2</td>
												<td class="col-1 text-center">col 3</td>
												<td class="col-1 text-center">col 4</td>
												<td class="col-1 text-center">col 5</td>
											</tr>
										</tbody>
									</table>

									<div>
										<ul class="pagination pagination-sm justify-content-center mb-0">
											<li class="page-item"><a class="page-link" href>&laquo;</a></li>
											<li class="page-item"><a class="page-link" href>1</a></li>
											<li class="page-item"><a class="page-link" href>2</a></li>
											<li class="page-item"><a class="page-link" href>3</a></li>
											<li class="page-item"><a class="page-link" href>4</a></li>
											<li class="page-item"><a class="page-link" href>5</a></li>
											<li class="page-item"><a class="page-link" href>&raquo;</a></li>
										</ul>
									</div>
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
			getPostList();
		});
		
		function getPostList() {
			const menuCd = $('#menuCd').attr('value');
			/* log */
			console.log(menuCd);
			
			$.ajax({
				/* url : `/getPostList/${menuCd}`, */
				url : "/getPostList/" + menuCd,
				type : "GET",
				dataType : "json",
				success : function(response) {
					/* log */
					console.info(response);
					$('tbody').html('');
					$.each(response, function(index, value) {
						const date = new Date(value.wrtrDt);

						$('tbody').append(
							'<tr class="d-flex">' + 
								'<td class="col-1 text-center">' + value.postId + '</td>' + 
								'<td class="col-8">' + 
									'<a href="/post/' + value.postId + '">' + value.postSubject + '</a>' +
								'</td>' +
								'<td class="col-1 text-center">' + value.wrtrId + '</td>' +
								'<td class="col-1 text-center">' + value.hitCnt + '</td>' +
								'<td class="col-1 text-center">' + date.getMonth() + '/' + date.getDate() + '</td>' +
							'</tr>'
						);
					});
				}
			});
		}
	</script>
</body>
</html>
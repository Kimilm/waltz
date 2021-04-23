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
									<!-- Page Heading -->
									<div
										class="d-sm-flex align-items-center justify-content-between mb-4">
										<p class="h3 mb-0 text-gray-800">${menuDt[menuCd].menuNm}</p>
										<input id="menuCd" type="hidden" value="${menuCd}" />
									</div>

									<table class="table table-hover table-sm">
										<thead>
											<tr class="d-flex text-center">
												<th class="col-1">번호</th>
												<th class="col-7">제목</th>
												<th class="col-2">작성자</th>
												<th class="col-1">조회수</th>
												<th class="col-1">작성일</th>
											</tr>
										</thead>
										<tbody>
											<tr class="d-flex">
												<td class="col-1 text-center">col 1</td>
												<td class="col-7">col 2</td>
												<td class="col-2 text-center">col 3</td>
												<td class="col-1 text-center">col 4</td>
												<td class="col-1 text-center">col 5</td>
											</tr>
										</tbody>
									</table>
									
									<div class="row">
										<div class="col-md-4">
											<form class="form-inline mr-auto w-100 navbar-search" action="/bbs/${menuCd}" method="GET">
												<div class="input-group">
													<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" id="search" name="search">
													<div class="input-group-append">
														<button class="btn btn-primary" type="button">
															<i class="fas fa-search fa-sm"></i>
														</button>
													</div>
												</div>
											</form>
										</div>
										
										<div class="col-md-4">
											<input type="hidden" id="postCount" value="${postCount[menuCd]}" />
											<ul id="page" class="pagination pagination-sm justify-content-center mb-0">
												<li class="page-item"><a class="page-link" href>&laquo;</a></li>
												<li class="page-item"><a class="page-link" href>1</a></li>
												<li class="page-item"><a class="page-link" href>2</a></li>
												<li class="page-item"><a class="page-link" href>3</a></li>
												<li class="page-item"><a class="page-link" href>4</a></li>
												<li class="page-item"><a class="page-link" href>5</a></li>
												<li class="page-item"><a class="page-link" href>&raquo;</a></li>
											</ul>
										</div>
										
										<div class="col-md-4">
											<c:if test="${authMappInfo[menuCd += login.userGrpCd].updtYn eq 'Y'}">
												<div class="float-right">
													<a href="/bbs/${menuCd}/create"class="btn btn-sm btn-primary">글쓰기</a>
												</div>
											</c:if>
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
			setPages();
		});
		
		function getQueryMap(){
		    var url = document.location.href;
		    var qs = url.substring(url.indexOf('?') + 1).split('&');
		    for(var i = 0, result = {}; i < qs.length; i++){
		        qs[i] = qs[i].split('=');
		        result[qs[i][0]] = decodeURIComponent(qs[i][1]);
		    }
		    return result;
		}
		
		function getQuery() {
			var url = document.location.href;
		    var qs = url.substring(url.indexOf('?'));
		    
		    if (url.length == qs.length)
		    	return '';
		    return qs;
		}

		function getPostList() {
			const menuCd = $('#menuCd').attr('value');
			const get = getQuery();

			$.ajax({
				/* url : `/getPostList/${menuCd}`, */
				url : "/getPostList/" + menuCd + get,
				type : "GET",
				dataType : "json",
				success : function(response) {
					/* log */
					console.info(response);
					$('tbody').html('');
					$.each(response, function(index, value) {
						const date = new Date(value.wrtrDt);
						$('tbody').append(
							'<tr class="d-flex">'
							+ '<td class="col-1 text-center">'
								+ value.postId
							+ '</td>'
							+ '<td class="col-7">'
								+ '<a href="/post/' + value.postId + get + '">'
									+ value.postSubject
								+ '</a>'
							+ '</td>'
							/* + '<td class="col-7" onclick="getPost(this)">'
								+ value.postSubject
							+ '</td>' */
							+ '<td class="col-2 text-center">'
								+ value.wrtrId
							+ '</td>'
							+ '<td class="col-1 text-center">'
								+ value.hitCnt
							+ '</td>'
							+ '<td class="col-1 text-center">'
								+ date.getMonth() + '/'	+ date.getDate()
							+ '</td>'
							+ '</tr>'
						);
					});
				}
			});
		}
		
		function setPages() {
			const menuCd = $('#menuCd').attr('value');
			const postCount = $('#postCount').attr("value");
			const pages = parseInt(postCount / 20) + 1;
			
			const param = getQueryMap();
			let get = '';
			let curPage = 1;
			
			if(param['search'] != null)
				get = '&search=' + param['search'];
			
			if(param['page'] != null)
				curPage = parseInt(param['page']); 
			
			$('#page').html('');
			$('#page').append('<li id="prevPage" class="page-item"><a class="page-link" href>&laquo;</a></li>');
			for(let i = 0; i < pages; ++i) {
				const page = i + 1;
				const url = menuCd + '?page=' + page + get;
				
				let listTagClass;
				if (page != curPage)
					listTagClass = "page-item";
				else
					listTagClass = "page-item active";
				
				$('#page').append(
					'<li class="' + listTagClass + '">'
						+ '<a class="page-link" href="/bbs/'+ url + '">'+ page +'</a>'
					+ '</li>'
				);
			}
			$('#page').append('<li id="nextPage" class="page-item"><a class="page-link" href>&raquo;</a></li>');
			
			if (curPage == 1)
				$('#prevPage').addClass('disabled');
				
			if (curPage == pages)
				$('#nextPage').addClass('disabled');
		}
	</script>
</body>
</html>
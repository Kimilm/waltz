<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp"%>
<body>
<div class="col-md-12 mb-4">
	<div class="card">
		<div class="card-body">
			<!-- title -->
			<div>
				<h3 class="px-2">${post.postSubject}</h3>
				<input id="postId" type="hidden" value="${post.postId}" /> <input
					id="replyYn" type="hidden" value="${post.replyYn}" />
			</div>
			<!-- contents -->
			<div>
				<div class="border-bottom">
					<div class="d-flex justify-content-between px-2">
						<div>${post.wrtrId}</div>
						<div>${post.hitCnt}${post.wrtrDt}</div>
					</div>
				</div>
				<div class="p-2">${post.postConts}</div>
			</div>
			<!-- comment -->
			<div>
				<div class="border-top px-2">comment</div>
				<div id="replyList"></div>
				<div id="CreateComment" class="input-group mt-2">
					<input class="form-control" type="text"
						placeholder="comment Contents"></input>
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" onclick="">insert</button>
					</div>
				</div>
			</div>
			<c:if test="${post.wrtrId eq login.userId}">
				<div class="d-flex float-right mt-3">
					<a href="#" class="btn btn-sm btn-primary mr-1">답글</a> <a
						href="/updatePost/${post.postId}" class="btn btn-sm btn-info mr-1"
						onclick="updatePost()">수정</a>
					<button onclick="deletePost()" class="btn btn-sm btn-danger">삭제</button>
				</div>
			</c:if>
		</div>
	</div>
</div>
</body>
</html>


<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/user/main">
		<div class="sidebar-brand-text mx-3">Waltz</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active">
		<a class="nav-link" href="/">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Dashboard</span>
		</a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">menu</div>

	<!-- menu -->
	<c:forEach items="${sessionScope.menuMt}" var="mt">
		<li class="nav-item">
			<a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#${mt.menuCd}" aria-expanded="true" aria-controls="${mt.menuCd}">
				<i class="fas fa-fw fa-list-alt"></i>
				<span>${mt.menuNm}</span>
			</a>
			<div id="${mt.menuCd}" class="collapse" aria-labelledby="heading${mt.menuCd}" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<c:forEach items="${sessionScope.menuDt}" var="dt">
						<c:if test="${mt.menuCd eq dt.prntMenuCd}">
							<a class="collapse-item" href="${dt.menuUrl}">${dt.menuNm}</a>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</li>
	</c:forEach>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->
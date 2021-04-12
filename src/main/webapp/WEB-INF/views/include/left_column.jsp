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
		<a class="nav-link" href="/user/main">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Dashboard</span>
		</a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">menu</div>

	<!-- menu -->
	<c:forEach items="${menuMt}" var="mt">
		<li class="nav-item">
			<a class="nav-link collapsed" href="" data-toggle="collapse" data-target="#${mt.value.menuCd}" aria-expanded="true" aria-controls="${mt.value.menuCd}">
				<i class="fas fa-fw fa-list-alt"></i>
				<span>${mt.value.menuNm}</span>
			</a>
			<div id="${mt.value.menuCd}" class="collapse" aria-labelledby="heading${mt.value.menuCd}" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<c:forEach items="${menuDt}" var="dt">
						<c:if test="${mt.value.menuCd eq dt.value.prntMenuCd}">
							<a class="collapse-item" href="${dt.value.menuUrl}">${dt.value.menuNm}</a>
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
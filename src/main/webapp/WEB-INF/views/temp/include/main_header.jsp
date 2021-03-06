<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--main_header.jsp--%>
<%-- Main Header --%>
<style>
    .navbar-nav > li > a {padding-top : 15px !important; padding-bottom : 15px !important; padding-right : 5px !important;}
</style>
<header class="main-header">

    <%-- Logo --%>
    <a href="/user/home" class="logo">
        <%-- mini logo for sidebar mini 50x50 pixels --%>
        <span class="logo-mini"><b>M</b>B</span>
        <%-- logo for regular state and mobile devices --%>
        <span class="logo-lg"><b>MVC</b> Board</span>
    </a>

    <%-- Header Navbar --%>
    <nav class="navbar navbar-static-top" role="navigation">
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <c:if test="${not empty login}">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/resources/template/dist/img/user1-128x128.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${login.userNm}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <img src="/resources/template/dist/img/user1-128x128.jpg" class="img-circle" alt="User Image">
                                <p>${login.userNm}
                                    <small>
                                       κ°μμΌμ : ${login.userJoinDate}
                                    </small>
                                </p>
                            </li>
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">κ²μκΈ</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">μΆμ²κΈ</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">λΆλ§ν¬</a>
                                    </div>
                                </div>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="/user/info" class="btn btn-default btn-flat"><i
                                            class="fa fa-info-circle"></i><b> λ΄ νλ‘ν</b></a>
                                </div>
                                <div class="pull-right">
                                    <a href="/user/logout" class="btn btn-default btn-flat"><i
                                            class="glyphicon glyphicon-log-out"></i><b> λ‘κ·Έμμ</b></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${empty login}">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${path}/user/default-user.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">νμκ°μ λλ λ‘κ·ΈμΈ</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <img src="/dist/img/default-user.png" class="img-circle" alt="User Image">
                                <p>
                                    <b>νμκ°μ λλ λ‘κ·ΈμΈν΄μ£ΌμΈμ</b>
                                    <small></small>
                                </p>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="${path}/user/register" class="btn btn-default btn-flat"><i
                                            class="fa fa-user-plus"></i><b> νμκ°μ</b></a>
                                </div>
                                <div class="pull-right">
                                    <a href="${path}/user/login" class="btn btn-default btn-flat"><i
                                            class="glyphicon glyphicon-log-in"></i><b> λ‘κ·ΈμΈ</b></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>
